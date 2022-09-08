package crudOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class updateProjectTest {
	@Test
	public void updateProject() {
		Random ran = new Random();
		int ranNum = ran.nextInt(50);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Kalpana");
		jobj.put("projectName", "jangali"+ranNum);
		jobj.put("status", "completed");
		jobj.put("teamSize", 45);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1817")
		.then()
		.statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}
