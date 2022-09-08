package staticAndDynamicValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicValidation {
	@Test
	public void dynamicValidate() {
		//prerequsition
		String excData="TY_PROJ_805";
		baseURI="http://localhost";
		port=8084;
				//action
		Response resp = when().get("/projects");
		
		//validation
		boolean flag=false;
		List<String> pIds = resp.jsonPath().get("projectId");
		
			for (String projectId : pIds) {
			if (projectId.equalsIgnoreCase(excData)) {
				flag=true;
			}
			}
		Assert.assertTrue(flag);
		System.out.println("data is verified");
		resp.then().log().all();
		
	}

}
