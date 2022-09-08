package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.jsonObject;

public class createProjectUsingJsonObject {
	@Test
	public void createNewProject() {
		jsonObject jobj = new jsonObject();
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj.jsonObjectmethod())
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
