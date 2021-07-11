package com.BaseCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.Config.DataExtract;

public class Application_DriverClass {
	
	public static WebDriver Driver;
	public static Properties objProp;
	public static DataExtract data;
	
	//Base class Constructor
	public Application_DriverClass()
	{
		
		//data = new DataExtract();
		FileInputStream fis;
		try 
		{
			objProp = new Properties();
			fis = new FileInputStream("E:\\Raj_selenium_workspace\\SeleniumTest_ArtifactID\\src\\main\\java\\com\\Config\\Test_Data.Properties");
			objProp.load(fis);
			//Intialize();
		} catch (FileNotFoundException e) {
			System.out.println("File is not found and given expectation");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception  is occurred");
			e.printStackTrace();
		}
		
		
	}
	


	@SuppressWarnings("static-access")
	public static WebDriver Intialize()
	{
		
		String BrowserType = String.valueOf(objProp.getProperty("Browser"));
		System.out.println("browser value is = "+objProp.getProperty("Browser").getClass());
		
		//BrowserType = "Chrome";
		//BrowserType = "Chrome";
		//BrowserType = BrowserType.toString();
		/*
		 * if (BrowserType.equals("Chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\software\\Selenium\\Updated\\chromedriver.exe"); Driver = new
		 * ChromeDriver(); }else if(BrowserType.equals("Edge")) {
		 * System.setProperty("webdriver.edge.driver",
		 * "E:\\software\\Selenium\\Updated\\msedgedriver.exe"); Driver = new
		 * EdgeDriver(); }
		 */
		
		
		  switch(BrowserType) 
		  { 
		  case "Chrome":
		  System.setProperty("webdriver.chrome.driver",
		  "E:\\software\\Selenium\\Updated\\chromedriver.exe"); Driver = new
		  ChromeDriver(); break;
		  
		  case "Edge": System.setProperty("webdriver.edge.driver",
		  "E:\\software\\Selenium\\Updated\\msedgedriver.exe"); Driver = new
		  EdgeDriver(); break; 
		  }
		 	
		return Driver;
	}
	
	
	
}
