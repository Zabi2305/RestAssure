package ReqresAssignment;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProject {
	@Test
	public void addProject() {
		baseURI="https://reqres.in";
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		JSONObject jobj = new JSONObject();
		jobj.put("name", "MarkZ"+ranNum);
		jobj.put("job", "fb");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
