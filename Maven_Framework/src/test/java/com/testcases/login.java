package com.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.baseclass;
import com.utilities.Browser_factory;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;



public class login extends baseclass {
	
	 // this is new commit
			@Test
			public void loginapp() throws InterruptedException, Exception {
				
				
// this is abstraction. We hide the locators, logic etc				
				LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
				loginpage.LogintoCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
				Helper.captureScreenshot(driver);
			}
			

			
}
