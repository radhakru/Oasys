package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class ValidationMessageForSaleOfSeed extends BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;

	@BeforeTest
	public void setUp() {
		driver = getDriver();
		lp = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void click_On_Login() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		lp.click_On_Login_Dashboard();
		Thread.sleep(2000);
		lp.enter_Username_Field("admin194@gmail.com");
		lp.enter_Password_Field("Cams@1234");
		lp.click_On_Signin_Button();

	}

	@Test(priority = 2)
	public void check_Validation_Indent_Placed_To_OSSC() {
		driverwait=new WebDriverWait(driver,120);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sale Of Seed')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Sale Of Seed')]")).click();
		String expected_validation = "Please Enter Indent Placed To OSSC.";

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver
				.findElement(By.xpath("//input[@id='IndentPlacedtoOSSC']/following-sibling::label")).getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}

	@Test(priority = 3)
	public void check_Validation_Indent_Placed_To_OSSC_Delete_Value() {
		String expected_validation = "Please Enter Indent Placed To OSSC.";
		driverwait = new WebDriverWait(driver, 120);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("IndentPlacedtoOSSC")));
		driver.findElement(By.id("IndentPlacedtoOSSC")).sendKeys("100");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.getMessage();

		}
		driver.findElement(By.id("IndentPlacedtoOSSC")).clear();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver
				.findElement(By.xpath("//input[@id='IndentPlacedtoOSSC']/following-sibling::label")).getText();
		Assert.assertEquals(expected_validation, actual_validation);

	}

	@Test(priority = 4)
	public void check_Validation_Leafed_Value() {
		driver.findElement(By.id("IndentPlacedtoOSSC")).sendKeys("100");
		String expected_validation = "Please Enter Lifted.";
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actual_validation = driver.findElement(By.xpath("//input[@id='Lifted']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}

	@Test(priority = 5)
	public void check_Validation_Leafed_Delete_Value() {
		String expected_validation = "Please Enter Lifted.";
		driver.findElement(By.id("Lifted")).sendKeys("90");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("Lifted")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='Lifted']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=6)
	public void check_Validation_LastWeek() {
		driver.findElement(By.id("Lifted")).sendKeys("90");
		String expected_validation = "Please Enter Last Week.";
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actual_validation = driver.findElement(By.xpath("//input[@id='Lastweek']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=7)
	public void check_Validation_LastWeek_Deleted_Value() {
		String expected_validation = "Please Enter Last Week.";
		driver.findElement(By.id("Lastweek")).sendKeys("90");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("Lastweek")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='Lastweek']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}

	@Test(priority=8)
	public void check_Validation_CashSale_Value() {
		driver.findElement(By.id("Lastweek")).sendKeys("90");
		String expected_validation = "Please Enter Cash Sale.";
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='CashSale']/following-sibling::label"))
				.getText();
		System.out.println("actual validation message "+actual_validation);
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=9)
	public void check_Validation_CashSale_Delete_Value() {
		String expected_validation = "Please Enter Cash Sale.";
		driver.findElement(By.id("CashSale")).sendKeys("90");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("CashSale")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='CashSale']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=10)
	public void check_Validation_BComponent() {
		driver.findElement(By.id("CashSale")).sendKeys("100");
		String expected_validation = "Please Enter B-Component.";
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='BCompoment']/following-sibling::label"))
				.getText();
		System.out.println("actual validation message "+actual_validation);
		Assert.assertEquals(expected_validation, actual_validation);
		
		
	}
	@Test(priority=11)
	public void check_Validation_Bcomponent_Delete_Value() {
		String expected_validation = "Please Enter B-Component.";
		driver.findElement(By.id("BCompoment")).sendKeys("1000");;
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("BCompoment")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='BCompoment']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=12)
	public void check_Validation_Total() {
		driver.findElement(By.id("BCompoment")).sendKeys("1000");
		String expected_validation = "Please Enter Total."; 
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='total']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	@Test(priority=13)
	public void check_Validtaion_Total_Delete_Value() {
		String expected_validation = "Please Enter Total."; 
		driver.findElement(By.id("total")).sendKeys("10");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("total")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='total']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	@Test(priority=14)
	public void check_Validation_Balance_PACS_LAMPCS() {
	
		driver.findElement(By.id("total")).sendKeys("100");
		String expected_validation = "Please Enter Balance With PACS/LAMPCS."; 
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='pacslampcs']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	
	@Test(priority=15)
	public void check_Validation_Balance_PACS_LAMPS_Delete_Value() {
		String expected_validation = "Please Enter Balance With PACS/LAMPCS."; 
		driver.findElement(By.id("pacslampcs")).sendKeys("10");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("pacslampcs")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='pacslampcs']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=16)
	public void check_Validation_Achievement_To_Indent() {
		driver.findElement(By.id("pacslampcs")).sendKeys("1000");
		String expected_validation = "Please Enter Achievement To Indent."; 
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='achievementindent']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	@Test(priority=17)
	public void check_Validation_Achievement_To_Indent_Delete_Value() {
		String expected_validation = "Please Enter Achievement To Indent."; 
		driver.findElement(By.id("achievementindent")).sendKeys("100");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.id("achievementindent")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual_validation = driver.findElement(By.xpath("//input[@id='achievementindent']/following-sibling::label"))
				.getText();
		Assert.assertEquals(expected_validation, actual_validation);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
