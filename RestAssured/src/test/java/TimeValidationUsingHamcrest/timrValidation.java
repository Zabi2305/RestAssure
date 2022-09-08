package TimeValidationUsingHamcrest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class timrValidation {
	@Test
	public void ValidateTime() {
		baseURI="http://localhost";
		port=8084;
		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Ambati");
		jobj.put("projectName", "raidu"+ranNum);
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 143);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		
		.log().all();
	}

}
