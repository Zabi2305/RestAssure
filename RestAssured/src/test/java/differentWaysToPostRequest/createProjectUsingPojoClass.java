package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.addProject;

public class createProjectUsingPojoClass {
	@Test
	public void addProject() {
		addProject proj = new addProject("Mummy", "respect", "ongoing", 4);
	
		given()
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201);
	}

}
