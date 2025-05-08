package com.ui.tests.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private WebDriver driver;
	private WebDriverWait wait;
	private Alert alert;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement waitForWebElement(WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

	public Alert waitForAlert(long durationInSeconds) {

		alert = null;

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void acceptAlert(long durationInSeconds) {

		alert = waitForAlert(durationInSeconds);
		alert.accept();

	}

	public void mouseHoverClick(WebElement element) {

		waitForWebElement(element);
		flashElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public void javaScriptClick(WebElement element) {
		waitForWebElement(element);
		flashElement(element);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click(),", element);
	}

	public void javaScriptType(WebElement element, String textToEnter) {
		waitForWebElement(element);
		flashElement(element);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeAsyncScript("arguments[0].value='" + textToEnter + "'", element);
	}

	public void clickOn(WebElement element) {
		waitForWebElement(element);
		flashElement(element);
		element.click();
	}

	public void enterText(WebElement element, String textToEnter) {
		waitForWebElement(element);
		flashElement(element);
		element.clear();
		element.sendKeys(textToEnter);

	}

	public String getText(WebElement element) {
		waitForWebElement(element);
		flashElement(element);
		return element.getText();
	}

	public void selectOptionInDropDown(WebElement element, String dropDownOption) {
		waitForWebElement(element);
		Select select = new Select((WebElement) element);
		select.selectByVisibleText(dropDownOption);
	}

	// Flash highlighter before interaction
	private void flashElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			for (int i = 0; i < 2; i++) {
				js.executeScript("arguments[0].style.border='3px solid yellow'", element);
				Thread.sleep(150);
				js.executeScript("arguments[0].style.border=''", element);
				Thread.sleep(150);
			}
			js.executeScript("arguments[0].style.border='3px solid yellow'", element);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
