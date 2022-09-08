package ReqresAssignment;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import static io.restassured.RestAssured.*;

public class deleteTheProject {
@Test
public void deleteProject() {
	baseURI="https://reqres.in";
	when()
	.delete("/api/users/2")
	.then()
	.statusCode(204)
	.log().all();
}
}
