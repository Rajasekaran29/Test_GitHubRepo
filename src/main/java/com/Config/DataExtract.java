package com.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class DataExtract {

	
	public static WebDriver Driver;
	public static Properties objProp;
	
	//Base class Constructor
	public DataExtract()
	{
		//this.Driver = Driver;WebDriver Driver
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
	
	public String GetProperty_value(String Key)
	{
		String BrowserType = objProp.getProperty(Key).toString();
		return BrowserType;
		
	}

	
	
}
