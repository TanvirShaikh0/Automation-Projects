package crm.opencart.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import crm.opencart.utils.ReadFromProperties;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class DriverClass {
	
public static WebDriver driver;  //driver is static because it is used everywhere and it is created only once so there is no conflict
public Logger logger;

	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os , String browser) throws IOException
	{
		//log4j
		logger = LogManager.getLogger(this.getClass()); 
//		if you want to distinguish runs, you can add a marker log entry at the start of each run, like:
		logger.info("=== Test Run Started at {} ===", LocalDateTime.now());

		switch(browser.toLowerCase())
		{
			case "edge": driver = new EdgeDriver(); break;
			case "chrome": driver = new ChromeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid Browswer Name"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ReadFromProperties.getData("url"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generateNumber = RandomStringUtils.randomNumeric(4);
		return generateNumber;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generateNumber = RandomStringUtils.randomNumeric(4);
		return (generatedString+"@"+generateNumber);

		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		FileUtils.copyFile(sourceFile, targetFile);
			
		return targetFilePath;

	}

}
