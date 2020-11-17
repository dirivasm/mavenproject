package pom;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class AutomationEndpointPractice {

    public AutomationEndpointPractice(String URI){
        RestAssured.baseURI = URI;
    }

    public String returnBirthday(String name) 
    {
        RequestSpecification httprRequest = RestAssured.given();
        Response response = httprRequest.request(Method.GET, "/api/characters?name="+name);
        JsonArray array = response.as(JsonArray.class);
        JsonObject jsonObject = array.get(0).getAsJsonObject();
		return jsonObject.get("birthday").getAsString();
    }
}