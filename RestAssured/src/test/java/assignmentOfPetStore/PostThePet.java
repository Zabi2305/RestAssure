package assignmentOfPetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class PostThePet {
	@Test
	public void CreatePet() {
		JSONObject jobj = new JSONObject();
		jobj.put("id", 123);
		jobj.put("petId", 143);
		jobj.put("quantity", 5);
		jobj.put("shipDate", "2022-09-06T16:55:02.239Z");
		jobj.put("status", "placed");
		jobj.put("complete", true);
		
		baseURI="https://petstore.swagger.io/v2";
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/store/order")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
	}
}
