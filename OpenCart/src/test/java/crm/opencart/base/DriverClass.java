package crm.opencart.base;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class DriverClass {
	
public WebDriver driver;
public Logger logger;

	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os , String browser)
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
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
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

}
