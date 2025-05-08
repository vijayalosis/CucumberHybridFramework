package com.ui.tests.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ui.tests.utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;

	public static WebDriver initializeBrowser(String browserName) {
		

		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {

			driver = new EdgeDriver();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		
		return driver;
	}

	public static WebDriver getDriver() {

		return driver;

	}


	
	

}
