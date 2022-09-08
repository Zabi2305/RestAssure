package ReqresAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetTheProject {
	@Test
	public void getThePro() {
		baseURI="https://reqres.in";
		when()
		.get("/api/users/2")
		.then()
		.log().all();
	}
}
