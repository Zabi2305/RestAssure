package RequestChaning;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class postAndGettheProjectusingPathparameterInRequestChaining {
	//post and get the project using request chaining
	@Test
	public void createpro() {
		Random ran = new Random();
		int ranNum = ran.nextInt(150);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "oneplus");
		jobj.put("projectName", "Android"+ranNum);
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 25);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("/addProject");
		
		//Capture the projectId
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//create a get request and pass the proId as the path parametre
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();	
	}
}
