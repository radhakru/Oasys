package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfNonPaddyApproveAndRejectDrcs;
import CamsOasys.Cams_Marketing_Object_page.ListOfSeedApproveAndRejectDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Utility.ListOfNonPaddyExcelRead;
import CamsOasys.Cams_Oasys.BaseClass;


public class VerifyNonPaddyApproveAndRejectDrcs extends BaseClass{
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public ListOfNonPaddyApproveAndRejectDrcs lonpaard;
	public String value = null;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		lp = new LoginPage(driver);
		lonpaard=new ListOfNonPaddyApproveAndRejectDrcs(driver);
		driverwait = new WebDriverWait(driver, 120);

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
	@Test(dataProvider="test",dataProviderClass=ListOfNonPaddyExcelRead.class,priority=2)
	public void check_Non_Paddy_List_Page(String name, String emailId, String pass, String district, String circle_value,
			String block_value, String society_value, String numberoffarmer, String ppc_value, String SoldPaddy,
			String paddyprocedure, String receiptissue, String noteissue, String notenotissue)  {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Non-Paddy List']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Non-Paddy List']")).click();
		
		try{
			if(lonpaard.get_Status().equals("Pending")) {
				lonpaard.click_On_lookButton();
				Assert.assertEquals(circle_value,lonpaard.get_circle());
				Assert.assertEquals(block_value, lonpaard.get_block());
				Assert.assertEquals(society_value,lonpaard.get_Society());
				Assert.assertEquals(numberoffarmer,lonpaard.get_Number_Of_Verifired_Farmer());
				Assert.assertEquals(ppc_value,lonpaard.get_Name_Of_Ppc());
				Assert.assertEquals(SoldPaddy,lonpaard.get_Number_Of_Farmer_Sold_Paddy());
				Assert.assertEquals(paddyprocedure,lonpaard.get_Qauntity_Of_Paddy_Procedure());
				Assert.assertEquals(receiptissue, lonpaard.get_Qauntity_Against_Which_Vendor_Receipt_Issued());
				Assert.assertEquals(noteissue,lonpaard.get_Qauntity_Against_Note_Issue());
				Assert.assertEquals(notenotissue,lonpaard.get_Qaunti_Against_Note_Not_Issue());
				Thread.sleep(3000);
				lonpaard.enter_Reason("Approved....");
				Thread.sleep(2000);
				lonpaard.click_On_Approve_Button();
				Thread.sleep(2000);
				System.out.println("Current status "+lonpaard.get_Status());
				
			}
			else {
				value="not pending";
				System.out.println("status value is"+value);
			}
		}catch(Throwable e) {
			e.getMessage();
		}
		
		
		if(value==null || value!=null) {
			lonpaard.click_On_lookButton();
		System.out.println(lonpaard.get_circle());
		System.out.println(	lonpaard.get_block());
		System.out.println(	lonpaard.get_Society());
		System.out.println(	lonpaard.get_Number_Of_Verifired_Farmer());
		System.out.println(	lonpaard.get_Name_Of_Ppc());
		System.out.println(	lonpaard.get_Number_Of_Farmer_Sold_Paddy());
		System.out.println(	lonpaard.get_Qauntity_Of_Paddy_Procedure());
		System.out.println(	lonpaard.get_Qauntity_Against_Which_Vendor_Receipt_Issued());
		System.out.println(	lonpaard.get_Qauntity_Against_Note_Issue());
		System.out.println(	lonpaard.get_Qaunti_Against_Note_Not_Issue());
		lonpaard.click_On_Back_Button();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
