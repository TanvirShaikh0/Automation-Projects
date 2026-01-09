package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPass;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement btnLogin;
	
	
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		txtPass.sendKeys(pass);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}

}
