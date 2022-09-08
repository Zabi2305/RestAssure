package Authetication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.addProject;

import  static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void BearTokenAuth() {
		baseURI="https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Dhilla");
		
		given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		//action
		.when().post("/user/repos")
		//validation
		.then().log().all();			
	}
}
