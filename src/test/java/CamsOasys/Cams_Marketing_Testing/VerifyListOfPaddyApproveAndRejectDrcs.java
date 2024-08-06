package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfPaddyApproveAndRejectDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Utility.ListOfPaddyExcelRead;
import CamsOasys.Cams_Oasys.BaseClass;

public class VerifyListOfPaddyApproveAndRejectDrcs extends BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public  ListOfPaddyApproveAndRejectDrcs lopaard;
	public String value = null;
	public JavascriptExecutor js;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		lp = new LoginPage(driver);
		lopaard = new ListOfPaddyApproveAndRejectDrcs(driver);
		driverwait = new WebDriverWait(driver, 120);
		js=(JavascriptExecutor)driver;

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
	
	
	
	@Test(dataProvider="test",dataProviderClass=ListOfPaddyExcelRead.class,priority=2)
	public void check_List_Of_Paddy(String pacsname, String emailId, String Pacspass, String district_cooperative,
			String circle_pacs, String pacs_block, String Society, String Number_Of_Verifired_Farmer,
			String Name_Of_PPC, String Number_Of_Farmer_Sold_Paddy, String Quantity_Of_Paddy_Procedure,
			String Quntity_Against_which_vendor_Receipt, String which_vendor_Note_Issue, String which_Vendor_Not_Issue,
			String arcs_district, String arcs_circle, String arcs_block) throws InterruptedException {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Paddy List']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Paddy List']")).click();
		
		System.out.println("Status ="+lopaard.get_Status());
		try {
			if(lopaard.get_Status().equals("Pending")) {
				lopaard.click_On_lookButton();
				js.executeScript("window.scrollBy(0,110)", "");
				Assert.assertEquals(circle_pacs,lopaard.get_Circle());
				Assert.assertEquals(pacs_block, lopaard.get_block());
				Assert.assertEquals(Society, lopaard.get_Society());
				Assert.assertEquals(Number_Of_Verifired_Farmer,lopaard.get_Number_Of_Verifired_Framer());
				Assert.assertEquals(Name_Of_PPC,lopaard.get_Name_Of_Ppc());
				Assert.assertEquals(Number_Of_Farmer_Sold_Paddy,lopaard.get_Number_Of_Farmer_Sold_Paddy());
				Assert.assertEquals(Quantity_Of_Paddy_Procedure, lopaard.get_Quantity_Of_Paddy_Produce());
				Assert.assertEquals(Quntity_Against_which_vendor_Receipt, lopaard.get_Quantity_Anaginst_Which_Vendor_Receipt_Issue());
				Assert.assertEquals(which_vendor_Note_Issue,lopaard.get_Quantity_Against_Which_TP_AC_Note_Issue());
				Assert.assertEquals(which_Vendor_Not_Issue,lopaard.get_Qauntity_Against_Which_TP_AC_Note_Not_Issue());
				Assert.assertEquals(arcs_district,lopaard.get_District_Des());
				Assert.assertEquals(arcs_circle, lopaard.get_Circle_Des());
				Assert.assertEquals(arcs_block, lopaard.get_Block_Des());
				Thread.sleep(3000);
				lopaard.enter_reason("Approved....");
				//lopaard.click_On_Reject_Button();
				lopaard.click_On_Approve_Button();
				Thread.sleep(3000);
				System.out.println("Status message a "+ lopaard.get_Status());
				
				
			}
			else {
				value="not pending...";
				System.out.println("status change "+value);
			}
			
		}catch(Throwable e) {
			e.getMessage();
		}
		if (value != null || value==null) {
			lopaard.click_On_lookButton();
			js.executeScript("window.scrollBy(0,100)", "");
			Thread.sleep(2000);
			System.out.println("get circle="+ lopaard.get_Circle());
			System.out.println("get block=" +lopaard.get_block());
			System.out.println("get society="+lopaard.get_Society());
			System.out.println("get Number Of Verified Farmers ="+lopaard.get_Number_Of_Verifired_Framer());
			System.out.println("Name Of PPC(Multiple PPC Can Be Checked)"+lopaard.get_Name_Of_Ppc());
			System.out.println("Number Of Farmers Sold Paddy"+lopaard.get_Number_Of_Farmer_Sold_Paddy());
			System.out.println("Quantity Of Paddy Procured"+lopaard.get_Quantity_Of_Paddy_Produce());
			System.out.println("Quantity Against Which Vendor Receipt Issued"+lopaard.get_Quantity_Anaginst_Which_Vendor_Receipt_Issue());
			System.out.println("Quantity Against Which TP/AC Note Issued"+lopaard.get_Quantity_Against_Which_TP_AC_Note_Issue());
			System.out.println("Quantity Against Which TP/AC Note Not Issued"+lopaard.get_Qauntity_Against_Which_TP_AC_Note_Not_Issue());
			System.out.println("District/Cooperative Division"+lopaard.get_District_Des());
			System.out.println("Circle ARCS"+lopaard.get_Circle_Des());
			System.out.println("Block"+lopaard.get_Block_Des());
			Thread.sleep(3000);
			lopaard.click_On_BackButton();
		}
		
		
		
		

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
