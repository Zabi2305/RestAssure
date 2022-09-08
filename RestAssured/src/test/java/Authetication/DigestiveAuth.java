package Authetication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuth {

	@Test
	public void digestBasicAuth() {
		//Prerequisite
		baseURI="http://localhost";
		port=8084;
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		//perform action
		.when()
		.get("/login")
		//validation
		.then().assertThat().statusCode(202)
		.log().all();
	}
}
