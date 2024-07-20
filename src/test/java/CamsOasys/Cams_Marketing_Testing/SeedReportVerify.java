package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Object_page.SeedReport;
import CamsOasys.Cams_Marketing_Object_page.saleOfSeed;
import CamsOasys.Cams_Marketing_Utility.ReadCamsLogin;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingExcel;
import CamsOasys.Cams_Oasys.BaseClass;

public class SeedReportVerify extends BaseClass {

	public WebDriver driver;
	public saleOfSeed sos;
	public SeedReport sp;
	public LoginPage lp;
	public WebDriverWait wait;
	public String indent_placed_value = "0";
	public String lefted_value = "0";
	public String last_week_value = "0";
	public String CashSale = "0";
	public String B_Componenet = "0";
	public String total = "0";
	public String Balance_Pacs = "0";
	public String achievement_indent_value = "0";
	public JavascriptExecutor js;
	public ReadCamsMarketingExcel readcamsexcel;
	public int count = 0;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		sos = new saleOfSeed(driver);
		sp = new SeedReport(driver);
		lp = new LoginPage(driver);
		readcamsexcel = new ReadCamsMarketingExcel();

		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingExcel.class,priority = 1)
	public void click_on_login(String name, String emailId, String password, String districtname,
			String NameOfPacs, String indent_placed_To_Ossc, String Lifted, String Achievement, String LastWeek,
			String Cashsale, String BComplement, String total_value, String balance_With_Pacs_Or_LAMPS,
			String Achievement_To_Indent) throws IOException {
		System.out.println("Url site before click on login button...." + driver.getCurrentUrl());
		lp.click_On_Login_Dashboard();
//		wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")));
		lp.enter_Username_Field(emailId.trim());
		lp.enter_Password_Field(password.trim());
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

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingExcel.class, priority = 2)
	public void submit_Sell_Of_Seed_Data(String name, String emailId, String password, String districtname,
			String NameOfPacs, String indent_placed_To_Ossc, String Lifted, String Achievement, String LastWeek,
			String Cashsale, String BComplement, String total_value, String balance_With_Pacs_Or_LAMPS,
			String Achievement_To_Indent) throws InterruptedException, IOException {

		wait = new WebDriverWait(driver, 120);
		System.out.println("click on sell of seed......");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sale Of Seed')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Sale Of Seed')]")).click();
		indent_placed_value = indent_placed_To_Ossc.substring(0,indent_placed_To_Ossc.indexOf("."));
		lefted_value=Lifted.substring(0,Lifted.indexOf("."));
		last_week_value=LastWeek.substring(0,LastWeek.indexOf("."));
		CashSale=Cashsale.substring(0,Cashsale.indexOf("."));
		B_Componenet=BComplement.substring(0,BComplement.indexOf("."));
		total=total_value.substring(0,total_value.indexOf("."));
		Balance_Pacs=balance_With_Pacs_Or_LAMPS.substring(0,balance_With_Pacs_Or_LAMPS.indexOf("."));
		achievement_indent_value=Achievement_To_Indent.substring(0,Achievement_To_Indent.indexOf("."));
		
		
		Thread.sleep(2000);
		
		sos.enter_Indent_Placed_To_Ossc(indent_placed_value);
		
		sos.enter_lifted(lefted_value);
	
	
		sos.enter_Last_Week(last_week_value);
		
	
		sos.enter_Cash_Sale(CashSale);

		
		
		sos.enter_BComponenet(B_Componenet);

		
		
		sos.enter_Total(total);

	

		sos.Balance_With_PACS_LAMPCS(String.valueOf(Balance_Pacs));

	
		sos.enter_Achievement_To_Indent(achievement_indent_value);

		ScreenCapture.passScreenCapture();

		sos.click_On_Submit_Button();

		sos.click_On_Submit_Button_Popup();

		sos.click_On_Ok_Button();
		
		count++;


		System.out.println("Count value=" + count);

	}

	@Test(priority = 3)
	public void only_verify_seeds() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Input Marketing Report']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Seed Report')]")).click();
		Thread.sleep(3000);
		sp.click_On_Next_Button();
		System.out.println("Count value=" + count);
	}

//	@Test(dependsOnMethods = "submit_Sell_Of_Seed_Data")
	@Test(priority = 4)
	public void verify_Districtname_From_Sale_Of_Seed_ReportPage() {
		String actual_District = "GANJAM";

		String expected_district = sp.get_District_Value_Of_Lastrow();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		Assert.assertEquals(actual_District, expected_district);

		System.out.println("district name same.....");
		System.out.println("Count value=" + count);
	}

//	@Test(dependsOnMethods = "submit_Sell_Of_Seed_Data")
	@Test(priority = 5)
	public void verify_Pacsname_Form_Sale_Of_SeedReportPage() {
		String actual_PacsName = "Abhayapur SCS";
		String expected_PacsName = sp.get_Pacs_Value_Of_Lastrow();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		Assert.assertEquals(actual_PacsName, expected_PacsName, "Successfully verified");
		System.out.println("Count value=" + count);

	}

	@Test(priority = 6)
	public void verify_Indent_Of_Ossc_Value() throws IOException {
		System.out.println("excelvalue=" + indent_placed_value);
		String actual_value = sp.get_Indenet_Placed_To_OSSC();
		try {
			Assert.assertEquals(actual_value, indent_placed_value.concat(".0"));
			System.out.println("Execute Successfully after comparision....");
			readcamsexcel.update_cell_value(count, "Successfully verify");
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			readcamsexcel.update_cell_value(count, "not Successfully verify");
		
		}
		System.out.println("handel try catch block successfully...");

	}

	@Test(priority = 7)
	public void verify_Lifted_Value() {
		String expected_value =lefted_value.concat(".0");
		String actual_value = sp.get_Lifted();
	
		Assert.assertEquals(expected_value,actual_value);
		
	}

	@Test(priority = 8, enabled = false)
	public void verify_Achievement_Value() {
//		double res=(lefted_value/indent_placed_value)*100;
//		String actual_value=String.valueOf(res);
//		
//		System.out.println("Achievement_Value"+actual_value);
//		String expected_value=sp.get_Achievement();
//		String arr[]=expected_value.split(".");
//		System.out.println("Achievement_Value"+arr[0]);	
//		Assert.assertEquals(actual_value, arr[0]);
//		
	}

	@Test(priority = 9)
	public void verify_LastWeek_Value() {

		String actual_value = sp.get_LastWeek();
		String expected_value = last_week_value;
		System.out.println(expected_value.concat(".0"));
		Assert.assertEquals(actual_value, expected_value.concat(".0"));
	}

	@Test(priority = 10)
	public void verify_Cashsale_Value() {
		String actual_mes = sp.get_Cash_Sale();
		String expected_mes = CashSale;

		Assert.assertEquals(expected_mes.concat(".0"), actual_mes);

	}

	@Test(priority = 11)
	public void verify_BComponent_Value() {
		String actual_component = sp.get_B_Component();
		String expected_component = B_Componenet;
		Assert.assertEquals(expected_component.concat(".0"), actual_component);
	}

	@Test(priority = 12)
	public void verify_Total_Value() {
		String actual_mes = sp.get_Total();
		String expected_mes = total;
		Assert.assertEquals(expected_mes.concat(".0"), actual_mes);
	}

	@Test(priority = 13)
	public void verify_Balanace_With_Pacs_Lampcs() {
		String actual_mes = sp.get_Balanace_With_Pacs();
		String expected_mes = Balance_Pacs;
		Assert.assertEquals(expected_mes.concat(".0"), actual_mes);
	}

	@Test(priority = 14)
	public void verify_Achievement_To_Indent() throws IOException {
		String actual_mes = sp.get_Achievement_To_Indent();
		String expected_mes = achievement_indent_value;
		Assert.assertEquals(expected_mes.concat(".0"), actual_mes);
	}

	@AfterTest
	public void tear_Down() throws IOException {
		// readcamsexcel.update_cell_value(count, "good");
		driver.close();
	}

}
