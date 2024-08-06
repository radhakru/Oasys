package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfPaddyForEditDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class EditListOfPaddyDrcs extends BaseClass{
	
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public ListOfPaddyForEditDrcs lopfed;
	
	
	
	@BeforeTest
	public void setUp() {
		driver=getDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		lopfed=new ListOfPaddyForEditDrcs(driver); 
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
		lp.enter_UserNameForArcsandDrcs("payal@oasys.com");//previous username - payal1@gmail.com 
		lp.enter_PasswordForArcsandDrcs("Oasys@1234");
		lp.click_On_Sign_In_Button_ArcsandDrcs();

	}
	@Test(priority=2)
	public void edit_Functionality() {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Paddy List']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Paddy List']")).click();
		
		System.out.println(lopfed.get_Status());
		try {
			if(lopfed.get_Status().equalsIgnoreCase("Pending")) {
				lopfed.click_On_Edit_Button();
				lopfed.update_On_Circle("Chhatrapur");
				lopfed.update_On_Block("Rangeilunda");
				Thread.sleep(2000);
				lopfed.update_On_Society("Markandi PMFCS");
				lopfed.update_Number_Of_Verifired_Farmer("3000");
				lopfed.update_PPC_Value("Lanka");
				lopfed.update_Sold_Paddy("200");
				lopfed.update_Paddy_Procedure("300");
				lopfed.update_Receipt_Issue("100");
				lopfed.update_Note_Issue("100");
				lopfed.update_Note_Not_Issue("10");
				lopfed.update_District();
				lopfed.update_Circle();
				lopfed.update_Block();
				lopfed.click_On_Submit_Button();
				Thread.sleep(2000);
				lopfed.click_On_UpdateButton();
				Thread.sleep(2000);
				lopfed.click_On_Ok_Button();
			
				System.out.println(lopfed.get_Status());
			
				
			}
			else {
				System.out.println("Status is not pending.....");
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
