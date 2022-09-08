package RequestChaning;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.addProject;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class postAndDeleteTheProjectUsingParamparameter {
	//post and delete the project using request chaining
	@Test
	public void createandDelete() {
		Random ran = new Random();
		int ranNum = ran.nextInt(200);
		addProject addpro = new addProject("AquaMan", "Gelli"+ranNum, "Completed", 85);
		//prerequisition
		baseURI="http://localhost";
		port=8084;
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(addpro)
		.when()
		.post("/addProject");
		
		
		//capture the projectID
		String projId = resp.jsonPath().get("projectId");
		System.out.println(projId);
		resp.then().log().all();
		
		//delete the project by using paramParameter
		given()
		.pathParam("pro", projId)
		.when()
		.delete("/projects/{pro}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
