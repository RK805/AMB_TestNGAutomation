package tests;

import Utility.BaseTest;
import Utility.PayloadUtils;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.http.ContentType;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserSchemaValidation() {
        String payload = PayloadUtils.getPayload("update_user.json");

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .when()
                .put("/users/2")
                .then()
                .log().all()
                .statusCode(401)
                .body(matchesJsonSchemaInClasspath("schemas/update_user_schema.json"));
    }
}