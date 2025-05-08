package com.ui.tests.stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.ui.tests.driver.DriverFactory;
import com.ui.tests.pages.AccountPage;
import com.ui.tests.pages.HomePage;
import com.ui.tests.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestStepDefinition {

	WebDriver driver;

	// private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	
	@Given("User opens the (.+) browser")
	public void user_opens_the_browser(String browserName) {
		driver = DriverFactory.initializeBrowser(browserName);
	}

	@Given("User navigates to the Application Login page")
	public void user_navigates_to_the_application_login_page() {
		driver = DriverFactory.getDriver();
		loginPage = new HomePage(driver).clickOnSignInlLink();
		// loginPage = homePage.clickOnSignInlLink();

	}

	@Then("User enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() {

	}

	@Then("User should get the invalid login message")
	public void user_should_get_the_invalid_login_message() {

	}

	@Then("User enters valid username and password")
	public void user_enters_valid_username_and_password() {

		// loginPage = new LoginPage(driver);
		//loginPage.enterUserName();
		//loginPage.enterPassword();

	}
	
	@Then("^User enters valid username (.+) and password (.+)$")
	public void user_enters_validusername_and_passsword(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
	}
		
	

	@Then("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() {

	}

	@Then("User loged in sucessfully")
	public void user_loged_in_sucessfully() {

		// accountPage = new AccountPage(driver);
		String userName = accountPage.getLoginUserNameInformation();
		System.out.println("Logged in sucessfully with the user name " + userName);
		assertEquals(userName, "Ajay Devgan");

	}

	@Then("User did not enter username and password")
	public void user_did_not_enter_username_and_password() {

	}

	@When("User click on submit button")
	public void user_click_on_submit_button() {

		// LoginPage loginPage = new LoginPage(driver);
		accountPage = loginPage.clickOnSubmitButton();

		// driver.findElement(By.id("SubmitLogin")).click();

	}

}
