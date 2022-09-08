package UsingLibrariesPerformCrudOperation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtilities.BaseClassApi;
import genericUtilities.DataBaseUtility;
import genericUtilities.EndPointLibrary;
import genericUtilities.IConstants;
import genericUtilities.JavaUtility;
import genericUtilities.ProjectLibrary;
import io.restassured.http.ContentType;

public class PostTheProject {
	@Test
	public void create() {
		JavaUtility jlib = new JavaUtility();
		BaseClassApi blib = new BaseClassApi();
		DataBaseUtility dlib = new DataBaseUtility();
		
		ProjectLibrary poj = new ProjectLibrary("Sukesh", "Sukki"+jlib.getRandomNumber(), "coming", 20);
		
		baseURI="http://localhost";
		port=8084;
		given()
		//.auth().basic(IConstants.appUserName, IConstants.appPassword)
		.body(poj)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointLibrary.createProject)
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
