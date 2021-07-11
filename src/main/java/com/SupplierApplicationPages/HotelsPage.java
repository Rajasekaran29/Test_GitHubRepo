package com.SupplierApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseCode.Application_DriverClass;

public class HotelsPage extends Application_DriverClass {

	public WebDriver driver;
	
	HotelsPage()
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath= "//a[contains(@href,'https://www.phptravels.net/supplier/bookings')]")
	WebElement Booking_Tab;
	
	@FindBy(xpath= "//a[contains(@href, '#Hotels')]")
	WebElement Hotels_Tab;
	
	
	
	
	
}
