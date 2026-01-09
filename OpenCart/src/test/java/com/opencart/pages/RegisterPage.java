package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(id = "input-firstname")
	WebElement  txtFirstname;
	
	@FindBy(id = "input-lastname")
	WebElement txtLastname;
	
	@FindBy(id = "input-email")
	WebElement txtEmail;
	
	@FindBy(id = "input-password")
	WebElement txtPassword;
	
	@FindBy(id = "input-newsletter")
	WebElement chkdNewsletter;
	
	@FindBy(name = "agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void setNewsletter()
	{
		chkdNewsletter.click();
	}
	public void setPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getMessage()
	{
		try
		{
			return msgConfirm.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
