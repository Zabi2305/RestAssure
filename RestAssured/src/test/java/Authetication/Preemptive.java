package Authetication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Preemptive {
	@Test
	public void preemptiveAuth() {
		//prerequisite
		baseURI="http://localhost";
		port=8084;
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		//perform action
		.when()
		.get("/login")
		//validation
		.then()
		.assertThat().statusCode(202)
		.log().all();	
	}

}
