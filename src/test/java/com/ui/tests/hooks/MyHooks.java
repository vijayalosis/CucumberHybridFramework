package com.ui.tests.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ui.tests.driver.DriverFactory;
import com.ui.tests.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;//To take screen shot before close the browser.

public class MyHooks {

	WebDriver driver;
	

	@Before
	public void setup() {
		Properties prop = new ConfigReader().readProperty();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName =scenario.getName().replaceAll("", "-");
		
		if(scenario.isFailed()) {
			
		byte[]	srcScreenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot, "image/png", scenarioName);
		
		}
		
		driver.quit();

	}

}
