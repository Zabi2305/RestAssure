package differentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createProjectUsingHashMap {
	@Test
	public void develop() {
		Random ran = new Random();
		int ranNum = ran.nextInt(50);
		HashMap hp = new HashMap();
		hp.put("createdBy", "Dhoni");
		hp.put("projectName", "CSK"+ranNum);
		hp.put("status", "OnGoing");
		hp.put("teamSize", 11);
		
		baseURI="http://localhost";
		port=8084;
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("/addProject")
		.then().assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
