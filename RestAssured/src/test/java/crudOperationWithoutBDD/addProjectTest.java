package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectTest {
	@Test
	public void Create() {
		//json body Created
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Zabiulla");
		jobj.put("projectName", "vikram");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		//request body and content
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//validation of the response
		Response resp = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validateres = resp.then();
		validateres.assertThat().contentType(ContentType.JSON);
		validateres.assertThat().statusCode(201);
		validateres.log().all();
	}
}
