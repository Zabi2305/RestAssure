package UsingLibrariesPerformCrudOperation;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import genericUtilities.DataBaseUtility;
import genericUtilities.EndPointLibrary;
import genericUtilities.IConstants;
import genericUtilities.JavaUtility;
import genericUtilities.ProjectLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndTesting {


	@Test
	public void chainig() throws SQLException {

		JavaUtility jLib = new JavaUtility();
		DataBaseUtility dlib = new DataBaseUtility();
		
		 ProjectLibrary pObj = new ProjectLibrary("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);
		 baseURI="http://localhost";
		 port=8084;
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				.when()
				.post(EndPointLibrary.createProject);

		String projectId = response.jsonPath().get("projectId");
		System.out.println(projectId);


	given()
		.pathParam("pid", projectId)
		.get("/{pid}")
		.then().assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();

		 ProjectLibrary pObj11 = new ProjectLibrary("Ramaaaa","Ramayana"+jLib.getRandomNumber(),"complited",3);
	given()
		.pathParam("pid1", projectId)
		.body(pObj11)
		.contentType(ContentType.JSON)

		.when()  
		. put("/{pid1}")
		.then().log().all();


	given()
		.pathParam("pid2", projectId)
		.when()
		.delete("/{pid2}")
		.then().log().all();



		//Verify in the DataBase
		/*Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");*/
     	dlib.connectToDB();
     
    	
		java.sql.Statement statement = dlib.connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		boolean flag=false;
		while (result.next()) {
			System.out.println(result.getString(1));
			if ((result.getString(1)).contains(projectId)) {

				flag=true;
				break;
			}
		}
		if (flag==true) {
			System.out.println("Project is not Deleted From Database!");
		}else {
			System.out.println("Project is Deleted From Database !");
		}
		
		dlib.connection.close();

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
		for (WebElement id : projectIds) {

			String proId = id.getText();
			boolean flag1=false;
			if (proId.equalsIgnoreCase(projectId)) {
				flag1=true;
			}
		}
		if (flag==true) {
			System.out.println("Project is not Deleted From Database!");
		}
		else {
			System.out.println("Project is Deleted From Database!");

		}
	}
}