package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getUsingPathParameter {
	@Test
	public void gettheProject() {
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.when()
		.pathParam("projid", "TY_Proj_003")
		.get("/projects/{projid}")
		.then()
		.log().all();
				
	}

}
