package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author Zabiulla
 *
 */
public class BaseClassApi {

	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dlib=new DataBaseUtility();
	
	/**
	 * Connect To DataBase
	 */
	@BeforeSuite
	public void dbConfig() {
		
		dlib.connectToDB();
	//	baseURI="http://localhost";
		//port=8084;
		System.out.println("database is connected");
		
	}
	
	/**
	 * Close the DB Configuration
	 */
	@AfterSuite
	public void closedbconfig() {
		dlib.closeDB();
		System.out.println("DB closed successfully");
	}
}
