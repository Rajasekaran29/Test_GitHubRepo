package Test_SupplierApplication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.BaseCode.Application_DriverClass;
import com.SupplierApplicationPages.Supplier_LoginPage;
import com.SupplierApplicationPages.TourPage;

public class TestLogin extends Application_DriverClass {
	WebDriver driver;
	
	
@Test(priority=0)
	public void Test_SupplierLogin()
	
	{
	driver = Application_DriverClass.Intialize();
	driver.get(objProp.getProperty("strApplicationURL"));
	Supplier_LoginPage lgp = new Supplier_LoginPage(driver);
	lgp.Supplier_Login();
		
	}

@Test(dependsOnMethods="Test_SupplierLogin")
	public void Test_TourPage_Navigation() throws Exception
	{
		TourPage tpg = new TourPage(driver);
		tpg.validate_TourPageTabs();
		tpg.ManageTours_PageNavigation();
		
		
	}

	
@AfterTest
public void closedriver()
{
	driver.quit();
}
}
