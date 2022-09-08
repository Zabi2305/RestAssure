package crudOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getAllProjectsTest {
	@Test
	public void getAllProject() {
		given()
		.get("http://localhost:8084/projects")
		.then().contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
