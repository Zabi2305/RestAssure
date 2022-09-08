package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProjectTest {
	@Test
	public void deleteProject() {
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1815");
		resp.then().assertThat().statusCode(204);
		resp.then().log().all();
	}

}
