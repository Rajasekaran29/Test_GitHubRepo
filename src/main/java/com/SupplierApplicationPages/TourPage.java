package com.SupplierApplicationPages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import com.BaseCode.Application_DriverClass;


public class TourPage extends Application_DriverClass {

public WebDriver driver;
	
public TourPage(WebDriver driver)
	{
		super();
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	@FindBy(xpath= "//a[@href='https://www.phptravels.net/supplier/tours']")
	WebElement ManageTour_Tab;
	
	
	/*
	 * @FindBy(linkText="Extras") WebElement Extra_Tab;
	 */
	@FindBy(xpath= "//a[@href='#Tours']")
	WebElement Tour_Tab;
	
	public void validate_TourPageTabs() throws InterruptedException
	{
		if (!ManageTour_Tab.isDisplayed())
		{
			Tour_Tab.click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/supplier/tours/extras']"))));
		//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
			
			//Thread.sleep(10000);
		
			//System.out.println(ManageTour_Tab.getText());
			//System.out.println(driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/supplier/tours/extras']")).getText());
			
		//Assert.assertEquals("MANAGE TOURS",ManageTour_Tab.getText());
		Assert.assertEquals("EXTRAS",driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/supplier/tours/extras']")).getText());
		
		}
		
	}
	
	public void ManageTours_PageNavigation() throws Exception
	{
		driver.manage().window().maximize();
		ManageTour_Tab.click();
		//driver.getPageSource();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(20000));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("location.reload()");
		
		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='panel panel-default']>div[class='panel-heading']")));
		  if (result.isDisplayed())
		  {
		  System.out.println("Result text is = "+result.getText());
		  }
		  Assert.assertTrue(driver.findElement(By.cssSelector("div[class='xcrud-list-container']")).isDisplayed());
		  
		 /* 
		int i =0;
		while(i<5)
		{
			boolean readyState = js.executeScript("return document.readyState").toString().equals("complete");
			//driver.getPageSource();
			//driver.get("https://www.phptravels.net/supplier/tours");
			//Thread.sleep(1000);
			if (readyState)
			{
				
				WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='panel panel-default']>div[class='panel-heading']")));
				  if (result.isDisplayed())
				  {
				  System.out.println("Result text is = "+result.getText());
				  }
				  Assert.assertTrue(driver.findElement(By.cssSelector("div[class='xcrud-list-container']")).isDisplayed());
				  i++;
			}
		}
		*/
		//Object text = js.executeScript("return document.readystate");
		//System.out.println(driver.findElement(By.cssSelector("div[class='panel-heading']")).getText());
	//Thread.sleep(5000);
		//driver.getWindowHandle();
		//ExpectedConditions.presenceOfElementLocated(null)
	
	/*
	 * if(!text.equals(null)) { WebElement result =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.
	 * cssSelector("div[class='panel panel-default']>div[class='panel-heading']")));
	 * if (result.isDisplayed()) {
	 * System.out.println("Result text is = "+result.getText()); }
	 * Assert.assertTrue(driver.findElement(By.cssSelector(
	 * "div[class='xcrud-list-container']")).isDisplayed()); }
	 */
				
	}
	
}
