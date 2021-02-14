package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
public Properties pro;
	public ConfigDataProvider() throws FileNotFoundException {
		 pro = new Properties();
		File src = new File("./Configuration/Config.properties");
		FileInputStream fis = new FileInputStream(src);
		try {
			pro.load(fis);
		} catch (IOException e) {
			
		System.out.println("Not able to load config file"+e.getMessage());
		}
		
	}
	
	public String getDatafromconfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
		
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL() {
		return pro.getProperty("qaURL");

		
	}}
	 