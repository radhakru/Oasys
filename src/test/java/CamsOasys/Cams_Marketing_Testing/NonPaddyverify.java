package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Object_page.NonPaddyReoprt;
import CamsOasys.Cams_Marketing_Object_page.ProcurementOfNonPaddy;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingNonPaddyExcel;

import CamsOasys.Cams_Oasys.BaseClass;
 

public class NonPaddyverify extends BaseClass {
	public WebDriver driver;
	public ProcurementOfNonPaddy nonpaddy;
	public NonPaddyReoprt nonpaddyreport;
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
	public ReadCamsMarketingNonPaddyExcel readcamsmarketingnonpaddy;
	public int count=0;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		nonpaddy = new ProcurementOfNonPaddy(driver);
		nonpaddyreport = new NonPaddyReoprt(driver);
		lp = new LoginPage(driver);
		readcamsmarketingnonpaddy = new ReadCamsMarketingNonPaddyExcel();

//		driver.manage().window().maximize();
//		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void click_on_login() throws IOException {
		System.out.println("Url site before click on login button...." + driver.getCurrentUrl());
//		lp.click_On_Login_Dashboard();
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

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingNonPaddyExcel.class, priority = 2)
	public void submit_Non_Paddy_Page(String name, String emailId, String pass, String district, String circle_value,
			String block_value, String society_value, String numberoffarmer, String ppc_value, String SoldPaddy,
			String paddyprocedure, String receiptissue, String noteissue, String notenotissue) {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Non-Paddy']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Non-Paddy']")).click();
		verified_Farmer=numberoffarmer.substring(0,numberoffarmer.indexOf('.'));
		ppc=ppc_value;
		soldPaddy=SoldPaddy.substring(0,SoldPaddy.indexOf('.'));
		paddy_Produce=paddyprocedure.substring(0,paddyprocedure.indexOf('.'));
		receipt_Issue=receiptissue.substring(0, receiptissue.indexOf('.'));
		note_issue=noteissue.substring(0, noteissue.indexOf('.'));
		not_Note_isuue=notenotissue.substring(0, notenotissue.indexOf('.'));
		nonpaddy.select_Circle(circle_value);
		nonpaddy.select_block(block_value);
		nonpaddy.select_Society(society_value);
		nonpaddy.enter_Number_Of_Verifired_number(verified_Farmer);
		nonpaddy.enter_Name_Of_Ppc(ppc);
		nonpaddy.enter_Sold_Paddy(soldPaddy);
		nonpaddy.enter_Paddy_Procedure(paddy_Produce);
		nonpaddy.enter_Reccepit_Issued(receipt_Issue);
		nonpaddy.enter_NoteIssue(note_issue);
		nonpaddy.enter_NoteNotIssue(not_Note_isuue);
		nonpaddy.clickonsubmitbutton();
		nonpaddy.click_onsubmitbuttonpopUp();
		nonpaddy.click_on_ok();
		count++;
	}

	@Test(priority = 3)
	public void verify_Non_Paddy() {
		driver.findElement(By.xpath("//*[text()='Procurement Report']")).click();
		driver.findElement(By.xpath("//*[text()='Non-Paddy Report']")).click();
		//nonpaddyreport.click_On_Next_Button();
	}

	@Test(priority = 4)
	public void verify_circle(){

		String actual_value = nonpaddyreport.getCircleVal();
		Assert.assertEquals(actual_value, "Berhampur");
		
	}

	@Test(priority = 5)
	public void verify_block() {
		String actual_block = nonpaddyreport.getBlockVal();
		Assert.assertEquals(actual_block, "Digapahandi");
	}

	@Test(priority = 6)
	public void verify_society() {
		String actual_society = nonpaddyreport.getSociety();
		Assert.assertEquals(actual_society, "Bomakai");
	}

	@Test(priority = 7)
	public void verify_Farmer_Verify() throws IOException {
		String actual_mes = nonpaddyreport.getNumberOffarmer();
		//Assert.assertEquals(actual_mes, verified_Farmer.concat(".0"));
		try{
			Assert.assertEquals(actual_mes, verified_Farmer.concat(".0"));
			readcamsmarketingnonpaddy.update_cell_value(count, "Successfully Verified");
		}
		catch(Throwable e) {
			readcamsmarketingnonpaddy.update_cell_value(count, "Not Verified");
		}
	}

	@Test(priority = 8)
	public void verify_ppc() {
		String actual_mes = nonpaddyreport.getNameOfPPc();
		Assert.assertEquals(actual_mes, ppc);
	}

	@Test(priority = 9)
	public void verify_Sold_Paddy() {
		String actual_mes = nonpaddyreport.get_Sold_paddy();
		Assert.assertEquals(actual_mes, soldPaddy.concat(".0"));
	}

	@Test(priority = 10)
	public void verify_Paddy_Procedure() {
		String actual_mes = nonpaddyreport.get_Paddy_Procedure();
		Assert.assertEquals(actual_mes, paddy_Produce.concat(".0"));
	}

	@Test(priority = 11)
	public void verify_Receipt_Issue() {
		String actual_mes = nonpaddyreport.get_Receipt_Issue();
		Assert.assertEquals(actual_mes, receipt_Issue.concat(".0"));
	}

	@Test(priority = 12)
	public void verify_Note_Issue() {
		String actual_mes = nonpaddyreport.get_Note_Issue();
		Assert.assertEquals(actual_mes, note_issue.concat(".0"));
	}

	@Test(priority = 13)
	public void verify_Note_Not_Issue() {
		String actual_mes = nonpaddyreport.get_Note_Not_Issue();
		Assert.assertEquals(actual_mes, not_Note_isuue.concat(".0"));
	}
	@Test(priority=14)
	public void click_on_signout() throws InterruptedException {
		nonpaddyreport.click_On_Signout();
		Thread.sleep(2000);
	}

	

}
