package UsingLibrariesPerformCrudOperation;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClassApi;
import genericUtilities.DataBaseUtility;
import genericUtilities.EndPointLibrary;
import genericUtilities.IConstants;
import genericUtilities.JavaUtility;
import genericUtilities.ProjectLibrary;
import genericUtilities.RestAssuresLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

public class CreateAndDeleteTheProjectUsingRestAssuredUtility extends BaseClassApi{
	DataBaseUtility dlib = new DataBaseUtility();
	BaseClassApi blib = new BaseClassApi();
	JavaUtility jlib = new JavaUtility();
	RestAssuresLibrary rlib = new RestAssuresLibrary();
	String pid;
	@Test
	public void CreateAndDelete() throws Throwable {
	
		
		//connect to dataBase
		//blib.dbConfig();
		
		ProjectLibrary proj = new ProjectLibrary("Samual", "Signature"+jlib.getRandomNumber(), "completed", 100);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(EndPointLibrary.createProject);
		 pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().statusCode(201).contentType(ContentType.JSON);
		System.out.println("===============================================");
		
//		//In GUI
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURI+":"+port);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		 List<WebElement> pids = driver.findElements(By.xpath("//tr//td[1]"));
		 boolean flag=false;
		 int count=0;
		 for (WebElement project : pids) {
			 String project1 = project.getText();
			 if (project1.equalsIgnoreCase(pid)) {
				 flag=true;
				 break;
			}
			count++;	
		}
		 if (flag==true) {
			 System.out.println("project is present in GUI");	
		}
		 else {
			System.out.println("project is  not present in GUI");
		}
		
		driver.quit();
		//DataBase Verification
	//	 dlib.connectToDB("projects");
		 dlib.executeQuery("select * from project", 1, pid);
			
	}
	 @Test
	 public void delete() throws Throwable {
		 baseURI="http://localhost";
			port=8084;
			
			//deleting
			given()
			.pathParam("path", pid)
			.when()
			.delete(EndPointLibrary.deleteProject+"{path}")
			.then().log().all();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(baseURI+":"+port);
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			 List<WebElement> pids = driver.findElements(By.xpath("//tr//td[1]"));
			 boolean flag1=false;
			 int count=0;
			 for (WebElement project : pids) {
				 String project1 = project.getText();
				 if (project1.equalsIgnoreCase(pid)) {
					 flag1=true;
					 break;
				}
				count++;	
			}
			 if (flag1==true) {
				 System.out.println("project is present in GUI");	
			}
			 else {
				System.out.println("project is  not present in GUI");
			}
			driver.quit();
			
			//DataBase Verification
		//	 dlib.connectToDB("projects");
			 dlib.executeQuery("select * from project", 1, pid);
	 }

}
