package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfNonPaddyEditForDrcs;
import CamsOasys.Cams_Marketing_Object_page.ListOfPaddyForEditDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class EditListOfNonPaddyDrcs extends BaseClass{
	
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public ListOfNonPaddyEditForDrcs lonpfed;
	
	
	
	@BeforeTest
	public void setUp() {
		driver=getDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		lonpfed=new ListOfNonPaddyEditForDrcs(driver); 
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
		lp.enter_UserNameForArcsandDrcs("payal@oasys.com");//previous username-payal1@gmail.com
		lp.enter_PasswordForArcsandDrcs("Oasys@1234");
		lp.click_On_Sign_In_Button_ArcsandDrcs();

	}
	@Test(priority=2)
	public void edit_Functionality() {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Non-Paddy List']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Non-Paddy List']")).click();
		
		System.out.println(lonpfed.get_Status());
		try {
			if(lonpfed.get_Status().equalsIgnoreCase("Pending")) {
				lonpfed.click_On_Edit_Button();
				lonpfed.update_On_Circle("Chhatrapur");
				lonpfed.update_On_Block("Chikiti");
				Thread.sleep(2000);
				lonpfed.update_On_Society("Markandi PMFCS");
				lonpfed.update_Number_Of_Verifired_Farmer("3000");
				lonpfed.update_PPC_Value("Lanka");
				lonpfed.update_Sold_Paddy("200");
				lonpfed.update_Paddy_Procedure("300");
				lonpfed.update_Receipt_Issue("100");
				lonpfed.update_Note_Issue("100");
				lonpfed.update_Note_Not_Issue("10");
				Thread.sleep(2000);
//				lonpfed.click_On_Submit_Button();
//				Thread.sleep(2000);
//				lonpfed.click_On_UpdateButton();
//				Thread.sleep(2000);
//				lonpfed.click_On_Ok_Button();
			
//				System.out.println(lonpfed.get_Status());
			
				
			}
			else {
				System.out.println("Status is not pending.....");
			}
			
		}catch(Throwable e) {
			e.getMessage();
		}
		
		
	}

}
