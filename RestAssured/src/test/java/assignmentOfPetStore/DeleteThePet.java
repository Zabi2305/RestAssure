package assignmentOfPetStore;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class DeleteThePet {
	@Test
	public void delPet() {
		baseURI="https://petstore.swagger.io/v2";
		given()
		.pathParam("orderId", 123)
		.when()
		.delete("/store/order/{orderId}")
		.then().log().all();
	}

}
