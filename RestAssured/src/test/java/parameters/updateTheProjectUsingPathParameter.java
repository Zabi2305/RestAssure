package parameters;

import org.testng.annotations.Test;

import pojoClass.addProject;

import  static io.restassured.RestAssured.*;

public class updateTheProjectUsingPathParameter {
	@Test
	public void updateProject() {
		baseURI="http://localhost";
		port=8084;
		
		addProject pubj = new addProject("Bisleri", "H20","ongoing", 120);
		given()
		.body(pubj)
		.pathParam("projId", "TY_PROJ_1220");
		 
		
		
		
	}

}
