package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfSeedForEditDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class EditListOfSeedDrcs extends BaseClass{
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public ListOfSeedForEditDrcs lopfed;
	
	
	
	@BeforeTest
	public void setUp() {
		driver=getDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		lopfed=new ListOfSeedForEditDrcs(driver); 
		driverwait=new WebDriverWait(driver,120);
	}
	
	@Test(priority = 1)
	public void click_On_Login() {
		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		lp.click_On_Login_Dashboard();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.click_On_Arcs_And_Drcs();
		lp.enter_UserNameForArcsandDrcs("payal@oasys.com");//previous username=payal1@gmail.com
		lp.enter_PasswordForArcsandDrcs("Oasys@1234");
		lp.click_On_Sign_In_Button_ArcsandDrcs();

	}

	
	@Test(priority=2)
	public void edit_Functional() {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='List Of Seed']")));
		driver.findElement(By.xpath("//*[text()='List Of Seed']")).click();
		
		System.out.println("Status ="+lopfed.get_Status());
		try {
			if(lopfed.get_Status().equalsIgnoreCase("Pending")) {
				lopfed.click_On_Edit_Button();
				Thread.sleep(2000);
				lopfed.enter_indentPlacetoOssc("300");
				lopfed.enter_Lifted("30");
				lopfed.enter_LastWeek("400");
				lopfed.enter_Cashsale("400");
				lopfed.enter_B_Component("30");
				lopfed.enter_Total("30");
				lopfed.enter_Balance_With_Pacs("50");
				lopfed.enter_Achievement("600");
				lopfed.click_On_Submit_Button();
				Thread.sleep(3000);
				lopfed.click_On_UpdateButton();
				Thread.sleep(2000);
				lopfed.click_On_Ok_Button();
				Thread.sleep(3000);
				System.out.println( lopfed.get_Status());
				
				
				
			}
			else {
				System.out.println("status is not pending...");
			}
			
		}catch(Throwable e) {
			e.getMessage();
		}
		
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
