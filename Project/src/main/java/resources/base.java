package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	

	driver = new HtmlUnitDriver();
// prop.load(fis);
// String browserName=prop.getProperty("browser");
// System.out.println(browserName);

// if(browserName.equals("HtmlUnit"))
// {
	
// 		driver = new HtmlUnitDriver();
	
// }
// else if (browserName.equals("firefox"))
// {
// // 	 driver= new FirefoxDriver();
// 	//firefox code
// }
// else if (browserName.equals("IE"))
// {
// //	IE code
// }
 prop= new Properties();
FileInputStream fis=new FileInputStream("/var/jenkins_home/workspace/e2e-automation/Project/src/main/java/resources/data.properties");
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;

}

}
