package crm.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;

public class TC_RF_001 extends DriverClass{
	
	
	@Test
	public void accountRegisteration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.setFirstname(randomString());
		rp.setLastname(randomString());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setPassword(randomAlphaNumeric());
		rp.setNewsletter();
		rp.setPolicy();
		rp.clickContinue();
		
		String confirmMsg = rp.getMessage();
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		
	}
	

}
