package CamsOasys.Cams_Marketing_Testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Utility.ExtentReport;
import CamsOasys.Cams_Marketing_Utility.ReadCamsLogin;
import CamsOasys.Cams_Marketing_Utility.ScreenCapture;
import CamsOasys.Cams_Oasys.BaseClass;
//@Listeners(ExtentReport.class)
public class CamsEntry extends BaseClass {
	public WebDriver driver;
	public Select select;
	public WebDriverWait wait;
	public ReadExcelFile readexcel;
	// public WebElement webElement;
	public ReadCamsLogin readcamslogin;
	public ExtentReport extentrep;

	public LoginPage lp;
	int count = 0;// 0

	public JavascriptExecutor js;

	@BeforeTest
	public void setup() {
		driver = getDriver();
		lp = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void click_On_Login() throws InterruptedException, IOException {

	
		lp.click_On_Login_Dashboard();

	}

	/*
	 * @Test(dataProvider = "test", dataProviderClass = ReadExcelFile.class) public
	 * void entry_Data_For_Cams(String name, String l_name, String e_name, String
	 * ph, String pass, String c_name, String s_name, String d_name, String ci_name,
	 * String add, String pin_no) throws InterruptedException, IOException {
	 * System.out.println("print firstname" + name);
	 * 
	 * // driver.findElement(By.id("registrationSumbit")).click();
	 * 
	 * if (!(name == null)) {
	 * 
	 * driver.findElement(By.id("txtFirstName")).sendKeys(name);
	 * 
	 * driver.findElement(By.id("txtLastName")).sendKeys(l_name); ++count;
	 * 
	 * driver.findElement(By.id("txtEmailId")).sendKeys(e_name + count +
	 * "@oasys.com");
	 * 
	 * Thread.sleep(3000);
	 * 
	 * System.out.println("exception handel succefully......."); //
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numMobileNo")
	 * )); driver.findElement(By.id("numMobileNo")).sendKeys(ph);
	 * 
	 * driver.findElement(By.id("txtpassword")).sendKeys(pass);
	 * 
	 * WebElement country_dropdown = driver.findElement(By.id("txtCountry")); select
	 * = new Select(country_dropdown); System.out.println("country name  = " +
	 * c_name); select.selectByVisibleText("INDIA");
	 * 
	 * WebElement state_dropdown = driver.findElement(By.id("txtState"));
	 * System.out.println("state name = " + s_name); select = new
	 * Select(state_dropdown); select.selectByVisibleText("ODISHA");
	 * 
	 * WebElement Dist_dropdown = driver.findElement(By.id("txtDistrict"));
	 * 
	 * System.out.println("district name " + d_name); select = new
	 * Select(Dist_dropdown); select.selectByVisibleText(d_name.toUpperCase());
	 * 
	 * Thread.sleep(2000); driver.findElement(By.id("txtCity")).sendKeys(ci_name);
	 * 
	 * Thread.sleep(2000); driver.findElement(By.id("txtAddress")).sendKeys(add);
	 * 
	 * driver.findElement(By.id("numPinCode")).sendKeys(pin_no);
	 * 
	 * js=(JavascriptExecutor)driver; js.executeScript("window.scrollBy(0,300)","");
	 * if (driver.findElement(By.id("registrationSumbit")).isDisplayed()) {
	 * 
	 * driver.findElement(By.id("registrationSumbit")).click(); }
	 * 
	 * Thread.sleep(2000);
	 * 
	 * driver.navigate().refresh();
	 * 
	 * 
	 * // System.out.println(pass); // System.out.println(c_name); //
	 * System.out.println(s_name); // System.out.println(d_name); //
	 * System.out.println(ci_name); // System.out.println(add); //
	 * System.out.println(pin_no); } else {
	 * System.out.println("null value is present in firstname field...."); }
	 * readexcel=new ReadExcelFile(); readexcel.create_Cell();
	 * 
	 * }
	 */
	@Test(dataProvider = "test", dataProviderClass = ReadCamsLogin.class, priority = 2)
	public void check_Credential(String name, String emailid, String pass) throws IOException, InterruptedException {

		System.out.println("driver present or not =" + driver.getTitle());

		// we call the screenCapture class in here

		int val = 1;

		if (!(name == null)) {
			++count;
			System.out.println("print in method=" + name);
			System.out.println("print in method=" + emailid);
			System.out.println("print in method=" + pass);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			// js.executeScript("document.getElementById('username').value('name');");
			System.out.println("print url=" + driver.getCurrentUrl());
			System.out.println("print title" + driver.getTitle());

			boolean bol = driver
					.findElement(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']"))
					.isDisplayed();
			System.out.println(bol);
			
			lp.enter_Username_Field(emailid);



			lp.enter_Password_Field(pass);
			ScreenCapture.passScreenCapture();

			lp.click_On_Signin_Button();
			ScreenCapture.passScreenCapture();
			System.out.println("Title=" + driver.getTitle());
			if (driver.getCurrentUrl().equals("http://cams.demoapplication.in/Seeds_Web_New/Account/Login")) {
				String unsuccessful_mes = "not login successfully...";
				readcamslogin.update_cell_value(count, unsuccessful_mes);
				ScreenCapture.failScreenCapture();
			}

			wait = new WebDriverWait(driver, 10);
			
			String pacs_name =lp.text_Value_Of_Profile();
			
			System.out.println("Pacs name present in dashboard...  " + pacs_name);

			lp.click_On_Profile_Button();

			lp.click_On_Sign_Out();

			readcamslogin = new ReadCamsLogin();
			if (val == 1) {
				readcamslogin.create_cell_cams();
				val++;
			}
			if (pacs_name.equalsIgnoreCase(name)) {
				String success_mes = "successfully login";
				readcamslogin.update_cell_value(count, success_mes);
				System.out.println("name present in excel....");

			} else if (!(pacs_name.equalsIgnoreCase(name))) {
				String unsuccessful_mes = "Pacs user name not same...";
				readcamslogin.update_cell_value(count, unsuccessful_mes);
				System.out.println("name not present in excel..");

			}

		} else {
			System.out.println("The null value found in name col...");
		}

	}

	@AfterTest
	public void teardown() throws InterruptedException, IOException {
		System.out.println("print count...." + count);
		Thread.sleep(2000);
		driver.close();
//		extentrep=new ExtentReport();
//		extentrep.addreport();
//		extentrep.onStart(null);
		
	}

}
