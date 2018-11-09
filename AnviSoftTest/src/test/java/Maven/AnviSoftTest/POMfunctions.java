package Maven.AnviSoftTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class POMfunctions extends Browsers
{
	POMwebelements pomclass;
	
// Used groups, parameters, priority, enabled, annotations
	@BeforeMethod(groups={"regression","smoke"})
	@Parameters("browser")
	public void OpenBrowser(String browser) throws Exception 
	{
		browserLaunch(browser, "https://www.ilabquality.com"); //Browser url
	}

	  @AfterMethod
	  public void CloseBrowser() throws IOException 
	  {
		  driver.quit(); //Used to quit from the browser
	  }
	  
	  @Test(priority=0,enabled=true,groups={"regression","smoke"})
	  public void iLabs() throws Exception 
	  {
		pomclass=new POMwebelements(driver);//created object of the page and create constructor
		pomclass.ilabsHomePage();
		pomclass.ilabsCareersPage();
		pomclass.ilabsCurrentOpeningsPage();
		pomclass.ilabsApplyOnlinePage();
		driver.quit();
	  }
	
}
