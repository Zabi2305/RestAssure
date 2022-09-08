package crudOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class addProjectTest {
	@Test
	public void Create() {
		
		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "MD");
		jobj.put("projectName", "ushafans"+ranNum);
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 143);
		
		
		
		//precondition
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		//requestbody
		.when()
		.post("http://localhost:8084/addProject")
		//validation
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
