package com.ui.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.tests.utils.SeleniumUtils;

public class HomePage {

	WebDriver driver;
	private SeleniumUtils seleniumUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils(driver);
	}

	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	private WebElement SIGN_IN_LINK;

	public LoginPage clickOnSignInlLink() {

		seleniumUtils.clickOn(SIGN_IN_LINK);

		// SIGN_IN_LINK_LOCATOR.click();

		return new LoginPage(driver);
	}

}
