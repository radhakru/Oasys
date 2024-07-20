package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Object_page.PaddyReport;
import CamsOasys.Cams_Marketing_Object_page.ProcurementOfPaddy;

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
	public String district = "ganjam";
	public String circle = "";

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		paddy = new ProcurementOfPaddy(driver);
		paddyreport = new PaddyReport(driver);
		lp = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void click_on_login() throws IOException {
		System.out.println("Url site before click on login button...." + driver.getCurrentUrl());
		lp.click_On_Login_Dashboard();
//		wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")));
		lp.enter_Username_Field("admin194@gmail.com");
		lp.enter_Password_Field("Cams@1234");
		ScreenCapture.passScreenCapture();

		lp.click_On_Signin_Button();
		System.out.println("after click on login button=" + driver.getCurrentUrl());
		// http://cams.demoapplication.in/Seeds_Web_New/Account/Login
		if (driver.getCurrentUrl().equals("http://cams.demoapplication.in/Seeds_Web_New/Account/Login")) {
			ScreenCapture.failScreenCapture();
		} else {
			ScreenCapture.passScreenCapture();
		}

	}

	@Test(priority = 2)
	public void submit_Paddy_Form_Page() {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Paddy']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Paddy']")).click();
		paddy.select_Circle();
		paddy.select_Block();
		paddy.select_Society();
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
		
		paddy.enter_District();
		
//		paddy.enter_CirclePacs();
//		paddy.enter_Block();
//		paddy.click_onsubmitbutton();
//		paddy.click_onsubmitbuttonpopUp();
//		paddy.click_on_ok();

	}

//	@Test(priority = 3)
//	public void verify_PeddyReport() {
//		wait = new WebDriverWait(driver, 120);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Report']")));
//		driver.findElement(By.xpath("//*[text()='Procurement Report']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Paddy Report']")));
//		driver.findElement(By.xpath("//*[text()='Paddy Report']")).click();
//		paddyreport.click_On_Next_Button();
//	}
//
//	@Test(priority = 4)
//	public void verify_No_Of_Farmer_verified() {
//		String actual_mes = paddyreport.get_No_Of_farmer();
//		Assert.assertEquals(actual_mes, verified_Farmer.concat(".0"));
//
//	}
//
//	@Test(priority = 5)
//	public void verify_Name_Of_PPC() {
//		String actual_mes = paddyreport.get_Name_Of_PPC();
//		System.out.println("Name of ppc="+actual_mes);
//		Assert.assertEquals(actual_mes, ppc);
//
//	}
//
//	@Test(priority = 6)
//	public void verify_Farmer_Sold_Paddy() {
//		String actual_mes = paddyreport.get_Farmer_Sell_Paddy();
//		Assert.assertEquals(actual_mes, soldPaddy.concat(".0"));
//
//	}
//
//	@Test(priority = 7)
//	public void verify_Paddy_Procedure() {
//		String actual_mes = paddyreport.get_Farmer_Paddy_Procedure();
//		Assert.assertEquals(actual_mes, paddy_Produce.concat(".0"));
//
//	}
//
//	@Test(priority = 8)
//	public void verify_Vendor_Receipt_Issue() {
//		String actual_mes = paddyreport.get_Vendor_Received_Issue();
//		Assert.assertEquals(actual_mes, receipt_Issue.concat(".0"));
//
//	}
//
//	@Test(priority = 9)
//	public void verify_Quantity_Against_Which_TP_AC_Note_Issued() {
//		String actual_mes = paddyreport.get_enter_Quantity_Against_Which_TP_AC_Note_Issued();
//		Assert.assertEquals(actual_mes, note_issue.concat(".0"));
//
//	}
//
//	@Test(priority = 10)
//	public void verify_Quantity_Against_Which_TP_AC_Note_Not_Issued() {
//		String actual_mes = paddyreport.get_enter_Quantity_Against_Which_TP_AC_Note_Not_Issued();
//		Assert.assertEquals(actual_mes, not_Note_isuue.concat(".0"));
//
//	}
//
//	@Test(priority = 11)
//	public void verify_District_value() {
//		String actual_mes = paddyreport.get_District_Divison();
//		Assert.assertEquals(district.equalsIgnoreCase(actual_mes), true);
//
//	}
//
//	@Test(priority = 12)
//	public void verify_Circle_Value() {
//		String actual_mes = paddyreport.get_Circle_value();
//		Assert.assertEquals(!(actual_mes.equalsIgnoreCase(circle)), true);
//
//	}
//
//	@Test(priority = 13)
//	public void verify_Block_Value() {
//		String actual_mes = paddyreport.get_Block_Value();
//		Assert.assertEquals(actual_mes.equalsIgnoreCase(""), false);
//
//	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
