package staticAndDynamicValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

public class StaticValidation {
	@Test
	public void staticvalidate() {
		//pre requisition
		String expData="TY_PROJ_007";
		baseURI="http://localhost";
		port=8084;
		//action
		Response resp = when()
		.get("/projects");
	//.then()
	//.log().all();
		//validation
		 String actData = resp.jsonPath().get("[1].projectId");
		 System.out.println(actData);
		 Assert.assertEquals(actData, expData);
		 System.out.println("Data is Verified");
		// resp.equals(expData)
		// resp.prettyPrint();
	}

}
