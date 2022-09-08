package Authetication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class basicAuth {
	
	@Test
	public void Basic() {
		//prerequisite
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		//perform action
		.when()
		.get("/login")
		//validation
		.then()
	//	.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(202)
		.log().all(); 
	}

}
