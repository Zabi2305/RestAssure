package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.addProject;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class postTheProjectUsingDataProvider {
	@Test(dataProvider = "punk")
	public void createProject(String createdBy,String projectName,String status,int teamSize) {
		addProject name = new addProject(createdBy, projectName, status, teamSize);
		given()
		.body(name)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}
	
    @DataProvider
	public Object[][] punk(){
    	Random ran = new Random();
    	int ranNum = ran.nextInt(100);
		Object[][] obj = new Object[4][4];
		obj[0][0]="Hitrik";
		obj[0][1]="Roshan"+ranNum;
		obj[0][2]="ongoing";
		obj[0][3]=3;
		obj[1][0]="Salman";
		obj[1][1]="khan"+ranNum;
		obj[1][2]="process";
		obj[1][3]=5;
		obj[2][0]="sharukh";
		obj[2][1]="roy"+ranNum;
		obj[2][2]="completed";
		obj[2][3]=7;
		obj[3][0]="Amitha";
		obj[3][1]="Bachan"+ranNum;
		obj[3][2]="updated";
		obj[3][3]=9;
		return obj;
	}
}
