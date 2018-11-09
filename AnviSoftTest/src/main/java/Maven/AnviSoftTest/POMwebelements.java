package Maven.AnviSoftTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class POMwebelements extends Browsers
{
	Propertiefile pr=new Propertiefile(); //using Propertiefile class
	
@FindBy(linkText="CAREERS")	WebElement careers; // career link element
@FindBy(xpath="//a[text()='South Africa']") WebElement southafrica; //south africa xpath element
@FindBy(xpath="//div[@class='wpjb-job-list wpjb-grid']") WebElement currentOpenings; // openings xpath element
@FindBy(xpath="//div[@id='wpjb-scroll']/div/a") WebElement applyonline; //Applyonline xpath element
@FindBy(id="applicant_name") WebElement applicantname; // name id element
@FindBy(id="email") WebElement emailid; //email id element
@FindBy(id="phone") WebElement phonenumber; //phone number id element
@FindBy(className="wpjb-submit") WebElement sendapplication; //send application classname element
@FindBy(xpath="//ul[@class='wpjb-errors']") WebElement validationtext; //warning text xpath element for validation



public POMwebelements(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

public void ilabsHomePage()
{
	careers.click();
}

public void ilabsCareersPage()
{
	southafrica.click();
}

public void ilabsCurrentOpeningsPage()
{
	int count = 0;
	currentOpenings.click();
	WebElement currentOpeningsHeader = currentOpenings;
	List<WebElement> links = currentOpeningsHeader.findElements(By.tagName("a"));
	
//dynamic - for finding first element follow this code 
	if (!(links.get(0).toString().equalsIgnoreCase(""))) 
		
	{
		links.get(0).click();
	}
}

//dynamic - if we want to click the link specifically follow this code	
	/*for (int i = 0; i < links.size(); i++) {
		if (!links.get(i).getText().isEmpty()) {
			count++;
			if (links.get(i).getText().contentEquals("Senior Test Automation Specialist – Johannesburg")) {
				System.out.println(links.get(i).getText());
				links.get(i).click();
				Thread.sleep(4000);
				break;
			}
		}
	}*/


public void ilabsApplyOnlinePage() throws Exception
{
	applyonline.click();
	Thread.sleep(1000); //system wait property
	applicantname.sendKeys(pr.loaddata("applicantname")); //applicant name from Property file

//To read the data from excel file the below commented code will work and 
	/*ExcelAPI e= new ExcelAPI("C:\\Users\\HP\\Desktop\\AnviSoftTest_Karthikeya\\AnviSoftTestData.xlsx");
    int rcnt = e.getRowCount("TestData");
		
		for(int i=1;i<rcnt;i++)
		{
			applicantname.clear();
			applicantname.sendKeys(e.getCellData("TestData", "UserName", i));
		}*/
	
	emailid.sendKeys(pr.loaddata("firstname")+pr.loaddata("lastnamme")+pr.randommailid()+pr.loaddata("domainmame")); //random email from property file
	phonenumber.sendKeys(pr.loaddata("phonenumber")+pr.randomphonenumber()); //random phone number from property file
	waitforElement(sendapplication, 10); //Explicitly Wait 
	sendapplication.click();
	validationtext.getText();
	String actualvalue = validationtext.getText(); //validating the warning text
	String expectedvalue = "You need to upload at least one file.";
	System.out.println("Actual value is :" + actualvalue);
	System.out.println("Expected value is :" + expectedvalue);
	if(actualvalue.equals(expectedvalue))
	{
		System.out.println("Both are equal...");
	}
	else
	{
		System.out.println("Both are not equal...");
	}
//For checking the 	outputs in console
	System.out.println("Applicant Name :" + applicantname.getAttribute("value"));
	System.out.println("Email Id :" + emailid.getAttribute("value"));
	System.out.println("Phone Number :" + phonenumber.getAttribute("value"));
	System.out.println("Expected Value is :" + expectedvalue);
	
}




}
