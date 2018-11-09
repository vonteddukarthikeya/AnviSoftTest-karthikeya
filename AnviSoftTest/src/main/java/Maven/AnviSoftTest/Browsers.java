package Maven.AnviSoftTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browsers 
{

	public static WebDriver driver;
	
//For Browsers common method	
	public static void browserLaunch(String browser,String url) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))  //Chrome browser Launching
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe"); 
			driver=new ChromeDriver();	
		}	
		else if (browser.equalsIgnoreCase("Firefox"))  //Firefox browser Launching
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Tool\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(url); 
		driver.manage().window().maximize(); //Maximize the screen
		driver.manage().deleteAllCookies();  //To delete all cookies
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Implicitly Wait
	}
	
//For Explicitly Wait common method
	public static void waitforElement(WebElement element, long time)
	{
		WebDriverWait explicitlyWait = new WebDriverWait(driver, time);
		explicitlyWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
	