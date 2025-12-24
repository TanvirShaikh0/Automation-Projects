package crm.opencart.test;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverClass {
	
public WebDriver driver;
	
	@BeforeClass
	public void precondition()
	{
		driver = new EdgeDriver();
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
