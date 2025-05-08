package com.ui.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.tests.utils.SeleniumUtils;

public class AccountPage {
	
	WebDriver driver;
	private SeleniumUtils seleniumUtils;

	public AccountPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils(driver);
	}
	
	@FindBy(xpath="//a[@title='View my customer account']/span")
	public WebElement USER_NAME;
	
	public String getLoginUserNameInformation() {
		
		return seleniumUtils.getText(USER_NAME);
		
		//return USER_NAME.getText();
		
		//return new LoginPage(driver);
		
	}
	
	

}
