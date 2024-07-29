package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class ValidationMessageForFertilizerpage extends BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	
	
	@BeforeTest
	public void setUp() {
		driver=getDriver();
		lp=new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	public void landing_On_The_Fertilazer_Page() {
		
	}
	
	
	
	
	
	
	

}
