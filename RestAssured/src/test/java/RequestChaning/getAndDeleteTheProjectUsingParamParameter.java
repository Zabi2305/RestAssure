package RequestChaning;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getAndDeleteTheProjectUsingParamParameter {
	@Test
	public void getAndDelete() {
		//String acpRes="TY_PROJ_1207";
		baseURI="http://localhost";
		port=8084;
		Response resp = given()
		.get("/projects/TY_PROJ_1220");
		resp.then().log().all();
		
		//capture the projectID
		String pob = resp.jsonPath().get("projectId");
		System.out.println(pob);
		resp.then().log().all();
		
		//delete the project by using paramParameter
		given()
		.pathParam("pro", pob)
		.when()
		.delete("/projects/{pro}")
		.then()
		.assertThat().statusCode(204).log().all();
	}

}
