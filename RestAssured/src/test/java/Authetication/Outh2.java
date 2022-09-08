package Authetication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

public class Outh2 {
	@Test
	public void outh20Authnetocation(){
		//create a request to generate acces token
		
		 Response resp = given()
		.formParam("client_id", "Falcon")
		.formParam("client_secret", "b91e2122edf113e5163260439b2cb560")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		 
		System.out.println(resp.asPrettyString());
		
		 //Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("pid", 3742)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{pid}/eggs-count")
		.then().log().all();
		
	}

}
