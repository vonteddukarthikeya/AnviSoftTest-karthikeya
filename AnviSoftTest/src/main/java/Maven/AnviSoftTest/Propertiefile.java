package Maven.AnviSoftTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

public class Propertiefile 
{

	public static String path="./AnviSoftTest.properties"; //Properties file path

//loading data from properties
	public static String loaddata(String key) throws Exception
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fis);

		return prop.getProperty(key);
		
	}
	
// To generate Random MailId
	public int randommailid() 
	{
		Random r=new Random();
		int mailid=r.nextInt(9999);

		return mailid;
	}

// To generate Random Phone Number
	public int randomphonenumber() 
	{
		Random r=new Random();
		int phonenumber=r.nextInt(999999999);

		return phonenumber;
	}
	
}


