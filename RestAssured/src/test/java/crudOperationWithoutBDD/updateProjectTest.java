package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.val;

public class updateProjectTest {
	@Test
	public void updateProject() {
		// create a json Object for put
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Satish");
		 jobj.put("projectName", "pavillion");
		 jobj.put("status", "completed");
		 jobj.put("teamSize", 12);
		 
		 //request body and content type
		 RequestSpecification resspe = RestAssured.given();
		 resspe.body(jobj);
		 resspe.contentType(ContentType.JSON);
		 
		 //Validation of the response
		 Response response = resspe.put("http://localhost:8084/projects/TY_PROJ_402");
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
		 validate.log().all();
		 
	}

}
