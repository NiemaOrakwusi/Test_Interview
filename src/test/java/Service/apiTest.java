package Service;

import Service.Base.BaseApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class apiTest extends BaseApi {

    @BeforeMethod
    public void getData() throws IOException {
        RestAssured.reset();
        RestAssured.baseURI = proAPI.getProperty("URL");
        RestAssured.port = 3030;

    }

    @Test

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
    @Test
    public void PutUserInfo() {
        given()
                .body("{"
                        + "\'userId\': 1234,"
                        + "\'id\': 783737,"
                        + "\'title\': \'Post Updates\',"
                        + "\'body\': \'Niema's Inserts\'"
                        + "}"
                )
                .when().log().ifValidationFails()
                .request("PUT", "/comments").
                then()
                .statusCode(201).assertThat();
        Reporter.log("Validated Status Code for PUT");
     }
    @Test
    public void GetResponse()
    {
        RestAssured.baseURI = proAPI.getProperty("URL");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users/" + proAPI.getProperty("getId"));
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.contains(proAPI.getProperty("getBody")), true , "Response body contains" + proAPI.getProperty("getBody"));
        int statCode = response.getStatusCode();
        Assert.assertEquals(statCode, Integer.parseInt(proAPI.getProperty("getStatusCode")), "Status Code Returned");
        Reporter.log("Validate GET was Successful with Status Code ");
    }


}
