package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getParticularProjectTest {

	@Test
	public void getParticularProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1218");
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		//long time = resp.getTime();
		//validate.assertThat().
		validate.log().all();
	}
}
