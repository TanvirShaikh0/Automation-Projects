package crm.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;


import crm.opencart.base.DriverClass;
import crm.opencart.utils.ReadFromProperties;

public class TC_LF_001 extends DriverClass{
	
	
	HomePage hp;
	LoginPage lp;
	
	
	@Test(groups={"Master","Sanity"})
	public void accountLogin()
	{
		logger.info("=== Started TC_LF_001 ===");
		
		try
		{
			logger.info("*** Clicking on My Account link ***");
			hp.clickMyAccount();
			logger.info("*** Clicking on login link ***");
			hp.clickLogin();
			
			logger.info("*** Entering Details in Login page ***");
			lp.setEmail(ReadFromProperties.getData("LoginEmail"));
			lp.setPassword(ReadFromProperties.getData("LoginPassword"));
			
			logger.info("*** Clicking on Login ***");
			lp.clickLogin();
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			Assert.fail();
		}
		
		logger.info("=== Finished TC_LF_001 ===");
		
		
	}
	
	
	

}
