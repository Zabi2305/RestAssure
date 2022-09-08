package RequestChaning;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.addProject;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class postAndPutTheProjectusingPathParameter {
	@Test
	public void postAndPutThePro() {
		Random ran = new Random();
		int ranNum = ran.nextInt(25);
		addProject create = new addProject("Samsung", "Flod"+ranNum, "Running", 225);
		baseURI="http://localhost";
		port=8084;
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(create)
		.when()
		.post("/addProject");
		
		//get the projectid
		String pubg = resp.jsonPath().get("projectId");
		System.out.println(pubg);
		resp.then().log().all();
		
		//update the project using paramparameter
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Nokia");
		jobj.put("projectName", "Basic");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 125);
		
		given()
		.pathParam("project", pubg)
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("/projects/{project}")
		.then()
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
