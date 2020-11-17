package pom;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import pojo.CharacterPojo;
import java.util.List;
import java.util.ArrayList;


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

    public List<CharacterPojo> returnCharacters(){
        RequestSpecification httprRequest = RestAssured.given();
        Response response = httprRequest.request(Method.GET, "/api/characters");
        JsonArray array = response.as(JsonArray.class);
        List<CharacterPojo> listCharacters = new ArrayList<CharacterPojo>();  
        for (int i = 0; i < array.size(); i++) {
            JsonObject jsonObject = array.get(i).getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            String portrayed = jsonObject.get("portrayed").getAsString();
            listCharacters.add(new CharacterPojo(name, portrayed));
        }
        return listCharacters;
    }
}