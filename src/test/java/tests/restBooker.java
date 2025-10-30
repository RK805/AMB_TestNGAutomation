package tests;

import Utility.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class restBooker {

    private static int bookingId;

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() throws Exception {
        ExcelUtils excel = new ExcelUtils("src/test/resources/schemas/apiRestAssured.xlsx");
        return excel.getSheetData("BookingData");
    }

    @Test( dataProvider = "bookingData")
    public void testCreateBooking(String firstname, String lastname, String totalprice,
                                  String depositpaid, String checkin, String checkout, String additionalneeds) {

        // Build JSON body dynamically
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

        // POST request
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

    @Test( dependsOnMethods = "testCreateBooking")
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
