package crudOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class deleteProjectTest {
	@Test
	public void Delete() {
		given()
		.delete("http://localhost:8084/projects/TY_PROJ_1818")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
	}

}
