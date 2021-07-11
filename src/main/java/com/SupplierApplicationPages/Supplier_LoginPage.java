package com.SupplierApplicationPages;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BaseCode.Application_DriverClass;

public class Supplier_LoginPage extends Application_DriverClass{

	public WebDriver driver;
	public Supplier_LoginPage(WebDriver driver){
		super();
		this.driver = driver ;
		
	}
	

	public void Supplier_Login()
	{
		
		driver.findElement(By.cssSelector("input[name='email'][type='text']")).sendKeys(objProp.getProperty("SupplierUserID"));
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(objProp.getProperty("SupplierUserPassword"));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#account")));
		//ExpectedConditions.
	}
}
