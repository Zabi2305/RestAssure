package assignmentOfPetStore;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetTheParticularPet {
	@Test
	public void getOnlyOnePet() {
		
		baseURI="https://petstore.swagger.io/v2";
		given()
		.pathParam("orderId", 123)
		.when()
		.get("/store/order/{orderId}")
		.then().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();	
	}
}
