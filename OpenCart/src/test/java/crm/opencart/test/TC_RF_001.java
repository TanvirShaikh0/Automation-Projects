package crm.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;

import crm.opencart.base.DriverClass;

public class TC_RF_001 extends DriverClass{
	
	
	HomePage hp;
	RegisterPage rp;
	
	
	@Test
	public void accountRegisteration()
	{
		logger.info("**** STARTED TC_RF_001  ****");
		try
		{
			hp = new HomePage(driver);
			
			logger.info("Clicked on My Account");
			hp.clickMyAccount();
			logger.info("Clicked on Register");
			hp.clickRegister();
			
			rp = new RegisterPage(driver);
			
			logger.info("Entering details into Register Page");
			rp.setFirstname(randomString());
			rp.setLastname(randomString());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setPassword(randomAlphaNumeric());
			rp.setNewsletter();
			rp.setPolicy();
			rp.clickContinue();
			
			logger.info("Validating Account");
			String confirmMsg = rp.getMessage();
			if(confirmMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("___ Test Failed ___");
				logger.debug("$$$$ DEBUG LOG $$$$");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** FINISHED TC_RF_001 ****");
		
		
		
		
	}

}
