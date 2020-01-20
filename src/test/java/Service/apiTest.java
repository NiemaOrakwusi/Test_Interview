/*
 Author: Dr. Niema C. Orakwusi
Created: January 18, 2020
This is a Maven, Testng, Rest Assured Api Testing Framework
Description : This project will test an api GET, POST, PUT
as well as from the UI Create a new User and Filter for that user

 */
package Service;

import Service.Base.BaseApi;
import Utils.Listeners.Listener;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;


//This test performs a GET, POST, and PUT Rest Assured API Test
@Listeners(Listener.class)
public class apiTest extends BaseApi {

    @BeforeMethod
    public void getData() throws IOException {
        RestAssured.reset();
        RestAssured.baseURI = proAPI.getProperty("URL");
        RestAssured.port = 3030;

    }
    @AfterMethod
    //End the Suite
    public void tearDown() {
        RestAssured.reset();

    }

    @Test(description = "POST New User into /posts ")
    public void PostNewUser() throws IOException {
        given()
                    .body("{"
                            + "\'userId\': 77,"
                            + "\'id\': 37743,"
                            + "\'name\': \'Niema Orakwusi\',"
                            + "\'username\': \'niemaorakwusi\'"
                            + "\'email\': \'niemaorakwusi@gmail.com\'"
                            + "\'address\': \'123 School Street\'"
                            + "\'suite\': \'forever 1\'"
                            + "\'city\': \'Atlanta\'"
                            + "\'zip\': \'30346\'"
                            + "\'geo\': \'{\'"
                            + "\'lat\': \'33.7490\'"
                            + "\'lng\': \'84.3880\'"
                            + "}"
                    )
                    .when().log().ifValidationFails()
                    .request("POST", "/posts").
                    then()
                    .statusCode(201).assertThat();
        Reporter.log("Validated Status Code for POST");
    }
    @Test(description = "PUT User Info into /comments")
    public void PutUserInfo() {
        given()
               // .contentType(ContentType.TEXT)
                .body("{"
                        + "\'postId\': 12,"
                        + "\'id\': 53139,"
                        + "\'name\': est post method - Niema_Test Update,"
                        + "\'email\': Eliseo@gardner.biz - Niema Test Update,"
                        + "}"
                )
                .when().log().ifValidationFails()
                .request("PUT", "/comments/{id}", 53139).
                then()
                .statusCode(200).assertThat();
        Reporter.log("Validated Status Code for PUT");
     }
    @Test(description = "GET user from /users")
    public void GetResponse()
    {

        given()

                .when().log().ifValidationFails()
                .get("/users/{userId}",1734)
                .then()
                .statusCode(200).assertThat()
                .body("name", equalTo("Automation Tester"));
        Reporter.log("Validated Status Code for GET");

    }


}
