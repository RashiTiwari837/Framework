package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_factory {
	
	public static WebDriver startbrowser(WebDriver driver, String Browser_Name, String URL) {
		if (Browser_Name.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(Browser_Name.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);	
		return driver;
	}
	
	public static void quit(WebDriver driver) {
		driver.quit();
		
	}
	
	
	
	
	
	
		
	
	

}
