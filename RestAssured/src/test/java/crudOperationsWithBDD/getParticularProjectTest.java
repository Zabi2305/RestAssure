package crudOperationsWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getParticularProjectTest {
	@Test
	public void getOneProject() {
		given()
		.get("http://localhost:8084/projects/TY_PROJ_805")
		.then()
		.log().all();
		
	}

}
