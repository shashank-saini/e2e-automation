package Academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePg;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.base;

public class AppIntegrationTest extends base {
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getData")
	
	public void LoginPageNavigation(String Username,String email,String Password) throws Exception
	{
		driver.get(prop.getProperty("url"));
		RegistrationPage rg = new RegistrationPage(driver);
	LoginPage lg = new LoginPage(driver);
	lg.getLoginMain().click();
	lg.getUsername().sendKeys(Username);
	lg.getPassword().sendKeys(Password);
	lg.getLogin().click();

	 HomePg hp= new HomePg(driver);
	    hp.getReadMore().click();
	    String parentWindow = driver.getWindowHandle();
	    
	    String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    hp.getWhatsapplink().sendKeys(clickOnLink);
	    hp.getPhptravels().sendKeys(clickOnLink);
Thread.sleep(5000);

Set<String> s =driver.getWindowHandles();
Iterator<String> it = s.iterator();

while(it.hasNext())
{
	driver.switchTo().window(it.next());
	System.out.println(driver.getTitle());
	
	}
driver.close();
driver.switchTo().window(parentWindow);
Thread.sleep(5000);

rg.getDropdown().click();

rg.getLogout().click();

}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="sks123";
		data[0][1]="sks123@gmail.com";
		data[0][2]="12345";

		//1st row
		data[1][0]="shawggydts43a_ss";
		data[1][1]="shaywijd4s3alt@gmail.com";
		data[1][2]= "Password@123";

		
		return data;
		
		
	}
   

}
