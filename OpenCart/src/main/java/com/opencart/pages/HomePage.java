package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(linkText = "Register")
	WebElement lnkRegister;
	
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}

}
