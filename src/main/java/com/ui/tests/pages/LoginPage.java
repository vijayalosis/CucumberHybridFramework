package com.ui.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.tests.utils.SeleniumUtils;

public class LoginPage {

	WebDriver driver;
	private SeleniumUtils seleniumUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils(driver);
	}

	@FindBy(id = "email")
	public WebElement EMAIL_TEXT_BOX;
	
	@FindBy(id = "email")
	public By EMAIL_TEXT_BOX1;

	@FindBy(id = "passwd")
	public WebElement PASSWORD_TEXT_BOX;

	@FindBy(id = "SubmitLogin")
	public WebElement SUBMIT_LOGIN_BUTTON;

	public void enterUserName(String username) {
		
		seleniumUtils.enterText(EMAIL_TEXT_BOX, username);
		//EMAIL_TEXT_BOX.sendKeys(username);
	}

	public void enterPassword(String password) {
		seleniumUtils.enterText(PASSWORD_TEXT_BOX, password);
		//PASSWORD_TEXT_BOX.sendKeys(password);
	}

	public AccountPage clickOnSubmitButton() {
		seleniumUtils.clickOn(SUBMIT_LOGIN_BUTTON);
		//SUBMIT_LOGIN_BUTTON.click();

		return new AccountPage(driver);
	}

}
