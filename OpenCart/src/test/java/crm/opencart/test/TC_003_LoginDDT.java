package crm.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyAccountPage;

import crm.opencart.base.DriverClass;
import crm.opencart.utils.DataProviders;



/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends DriverClass
{
	
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class , groups= "Datadriven")
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
		//Home page
			hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); //Login button
				
			//My Account Page
			macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








