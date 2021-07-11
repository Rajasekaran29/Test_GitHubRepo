import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.BaseCode.Application_DriverClass;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chromium.ChromiumDriver;

public class DriverTest extends  Application_DriverClass {
	



	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		pascal();
		//super();
		Application_DriverClass apc = new Application_DriverClass();
		driver = apc.Intialize();
		String BrowserType = objProp.getProperty("Browser");
		switch(BrowserType)
		{
			case "Chrome":
				System.setProperty("webdriver.chrome.driver","E:\\software\\Selenium\\Updated\\chromedriver.exe");
				driver = new ChromeDriver();
				break;	
				
			case "Edge":
				System.setProperty("webdriver.edge.driver","E:\\software\\Selenium\\Updated\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;			
		}	
		//return Driver;
		
		
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\software\\Selenium\\Updated\\chromedriver.exe");
		
		driver = new ChromeDriver();
		try {
			BrokenLinkTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);	
		Drag_drop_range_click();
		//File_Upload_Without_UsingSekuli();
		//File_Upload_With_UsingSekuli();
		System.exit(0);	
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().forward();
		System.exit(0);	
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.linkText("Gmail")).click();
		
		if (driver.findElement(By.xpath("//div[@class ='cta__chapter__title']")).isDisplayed())
		{
			System.out.println("Heading text is verified ");
			
			//getText()  get the from the tag text in between tag eg <h1> "This is heading"</h1>
			System.out.println(driver.findElement(By.xpath("//div[@class ='cta__chapter__title']")).getText());
			
			//Partial Values of a Link text "Sign In"
			System.out.println(driver.findElement(By.partialLinkText("Sign")).getText());
			//CSS path  for Class 
			
			//using Class = value
			System.out.println(driver.findElement(By.cssSelector("a[class='button   ']")).getText());
		
			//using Class.value
			System.out.println(driver.findElement(By.cssSelector("a.button   ")).getText());
			
			//CSS for ID 
			
			//driver.findElement(By.linkText("Sign in")).click();
			//id="identifierId"
			//driver.wait(10000);
			driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&dsh=S1812225775%3A1623607558119133&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
			driver.findElement(By.cssSelector("input#username")).sendKeys("With #");
			//id="identifierId"
			driver.findElement(By.cssSelector("input[id='username']")).sendKeys("Without  #");
			
		}else
		{
			System.out.println("Heading text is not verified ");
		}
		//driver.quit();
	}

	static void File_Upload_Without_UsingSekuli() throws InterruptedException
	{
		driver.get("https://tus.io/demo.html");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(".//input[@id='js-file-input']")).isDisplayed())
		{
			//-----------------only works for  <input type="file" id="js-file-input">------------------------
			
			driver.findElement(By.xpath(".//input[@id='js-file-input']")).sendKeys("C:\\Users\\arthi\\Downloads\\Documents\\sample.txt");
			if (driver.findElement(By.xpath("//*[@id='js-upload-container']/div[@class='heading']")).isDisplayed())
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='js-upload-container']/div[@class='heading']")).getText());
			}
		}
	}
	
	static void File_Upload_With_UsingSekuli() throws InterruptedException, FindFailed
	{
		driver.get("https://tus.io/demo.html");
		Thread.sleep(1000);
		Screen s = new Screen();
		//s.
		s.click("E:\\Raj_selenium_workspace\\sikuli_testimage\\choose_file_btn.PNG");
	}
	
	
	static void Drag_drop_range_click()
	{
	
			
	  driver.get("https://jqueryui.com/resources/demos/slider/default.html");
	  driver.manage().window().maximize();
	  WebElement DragIcon = driver.findElement(By.xpath("//span[@class ='ui-slider-handle ui-corner-all ui-state-default']"));
	  Actions act = new Actions(driver); act.dragAndDropBy(DragIcon, 100,2).build().perform();
		 
		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		driver.manage().window().maximize();
		WebElement DragIcon_new = driver.findElement(By.xpath("//*[@id='slider1']//input"));
		Actions act1 = new Actions(driver);
		act1.dragAndDropBy(DragIcon_new, 100, 3).build().perform();
		driver.close();
	}
	
	
	static void  BrokenLinkTest() throws IOException
	{
		
	 URL link = new URL("https://www.google.com/");
	 HttpURLConnection HUC = (HttpURLConnection) link.openConnection();
		
	 if (HUC.getResponseCode()==200)
	 {
		 System.out.println("Valid URL tested successfully");
	 }else
	 {
		 System.out.println("Response code is"+HUC.getResponseCode());
	 }
	 
	}
	
	
	
	static void pascal()
	{
		//i for rows and j for columns      
			//row denotes the number of rows you want to print  
			int i, j, row = 4;       
			//Outer loop work for rows  
			for (i=0; i<row; i++)   
			{  
				//inner loop work for space      
				for (j=row-i; j>=1; j--)   
				{  
					//prints space between two stars  
					System.out.print("@");   
				}   
				//inner loop for columns  
				for (j=0; j<=i; j++ )   
				{   
					//prints star      
					System.out.print("* ");   
				}   
			//throws the cursor in a new line after printing each line  
			System.out.println();   
			}   	 
	}
	
}
