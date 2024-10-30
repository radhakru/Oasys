package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Object_page.PaddyReport;
import CamsOasys.Cams_Marketing_Object_page.ProcurementOfPaddy;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingPaddyExcel;
import CamsOasys.Cams_Marketing_Utility.ScreenCapture;
import CamsOasys.Cams_Oasys.BaseClass;

public class PaddyReportVerify extends BaseClass {
	public WebDriver driver;
	public ProcurementOfPaddy paddy;
	public PaddyReport paddyreport;
	public LoginPage lp;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public String verified_Farmer = "100";
	public String ppc = "100";
	public String soldPaddy = "100";
	public String paddy_Produce = "100";
	public String receipt_Issue = "100";
	public String note_issue = "100";
	public String not_Note_isuue = "100";
	public String district = "";
	public String circle = "";
	public String block = "";
	public String destination_district = "";
	public String destination_circle = "";
	public String destination_block = "";
	public ReadCamsMarketingPaddyExcel readcamsmarketingpaddyexcel;
	public int count = 0;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		paddy = new ProcurementOfPaddy(driver);
		paddyreport = new PaddyReport(driver);
		lp = new LoginPage(driver);
		readcamsmarketingpaddyexcel = new ReadCamsMarketingPaddyExcel();

//		driver.manage().window().maximize();
//		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingPaddyExcel.class,priority = 1)
	public void click_on_login(String pacsname, String emailId, String Pacspass, String district_cooperative,
			String circle_pacs, String pacs_block, String Society, String Number_Of_Verifired_Farmer,
			String Name_Of_PPC, String Number_Of_Farmer_Sold_Paddy, String Quantity_Of_Paddy_Procedure,
			String Quntity_Against_which_vendor_Receipt, String which_vendor_Note_Issue, String which_Vendor_Not_Issue,
			String arcs_district, String arcs_circle, String arcs_block) throws IOException {
		System.out.println("Url site before click on login button...." + driver.getCurrentUrl());
//		lp.click_On_Login_Dashboard();
//		wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")));
		lp.enter_Username_Field(emailId);//emailId.trim()
		lp.enter_Password_Field(Pacspass);//password.trim()
		ScreenCapture.passScreenCapture();

		lp.click_On_Signin_Button();
		System.out.println("after click on login button=" + driver.getCurrentUrl());
		// http://cams.demoapplication.in/Seeds_Web_New/Account/Login
		if (driver.getCurrentUrl().equals("http://cams.demoapplication.in/Seeds_Web_New/Account/Login")) {
			count++;
			readcamsmarketingpaddyexcel.update_cell_value(count,"not Success");
			ScreenCapture.failScreenCapture();
		} else {
			ScreenCapture.passScreenCapture();
		}

	}

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingPaddyExcel.class, priority = 2)
	public void submit_Paddy_Form_Page(String pacsname, String emailId, String Pacspass, String district_cooperative,
			String circle_pacs, String pacs_block, String Society, String Number_Of_Verifired_Farmer,
			String Name_Of_PPC, String Number_Of_Farmer_Sold_Paddy, String Quantity_Of_Paddy_Procedure,
			String Quntity_Against_which_vendor_Receipt, String which_vendor_Note_Issue, String which_Vendor_Not_Issue,
			String arcs_district, String arcs_circle, String arcs_block) throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Paddy']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Paddy']")).click();
		district = arcs_district;
		circle = arcs_circle;
		block = arcs_block;
		paddy.select_Circle(circle_pacs);
		paddy.select_Block(pacs_block);
		paddy.select_Society(Society);
		verified_Farmer = Number_Of_Verifired_Farmer.substring(0, Number_Of_Verifired_Farmer.indexOf('.'));
		ppc = Name_Of_PPC;
		soldPaddy = Number_Of_Farmer_Sold_Paddy.substring(0, Number_Of_Farmer_Sold_Paddy.indexOf('.'));
		paddy_Produce = Quantity_Of_Paddy_Procedure.substring(0, Quantity_Of_Paddy_Procedure.indexOf('.'));
		receipt_Issue = Quntity_Against_which_vendor_Receipt.substring(0,
				Quntity_Against_which_vendor_Receipt.indexOf('.'));
		note_issue = which_vendor_Note_Issue.substring(0, which_vendor_Note_Issue.indexOf('.'));
		not_Note_isuue = which_Vendor_Not_Issue.substring(0, which_Vendor_Not_Issue.indexOf('.'));
		destination_district = arcs_district;
		destination_circle = arcs_circle;
		destination_block = arcs_block;

		paddy.enter_Number_Of_Verifiered_Farmer(verified_Farmer);
		paddy.enter_NameOf_PPC(ppc);
		paddy.enter_Number_Of_Farmer_Sold_Paddy(soldPaddy);
		paddy.enter_QuatityOf_Paddy_Procedure(paddy_Produce);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		paddy.enter_Quatity_Against_With_Vendor_Vendor_Receipt_Issue(receipt_Issue);

		paddy.enter_Quantity_Against_Which_TP_AC_Note_Issued(note_issue);

		paddy.enter_Quantity_Against_Which_TP_AC_Note_Not_Issued(not_Note_isuue);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.getMessage();
		}

		paddy.enter_District(arcs_district);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.getMessage();
		}

		paddy.enter_CirclePacs(arcs_circle);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.getMessage();
		}

		paddy.enter_Block(arcs_block);
		paddy.click_onsubmitbutton();
		paddy.click_onsubmitbuttonpopUp();
		paddy.click_on_ok();
		count++;

	}

	@Test(priority = 3)
	public void verify_PeddyReport() {
		driver.findElement(By.xpath("//*[text()='Procurement Report']")).click();
		driver.findElement(By.xpath("//*[text()='Paddy Report']")).click();
		// paddyreport.click_On_Next_Button();
	}

	@Test(priority = 4)
	public void verify_No_Of_Farmer_verified() throws IOException {
		String actual_mes = paddyreport.get_No_Of_farmer();
		try {
			Assert.assertEquals(actual_mes, verified_Farmer.concat(".0"));
			readcamsmarketingpaddyexcel.update_cell_value(count, "Successfully Verified");
		} catch (Throwable e) {
			readcamsmarketingpaddyexcel.update_cell_value(count, "Not Verified");
		}
	}

	@Test(priority = 5)
	public void verify_Name_Of_PPC() {
		String actual_mes = paddyreport.get_Name_Of_PPC();
		System.out.println("Name of ppc=" + actual_mes);
		Assert.assertEquals(actual_mes, ppc);

	}

	@Test(priority = 6)
	public void verify_Farmer_Sold_Paddy() {
		String actual_mes = paddyreport.get_Farmer_Sell_Paddy();
		Assert.assertEquals(actual_mes, soldPaddy.concat(".0"));

	}

	@Test(priority = 7)
	public void verify_Paddy_Procedure() {
		String actual_mes = paddyreport.get_Farmer_Paddy_Procedure();
		Assert.assertEquals(actual_mes, paddy_Produce.concat(".0"));

	}

	@Test(priority = 8)
	public void verify_Vendor_Receipt_Issue() {
		String actual_mes = paddyreport.get_Vendor_Received_Issue();
		Assert.assertEquals(actual_mes, receipt_Issue.concat(".0"));

	}

	@Test(priority = 9)
	public void verify_Quantity_Against_Which_TP_AC_Note_Issued() {
		String actual_mes = paddyreport.get_enter_Quantity_Against_Which_TP_AC_Note_Issued();
		Assert.assertEquals(actual_mes, note_issue.concat(".0"));

	}

	@Test(priority = 10)
	public void verify_Quantity_Against_Which_TP_AC_Note_Not_Issued() {
		String actual_mes = paddyreport.get_enter_Quantity_Against_Which_TP_AC_Note_Not_Issued();
		Assert.assertEquals(actual_mes, not_Note_isuue.concat(".0"));

	}

	@Test(priority = 11)
	public void verify_District_value() {
		String actual_mes = paddyreport.get_District_Divison();
		Assert.assertEquals(actual_mes, destination_district);

	}

	@Test(priority = 12)
	public void verify_Circle_Value() {
		String actual_mes = paddyreport.get_Circle_Arcs();
		Assert.assertEquals(actual_mes, destination_circle);

	}

	@Test(priority = 13)
	public void verify_Block_Value() {
		String actual_mes = paddyreport.get_Block();
		Assert.assertEquals(actual_mes, destination_block);

	}

	@Test(priority = 14)
	public void click_On_Signout() throws InterruptedException {
		paddyreport.click_On_ProfilePage();
		paddyreport.click_On_SignOut();
		Thread.sleep(2000);
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}

}
