package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CamsOasys.Cams_Marketing_Object_page.FertilizerReport;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Object_page.SaleFertilizer;
import CamsOasys.Cams_Marketing_Object_page.SeedReport;
import CamsOasys.Cams_Marketing_Object_page.saleOfSeed;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingExcel;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingFertilizerExcel;
import CamsOasys.Cams_Marketing_Utility.ScreenCapture;
import CamsOasys.Cams_Oasys.BaseClass;

public class FertilizerReportVerify extends BaseClass {
	public WebDriver driver;
	public SaleFertilizer sl;
	public FertilizerReport fr;
	public LoginPage lp;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public ReadCamsMarketingFertilizerExcel readcamsmarketingfertilizer;
	public String target = "100";
	public String Quantity_Of_Fertilizer_Preposition = "100";
	public String lastWeekAchieveMent = "100";
	public String CashSale = "100";
	public String BComponent = "100";
	public String Total_sale = "100";
	public String out_ofwhich_urea = "100";
	public String Balance = "100";
	public String Achievement = "100";
	public String Sale = "100";
	public String Balance_urea = "100";
	public int count = 0;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		sl = new SaleFertilizer(driver);
		fr = new FertilizerReport(driver);
		lp = new LoginPage(driver);
		readcamsmarketingfertilizer = new ReadCamsMarketingFertilizerExcel();

//		driver.manage().window().maximize();
//		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingFertilizerExcel.class,priority = 1)
	public void click_on_login(String pacsname, String eamilid, String password, String District,
			String NameOfPacks, String Target, String Quantity_Of_Fertilizer_Prepositioned, String LastWeek,
			String Cash_Sale, String B_Component, String TotalSale, String Out_Of_Which_Urea, String Balance_excel,
			String Achievement_excel, String Sale_excel, String Balance_value) throws IOException {
		System.out.println("Url site before click on login button...." + driver.getCurrentUrl());
		//lp.click_On_Login_Dashboard();
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")));
		lp.enter_Username_Field("admin194@gmail.com");//eamilid.trim()
		lp.enter_Password_Field("Cams@1234");//password.trim()
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

	@Test(dataProvider = "test", dataProviderClass = ReadCamsMarketingFertilizerExcel.class, priority = 2, enabled = true)
	public void submit_Sale_Of_Fertilizer(String pacsname, String eamilid, String password, String District,
			String NameOfPacks, String Target, String Quantity_Of_Fertilizer_Prepositioned, String LastWeek,
			String Cash_Sale, String B_Component, String TotalSale, String Out_Of_Which_Urea, String Balance_excel,
			String Achievement_excel, String Sale_excel, String Balance_value) {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sale Of Fertilizer']")));
		driver.findElement(By.xpath("//*[text()='Sale Of Fertilizer']")).click();
		target = Target.substring(0, Target.indexOf('.'));
		Quantity_Of_Fertilizer_Preposition = Quantity_Of_Fertilizer_Prepositioned.substring(0,
				Quantity_Of_Fertilizer_Prepositioned.indexOf('.'));
		lastWeekAchieveMent = LastWeek.substring(0, LastWeek.indexOf('.'));
		CashSale = Cash_Sale.substring(0, LastWeek.indexOf('.'));
		BComponent = B_Component.substring(0, B_Component.indexOf('.'));
		Total_sale = TotalSale.substring(0, TotalSale.indexOf('.'));
		out_ofwhich_urea = Out_Of_Which_Urea.substring(0, Out_Of_Which_Urea.indexOf('.'));
		Balance = Balance_excel.substring(0, Balance_excel.indexOf('.'));
		Achievement = Achievement_excel.substring(0, Achievement_excel.indexOf('.'));
		Sale = Sale_excel.substring(0, Sale_excel.indexOf('.'));
		Balance_urea = Balance_value.substring(0, Balance_value.indexOf('.'));

		sl.enter_Target(target);
		sl.enter_Quality_Of_Fortilizer_Prepositioned(Quantity_Of_Fertilizer_Preposition);
		sl.enter_LastWeek_Achievement(lastWeekAchieveMent);
		sl.enter_Cash_Sale(CashSale);
		sl.enter_B_Component(BComponent);
		sl.enter_Total_Sale(Total_sale);
		sl.enter_Out_Of_Which_Urea(out_ofwhich_urea);
		sl.enter_Balance(Balance);
		sl.enter_Achievement(Achievement);
		sl.enter_Sale(Sale);
		sl.enter_Balance_Non_Urea(Balance_urea);
		sl.click_On_Submit_Button();
		sl.click_On_Submit_PopUp();
		sl.click_On_Ok_Button();
		count++;

	}

	@Test(priority = 3)
	public void verify_FertilizerData_For_Target_value() throws IOException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing Report']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing Report']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Fertilizer Report']")));
		driver.findElement(By.xpath("//*[text()='Fertilizer Report']")).click();
		//fr.click_On_Next_Button();
		String actual_value = fr.get_Target_Value();
		try {
			Assert.assertEquals(actual_value, target.concat(".0"));
			readcamsmarketingfertilizer.update_cell_value(count, "Successfully Verifired");
			System.out.println("assertEquals().........");

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			readcamsmarketingfertilizer.update_cell_value(count, "not Verifired");
			System.out.println("this is catch block.......");
			
		}
	}

	@Test(priority = 4)
	public void verify_FertilizerData_For_Quality_Of_Fortilizer_Prepositioned_Value() {
		String mes = fr.get_Qnt_Of_Fert_Prepositioned();
		Assert.assertEquals(mes, Quantity_Of_Fertilizer_Preposition.concat(".0"));

	}

	@Test(priority = 5)
	public void verify_LastWeek_Value() {
		String mes = fr.get_Last_Week();
		Assert.assertEquals(mes, lastWeekAchieveMent.concat(".0"));
	}

	@Test(priority = 6)
	public void verify_CashSale() {
		String mes = fr.get_CashSale();
		Assert.assertEquals(mes, CashSale.concat(".0"));
	}

	@Test(priority = 7)
	public void verify_BComponent() {
		String mes = fr.get_B_Component();
		Assert.assertEquals(mes, BComponent.concat(".0"));
	}

	@Test(priority = 8)
	public void verify_Total_Sale() {
		String mes = fr.get_Total_Sale();
		Assert.assertEquals(mes, Total_sale.concat(".0"));
	}

	@Test(priority = 9)
	public void verify_Out_OfWhich_Urea() {
		String mes = fr.get_Out_OfWhich_Urea();
		Assert.assertEquals(mes, out_ofwhich_urea.concat(".0"));
	}

	@Test(priority = 10)
	public void verify_Balance() {
		String mes = fr.get_Balance();
		Assert.assertEquals(mes, Balance.concat(".0"));
	}

	@Test(priority = 11)
	public void verify_Achievement() {
		String mes = fr.get_Achievement();
		Assert.assertEquals(mes, Achievement.concat(".0"));
	}

	@Test(priority = 12)
	public void verify_Sale() {
		String mes = fr.get_Sale();
		Assert.assertEquals(mes, Sale.concat(".0"));
	}

	@Test(priority = 13)
	public void verify_Balance_Urea() {
		String mes = fr.get_Sale();
		Assert.assertEquals(mes, Sale.concat(".0"));
	}
	
	@Test(priority=14)
	public void click_OnSignout() throws InterruptedException {
		fr.click_On_Signout();
		Thread.sleep(2000);
	}


//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}

}
