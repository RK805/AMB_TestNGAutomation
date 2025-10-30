package tests;

import Utility.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import org.testng.annotations.BeforeClass;;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiDomeAppliaction extends BasePage {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }


    @Test
    public void validateSingleUserSchema() {
        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/user_schema.json"));
    }


    @Test(dependsOnMethods = {"validateSingleUserSchema"})
    public void createUserSchemaValidation() {
        String payload = """
                {
                    "name": "John Doe",
                    "job": "Software Developer"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(201)  // should work
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/create_user_schema.json"));
    }

    @Test(dependsOnMethods = {"validateSingleUserSchema","createUserSchemaValidation"})
    public void updateUserSchemaValidation() {
        String payload = """
                {
                    "name": "Jane Doe",
                    "job": "QA Engineer"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/update_user_schema.json"));
    }

    @Test(dependsOnMethods = {"validateSingleUserSchema","createUserSchemaValidation","updateUserSchemaValidation"})
    public void deleteUserTest() {
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }
}
