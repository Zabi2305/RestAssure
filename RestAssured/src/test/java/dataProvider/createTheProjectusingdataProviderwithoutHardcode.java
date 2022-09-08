package dataProvider;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.ExcelUtility;

public class createTheProjectusingdataProviderwithoutHardcode  extends ExcelUtility{
	@Test(dataProvider = "dataprovide")
	public void addProject(String createdBy,String projectName,String status,int teamSize) {
		
		
		
		pojoClass.addProject post = new pojoClass.addProject(createdBy, projectName, status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(post)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
	}

	@DataProvider
	public Object[][] dataprovide() throws Throwable, Throwable{
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
	
		Object[][] objArr = new Object[4][4];
		objArr[0][0]=getDataFromExcel("restdata", 1, 0);
		objArr[0][1]=getDataFromExcel("restdata", 1, 1)+ranNum;
		objArr[0][2]=getDataFromExcel("restdata", 1, 2);
		objArr[0][3]=Integer.parseInt (getDataFromExcel("restdata", 1, 3));
		
		objArr[1][0]=getDataFromExcel("restdata", 2, 0);
		objArr[1][1]=getDataFromExcel("restdata", 2, 1)+ranNum;
		objArr[1][2]=getDataFromExcel("restdata", 2, 2);
		objArr[1][3]=Integer.parseInt(getDataFromExcel("restdata", 2, 3));
		
		objArr[2][0]=getDataFromExcel("restdata", 3, 0);
		objArr[2][1]=getDataFromExcel("restdata", 3, 1)+ranNum;
		objArr[2][2]=getDataFromExcel("restdata", 3, 2);
		objArr[2][3]=Integer.parseInt(getDataFromExcel("restdata", 3, 3));
		
		objArr[3][0]=getDataFromExcel("restdata", 4, 0);
		objArr[3][1]=getDataFromExcel("restdata", 4, 1)+ranNum;
		objArr[3][2]=getDataFromExcel("restdata", 4, 2);
		objArr[3][3]=Integer.parseInt(getDataFromExcel("restdata", 4, 3));
		return objArr;	
	}
}
