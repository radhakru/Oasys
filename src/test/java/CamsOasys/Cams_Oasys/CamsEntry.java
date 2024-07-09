package CamsOasys.Cams_Oasys;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class CamsEntry {

	public WebDriver driver;
	public Select select;
	public WebDriverWait wait;
	public ReadExcelFile readexcel;
	// public WebElement webElement;
	public ReadCamsLogin readcamslogin;
	int count = 0;//0

	public JavascriptExecutor js;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		if (driver == null) {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void click_On_Login() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
//		 driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://bimsdemo.demoapplication.in/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnseed1']")).click();
		driver.findElement(By.xpath("//*[@id='btnseed1']")).click();

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

		int val = 1;

		if (!(name == null)) {
			++count;
			System.out.println("print in method=" + name);
			System.out.println("print in method=" + emailid);
			System.out.println("print in method=" + pass);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			// js.executeScript("document.getElementById('username').value('name');");
		System.out.println("print url="+	driver.getCurrentUrl());
			System.out.println("print title"+driver.getTitle());
			boolean bol = driver.findElement(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")).isDisplayed();
			System.out.println(bol);
			driver.findElement(By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']")).sendKeys(emailid.trim());
//			
//			
//			driver.findElement(By.xpath("(//input[@name='Email'])[1]")).click();
//			System.out.println("value reads...");
			driver.findElement(By.id("userpassword")).sendKeys(pass.trim());

			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			readcamslogin = new ReadCamsLogin();
			System.out.println("Title="+driver.getTitle());
			if(driver.getCurrentUrl().equals("http://cams.demoapplication.in/Seeds_Web_New/Account/Login")) {
				String unsuccessful_mes = "not login successfully...";
				readcamslogin.update_cell_value(count,unsuccessful_mes);
			}
			

			wait = new WebDriverWait(driver, 10);
			// wait.until(ExpectedConditions
			// .visibilityOfElementLocated(By.xpath("//button[@id='page-header-user-dropdown']/span")));
			String pacs_name = driver.findElement(By.xpath("//button[@id='page-header-user-dropdown']/span")).getText();
			System.out.println("Pacs name present in dashboard...  " + pacs_name);
			
			driver.findElement(By.xpath("//button[@id='page-header-user-dropdown']")).click();		
			driver.findElement(By.xpath("//span[text()='Sign out']")).click();

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
				String unsuccessful_mes = "not login successfully...";
				readcamslogin.update_cell_value(count, unsuccessful_mes);
				System.out.println("name not present in excel..");
			}
			

		} else {
			System.out.println("The null value found in name col...");
		}

	}

	@AfterTest
	public void teardown() throws InterruptedException {
		System.out.println("print count...." + count);
		Thread.sleep(2000);
		driver.close();
	}

}
