package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

import java.io.File;

public class createProjectUsingFile {
	@Test
	public void addPro() {
		File path = new File("./src/main/resources/make.json");
		baseURI="http://localhost";
		port=8084;
		given()
		.contentType(ContentType.JSON)
		.body(path)
		.when()
		.post("/addProject")
		.then().assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
