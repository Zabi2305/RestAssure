package genericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Zabiulla
 *
 */
public class WebDriverUtility {
	/**
	 * To Maximize the Browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * To Minimize the Browser Window
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * To Refresh the Page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	/**
	 * To get back the Previous Page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();

	}

	/**
	 * To get Forward to the Next Page
	 * @param driver
	 */
	public void forwordToTheNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}

	/**
	 * This Method will wait till the Page Gets Loaded
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyWaitDuration));
	}

	/**
0	 * This method will wait till Element to Click
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait till the Title of the Page Load
	 * @param driver
	 * @param title
	 */
	public void waitTillPageLoadTitle(WebDriver driver,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method will wait till the URL of the Page Load
	 * @param driver
	 * @param URL
	 */
	public void waitTillPageLoadURL(WebDriver driver,String URL)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.urlContains(URL));
	}
	/**
	 * This method will Ignore the NoSuchElementException for the Particular
	 * @param driver
	 */
	public void ignoreNosuchElementException(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * This Method will wait till the alert msg is visible
	 * @param driver
	 */
	public void waitForAlertMsg(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to switch the frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame using ID
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to Switch the frame using Element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to Switch to Main Frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is also used to switch to parent frame
	 * @param driver
	 */
	public void switchTomainFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to select the element in Dropdown using Index Value
	 * @param driver
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This Method is used to Select the Dropdown using Value
	 * @param element
	 * @param value
	 */
	public void selct(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to Select the Dropdown using Text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method is used to fetch all the options from the Dropdown
	 * @param element
	 */
	public void getAllTheOptionFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);

		}
	}

	/**
	 * This method is used to Mouse Overon the Element
	 * @param driver
	 * @param element
	 */
	public void mouseOveringToElement(WebDriver driver,WebElement element) 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * This method is used to right click on the selected element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * This method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * This method is used to click on Enter Button
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used to take screenshots
	 * @param driver
	 * @param screenShotName
	 */
	public static String takesScreenShot(WebDriver driver,String screenShotName)
	{
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenShots"+screenShotName+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenShotName;
	}

	public void waitAndClickUsingCustomWait(WebDriver driver)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		try {
			wait.wait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * This method is used for Custom wait
	 * @param element
	 * @param duration
	 * @param pollingTime
	 */
	public void waitAndClick(WebElement element,int duration,long pollingTime)
	{
		int count =0;
		while (count < duration) 
		{
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * This method is used to switch to window using title
	 * @param driver
	 * @param actualTitle
	 */
	public void switchToWindow(WebDriver driver,String actualTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for (String string : set) 
		{
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if (title.contains(actualTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch to window by using URL
	 * @param actualURL
	 * @param driver
	 */
	public void switchToWindow(String actualURL,WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext())
		{
			String wId=it.next();
			driver.switchTo().window(wId);
			String url = driver.getCurrentUrl();
			if (url.contains(actualURL)) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch alert popup and accept the popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver,String expectedMsg)
	{
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().contains(expectedMsg.trim())) 
		{
			System.out.println("Alert msg is verified");
		}
		else
		{
			System.out.println("Alert msg is not verified");
		}
		alert.accept();
	}

	/**
	 * This Method is Used to switch to alert popUp and dismiss`
	 * @param expectedMsg
	 * @param driver
	 */
	public void switchToalertPopUpAndDismiss(String  expectedMsg,WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().equalsIgnoreCase(expectedMsg)) 
		{
			System.out.println("Alert msg is verified");
		}
		else {
			System.out.println("Alert msg is not verified");
		}
		alert.dismiss();
	}
}
