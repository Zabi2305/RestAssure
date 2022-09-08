package ReqresAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.jsonObject;

import  static io.restassured.RestAssured.*;

public class PatchTheProject {
	@Test
	public void patchProject() {
		baseURI="https://reqres.in";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "MarkZukerberg");
		jobj.put("job", "fbcreater");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.patch("/api/users/2")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}

}
