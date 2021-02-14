package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	/*	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;
		
	}
	*/

	@FindBy(name = "email") WebElement login;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//div[contains(text(),'Login')]") WebElement username;
	
	public void LogintoCRM(String uname, String pass) throws InterruptedException {
			Thread.sleep(3000);
			login.sendKeys(uname);
			password.sendKeys(pass);
			username.click();
			
			

	
	}
	
	
}
