package Service;



import Service.Base.BaseApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class apiTest extends BaseApi {

    @Test
    public void PostNewUserResponse()
    {
        RestAssured.baseURI = proAPI.getProperty("URL");
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", proAPI.getProperty("postid"));
        Reporter.log("POST ID");
        requestParams.put("name", proAPI.getProperty("postName"));
        Reporter.log("POST Name");
        requestParams.put("UserName", proAPI.getProperty("postUserName"));
        Reporter.log("POST UserName");
        requestParams.put("email", proAPI.getProperty("postEmail"));
        Reporter.log("POST Email");
        requestParams.put("address",  proAPI.getProperty("postAddress"));
        Reporter.log("POST Address");
        requestParams.put("suite",  proAPI.getProperty("postSuite"));
        Reporter.log("POST Suite");
        requestParams.put("city",  proAPI.getProperty("postCity"));
        Reporter.log("POST City");
        requestParams.put("zip",  proAPI.getProperty("postZip"));
        Reporter.log("POST Zip");
        requestParams.put("geo",  proAPI.getProperty("postGeo"));
        Reporter.log("POST geo");
        requestParams.put("lat",  proAPI.getProperty("postLat"));
        Reporter.log("POST lat");
        requestParams.put("lng",  proAPI.getProperty("postLng"));
        Reporter.log("POST lng");

        request.body(requestParams.toString());//toJSONString());
        Response response = request.post("/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(proAPI.getProperty("PostStatusCode")));
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
        Reporter.log("Validate POST was Successful with Status Code");
    }
    @Test
    public void PutUserInfo() {


        RestAssured.baseURI = proAPI.getProperty("URL");
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", proAPI.getProperty("putId"));
        Reporter.log("PUT ID");
        requestParams.put("name", proAPI.getProperty("putName"));
        Reporter.log("PUT name");
        requestParams.put("email", proAPI.getProperty("putEmail"));
        Reporter.log("PUT email");
        requestParams.put("body", proAPI.getProperty("putBody"));
        Reporter.log("PUT body");

        request.body(requestParams.toString());
        Response response = request.put("/comments/" + proAPI.getProperty("putPostId"));

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, Integer.parseInt(proAPI.getProperty("PutStatusCode")));
        Reporter.log("Validate PUT was Successful with Status Code ");
    }
    @Test
    public void GetPostsResponse()
    {
        RestAssured.baseURI = proAPI.getProperty("URL");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/" + proAPI.getProperty("getId"));
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.contains(proAPI.getProperty("getBody")), true , "Response body contains" + proAPI.getProperty("getBody"));
        int statCode = response.getStatusCode();
        Assert.assertEquals(statCode, Integer.parseInt(proAPI.getProperty("getStatusCode")), "Status Code Returned");
        Reporter.log("Validate GET was Successful with Status Code ");
    }


}
