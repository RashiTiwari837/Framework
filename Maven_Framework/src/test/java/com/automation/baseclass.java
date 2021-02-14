package com.automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.Browser_factory;
import com.utilities.ConfigDataProvider;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;

public class baseclass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	

	@BeforeSuite
	public void setupSuite() throws Exception  {
	 excel = new ExcelDataProvider();
	 config = new ConfigDataProvider();
	 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
	 
	
	
	}
	
	
	@BeforeClass
	 public void startup() {
		 driver = Browser_factory.startbrowser(driver, config.getBrowser(),config.getStagingURL());
	 }	
	 @AfterClass
	 public void teardown() {
		 Browser_factory.quit(driver);
	 }
	 @AfterMethod // to capture failed Screenshot after every TC
	 public void teardownmethod(ITestResult result) {
		 if (result.getStatus()==ITestResult.FAILURE){
			 Helper.captureScreenshot(driver);
		 }
		 report.flush();
	 }
}
