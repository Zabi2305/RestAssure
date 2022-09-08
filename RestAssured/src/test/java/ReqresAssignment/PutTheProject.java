package ReqresAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutTheProject {
	@Test
	public void updateTheProject() {
	JSONObject jobj = new JSONObject();	
	jobj.put("name", "MarkZukerberg");
	jobj.put("job", "fbOwner");
	
	baseURI="https://reqres.in";
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.put("/api/users/2")
	.then()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.log().all();
	}

}
