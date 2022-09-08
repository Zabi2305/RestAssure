package assignmentOfPetStore;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class GetThePet {
	@Test
	public void get() {
		
		baseURI="https://petstore.swagger.io/v2";
		
		when()
		.get("/store/inventory")
		.then()
		.statusCode(200)
		.log().all();
	}

}
