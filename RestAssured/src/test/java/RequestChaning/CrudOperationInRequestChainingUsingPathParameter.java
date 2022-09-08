package RequestChaning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.addProject;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CrudOperationInRequestChainingUsingPathParameter {
	// In this Class we are gng to create,get,update and delete the project and verify in DB using PathParameter
	@Test
	public void CRUDOPERATION() throws Throwable {
		//using Pojo Class
		Random ran = new Random();
		int ranNum = ran.nextInt(50);
		addProject addPro = new addProject("Mango", "Frooti"+ranNum, "OnGoing", 1000);
		baseURI="http://localhost";
		port=8084;
		//Create the Project
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(addPro)
		.post("/addProject");
		
		//get the project Id
		String project = resp.jsonPath().get("projectId");
		System.out.println(project);
		resp.then().log().all();
		
		//get the project details using path parameter
		given()
		.pathParam("Pro", project)
		.contentType(ContentType.JSON)
		.when()
		.get("/projects/{Pro}")
		.then().assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
		
		//Update the projectusing path parameter
		addProject up = new addProject("Apple", "AppyFizz"+ranNum, "Completed", 250);
		given()
		.pathParam("Pro1", project)
		.contentType(ContentType.JSON)
		.body(up)
		.when().put("/projects/{Pro1}")
		.then().contentType(ContentType.JSON).statusCode(200).log().all();
		
		//Delete the project using path parameter
		given()
		.pathParam("Pro2", project)
		.when().delete("/projects/{Pro2}")
		.then().statusCode(204).log().all();
		
		//verify using the dataBase Connection
		//register to DB
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//Connect to DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//create Stmt/query
		Statement stmt = connection.createStatement();
		String query="Select * from project";
		//Execute the query
		ResultSet result = stmt.executeQuery(query);
		int count=0;
		while (result.next()) {
			if (result.getString(1).contains(project)) {
				count++;
				break;
			}	
		}
		if (count==0) {
			System.out.println("Project is deleted and program is pass");
		}
		else {
			System.out.println("Project is Present and program is fail");
		}
		connection.close();
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();*/
	}
}
