package com.ui.tests.testrunner;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features",	  
	    glue = {"com.ui.tests.stepdefinition", "com.ui.tests.hooks"},
	    publish = true,
	    plugin = {"pretty", "html:target/CucumberReports/Cucumber-reports.html"},
	    tags = "@validLoginTestData", monochrome = false,
	    dryRun = false
	   
	)
public class TestRunnerTesngNgUI extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	public static void setReportConfiguration() {
		
		
	}
	
	public static void setConfiguration() {
		
	}

}