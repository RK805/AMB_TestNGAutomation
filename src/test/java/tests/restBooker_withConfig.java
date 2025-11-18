package tests;

import Utility.ConfigReader;
import Utility.SchemaGeneratorUtil;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class restBooker_withConfig {

    private static final Logger logger = LoggerFactory.getLogger(restBooker_withConfig.class);
    private static int bookingId;

    private static final String GENERATED_SCHEMA_FOLDER = "src/test/resources/generatedSchemas";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        logger.info("Base URI set to: {}", RestAssured.baseURI);
    }

    @Test
    public void testCreateBooking() {
        logger.info("Starting test: testCreateBooking");

        long startTime = System.currentTimeMillis();

        try {
            // Read data from config
            String firstname = ConfigReader.get("firstname");
            String lastname = ConfigReader.get("lastname");
            String totalprice = ConfigReader.get("totalprice");
            String depositpaid = ConfigReader.get("depositpaid");
            String checkin = ConfigReader.get("checkin");
            String checkout = ConfigReader.get("checkout");
            String additionalneeds = ConfigReader.get("additionalneeds");

            // Prepare request body
            String requestBody = String.format(""" 
                    {
                      "firstname": "%s",
                      "lastname": "%s",
                      "totalprice": %s,
                      "depositpaid": %s,
                      "bookingdates": {
                        "checkin": "%s",
                        "checkout": "%s"
                      },
                      "additionalneeds": "%s"
                    }
                    """, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);

            File schemaFile = new File("src/test/resources/schemas/createBookingSchema.json");

            // Send POST request
            Response response = given()
                    .log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/booking")
                    .then()
                    .log().ifValidationFails(LogDetail.ALL)
                    .extract()
                    .response();

            int statusCode = response.getStatusCode();
            logger.info("📡 Response Status Code: {}", statusCode);
            logger.info("📦 Response Body: {}", response.asString());

            switch (statusCode) {
                case 200:
                case 201:
                    logger.info("✅ Booking created successfully.");
                    response.then()
                            .body("bookingid", is(notNullValue()))
                            .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));

                    bookingId = response.path("bookingid");
                    Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");

                    // Generate and store schema in a single stable file
                    SchemaGeneratorUtil.generateSchemaFromJson(
                            response.asPrettyString(),
                            GENERATED_SCHEMA_FOLDER,
                            "CreateBookingSchema"
                    );
                    break;

                case 400:
                    logger.error("❌ Bad Request: Invalid or missing data.");
                    Assert.fail("400 Bad Request - Check input data.");
                    break;

                case 401:
                    logger.error("🔒 Unauthorized: Authentication token missing or invalid.");
                    Assert.fail("401 Unauthorized.");
                    break;

                case 403:
                    logger.error("🚫 Forbidden: Access denied.");
                    Assert.fail("403 Forbidden.");
                    break;

                case 404:
                    logger.error("❓ Not Found: Endpoint /booking not found.");
                    Assert.fail("404 Not Found.");
                    break;

                case 500:
                case 502:
                case 503:
                    logger.error("💥 Server Error ({}): Try again later.", statusCode);
                    Assert.fail("Server error: " + statusCode);
                    break;

                default:
                    logger.warn("⚠️ Unexpected status code received: {}", statusCode);
                    Assert.fail("Unexpected status code: " + statusCode);
            }

        } catch (Exception e) {
            logger.error("💣 Exception during booking creation: {}", e.getMessage(), e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        long totalTime = System.currentTimeMillis() - startTime;
        logger.info("⏱️ Total time for POST /booking: {} ms", totalTime);
        Assert.assertTrue(totalTime < 8000, "Performance issue: API took too long (" + totalTime + " ms)");
    }

    @Test(dependsOnMethods = "testCreateBooking")
    public void validateCreatedBookingSchema() {
        logger.info("Starting test: validateCreatedBookingSchema for bookingId={}", bookingId);
        long startTime = System.currentTimeMillis();

        try {
            File schemaFile = new File("src/test/resources/schemas/bookingSchema.json");

            Response response = given()
                    .log().uri()
                    .log().method()
                    .log().headers()
                    .when()
                    .get("/booking/" + bookingId)
                    .then()
                    .extract()
                    .response();

            int statusCode = response.getStatusCode();
            logger.info("📡 GET /booking Status Code: {}", statusCode);

            if (statusCode == 200) {
                logger.info("✅ Booking schema validated successfully for ID: {}", bookingId);
                response.then().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));

                // Generate and save schema in a stable single file
                SchemaGeneratorUtil.generateSchemaFromJson(
                        response.asPrettyString(),
                        GENERATED_SCHEMA_FOLDER,
                        "GetBookingSchema"
                );
            } else if (statusCode == 404) {
                logger.error("❌ Booking ID {} not found.", bookingId);
                Assert.fail("404 Not Found - Booking not found.");
            } else if (statusCode >= 500) {
                logger.error("💥 Server Error during booking fetch ({}).", statusCode);
                Assert.fail("Server error: " + statusCode);
            } else {
                logger.warn("⚠️ Unexpected response code: {}", statusCode);
                Assert.fail("Unexpected response code: " + statusCode);
            }

        } catch (Exception e) {
            logger.error("💣 Exception while validating booking schema: {}", e.getMessage(), e);
            Assert.fail("Schema validation failed due to exception: " + e.getMessage());
        }

        long totalTime = System.currentTimeMillis() - startTime;
        logger.info("⏱️ Total time for GET /booking: {} ms", totalTime);
        Assert.assertTrue(totalTime < 8000, "GET /booking took too long (" + totalTime + " ms)");
    }
}