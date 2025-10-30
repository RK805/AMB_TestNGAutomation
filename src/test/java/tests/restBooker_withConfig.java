package tests;

import Utility.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class restBooker_withConfig {

    private static int bookingId;

    @Test
    public void testCreateBooking() {

        String firstname = ConfigReader.get("firstname");
        String lastname = ConfigReader.get("lastname");
        String totalprice = ConfigReader.get("totalprice");
        String depositpaid = ConfigReader.get("depositpaid");
        String checkin = ConfigReader.get("checkin");
        String checkout = ConfigReader.get("checkout");
        String additionalneeds = ConfigReader.get("additionalneeds");

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

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .log().all()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200)
                .body("bookingid", is(notNullValue()))
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
                .extract().response();

        bookingId = response.path("bookingid");
        System.out.println("✅ Booking created successfully with ID: " + bookingId);
        Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");
    }

    @Test(dependsOnMethods = "testCreateBooking")
    public void validateCreatedBookingSchema() {
        File schemaFile = new File("src/test/resources/schemas/bookingSchema.json");

        RestAssured.given()
                .when()
                .log().all()
                .get("https://restful-booker.herokuapp.com/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));

        System.out.println("✅ Booking schema validated successfully for ID: " + bookingId);
    }
}
