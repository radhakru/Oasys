package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ValidationMessageForFertilizerpage extends BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public JavascriptExecutor js;
	@BeforeTest
	public void setUp() {
		driver = getDriver();
		lp = new LoginPage(driver);
		driverwait = new WebDriverWait(driver, 120);

		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		js=(JavascriptExecutor)driver;

	}

	@Test(priority = 1)
	public void landing_On_The_Marketing_Page() {
		lp.click_On_Login_Dashboard();
		lp.enter_Username_Field("admin194@gmail.com");
		lp.enter_Password_Field("Cams@1234");
		lp.click_On_Signin_Button();

	}

	@Test(priority = 2)
	public void click_On_Fortilizer_Page() throws InterruptedException {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sale Of Fertilizer']")));
		driver.findElement(By.xpath("//*[text()='Sale Of Fertilizer']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void check_Validation_Message_For_TargetField() throws InterruptedException {
		String validation_message = "Please Enter Target.";
		driver.findElement(By.xpath("//label[contains(text(),'Name Of PACS')]")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target']/following-sibling::label")));
		String actual_message = driver.findElement(By.xpath("//input[@id='target']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);
			Assert.assertEquals(validation_message, actual_message);
	

	}

	@Test(priority = 4)
	public void check_Validation_Message_For_Target_Delete_Value() throws InterruptedException {
		String validation_message = "Please Enter Target.";
		driver.findElement(By.id("target")).sendKeys("1000");
		driver.findElement(By.id("target")).clear();
		//driver.findElement(By.xpath("//label[contains(text(),'Name Of PACS')]")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		//act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='target']/following-sibling::label")));
		String actual_message = driver.findElement(By.xpath("//input[@id='target']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);
	
			Assert.assertEquals(validation_message, actual_message);
	
	}

	@Test(priority = 5)
	public void check_Validation_Message_For_Quantity_Of_Fertilizer() throws InterruptedException {
		driver.findElement(By.id("target")).sendKeys("100");
		String validation_message = "Please Enter Quantity Of Fertilizer Prepositioned.";
		//driver.findElement(By.xpath("//label[contains(text(),'Name Of PACS')]")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		String actual_message = driver.findElement(By.xpath("//input[@id='Prepositioned']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);

		
			Assert.assertEquals(validation_message, actual_message);
		

	}

	@Test(priority = 6)
	public void check_Validation_Message_For_Quantity_Of_Fortilizer_Delete_Value() throws InterruptedException {
		String validation_message = "Please Enter Quantity Of Fertilizer Prepositioned.";
		driver.findElement(By.id("Prepositioned")).sendKeys("100");
		driver.findElement(By.id("Prepositioned")).clear();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		String actual_message = driver.findElement(By.xpath("//input[@id='Prepositioned']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);

		
			Assert.assertEquals(validation_message, actual_message);
		

	}

	@Test(priority = 7)
	public void check_Validation_Message_For_LastWeek_Achievement() throws InterruptedException {
		driver.findElement(By.id("Prepositioned")).sendKeys("100");
		String validation_message = "Please Enter Last Week Achievement.";
		//driver.findElement(By.xpath("//label[contains(text(),'Name Of PACS')]")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='achievement']/following-sibling::label")));
		String actual_message = driver.findElement(By.xpath("//input[@id='achievement']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);
		
			Assert.assertEquals(validation_message, actual_message);
		

	}

	@Test(priority = 8)
	public void check_Validation_Messsage_For_LastWeek_Achievement_Delete_Value() throws InterruptedException {
		String validation_message = "Please Enter Last Week Achievement.";
		driver.findElement(By.id("achievement")).sendKeys("1000");
		driver.findElement(By.id("achievement")).clear();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		String actual_message = driver.findElement(By.xpath("//input[@id='achievement']/following-sibling::label"))
				.getText();
		Thread.sleep(2000);
		
			Assert.assertEquals(validation_message, actual_message);
		
	}

	@Test(priority = 9)
	public void check_Validation_Message_For_CashSale() throws InterruptedException {
		driver.findElement(By.id("achievement")).sendKeys("1000");
		String validation_message = "Please Enter Cash Sale.";
		Actions act = new Actions(driver);
		
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		String actual_message = driver.findElement(By.xpath("//input[@id='cash-sale']/following-sibling::label"))
				.getText();
		
			Assert.assertEquals(validation_message, actual_message);	
	}

	@Test(priority = 10)
	public void check_Validation_Message_For_CashSale_Delete_Value() throws InterruptedException {
		String validation_message = "Please Enter Cash Sale.";
		driver.findElement(By.id("cash-sale")).sendKeys("1000");
		driver.findElement(By.id("cash-sale")).clear();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		String actual_message = driver.findElement(By.xpath("//input[@id='cash-sale']/following-sibling::label"))
				.getText();
	
			Assert.assertEquals(validation_message, actual_message);
		
	}
	
	
	@Test(priority=11)
	public void check_Validation_Message_For_Bcomponent() throws InterruptedException {
		String validation_message="Please Enter B-Component.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cash-sale")));
		driver.findElement(By.id("cash-sale")).sendKeys("1000");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='b-component']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='b-component']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	
	
	
	
	@Test(priority=12)
	public void check_Validation_Message_For_Bcomponent_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter B-Component.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-component")));
		driver.findElement(By.id("b-component")).sendKeys("1000");
		driver.findElement(By.id("b-component")).clear();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='b-component']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='b-component']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
		
	}
	@Test(priority=13)
	public void check_validation_Message_For_TotalSale() throws InterruptedException {
		driver.findElement(By.id("b-component")).sendKeys("1000");
		String validation_message="Please Enter Total Sale.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='total-sale']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='total-sale']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
		
		
	}
	@Test(priority=14)
	public void check_Validation_Message_For_TotalSale() throws InterruptedException {
		String validation_message="Please Enter Total Sale.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-sale")));
		driver.findElement(By.id("total-sale")).sendKeys("200");
		driver.findElement(By.id("total-sale")).clear();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='total-sale']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='total-sale']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
		
	}
	
	@Test(priority=15)
	public void check_Validation_Message_For_Out_Of_Which_Urea() throws InterruptedException {
		driver.findElement(By.id("total-sale")).sendKeys("1000");
		String validation_message="Please Enter Out Of Which Urea.";
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='urea']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='urea']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	
	}
	
	@Test(priority=16)
	public void check_Validation_Message_For_Out_Of_Which_Urea_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter Out Of Which Urea.";
		driver.findElement(By.id("urea")).sendKeys("10000");
		driver.findElement(By.id("urea")).clear();
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='urea']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='urea']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	
	@Test(priority=17)
	public void check_Validation_Message_For_Balance() throws InterruptedException {
		driver.findElement(By.id("urea")).sendKeys("2000");
		String validation_message="Please Enter Balance.";
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='balance']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='balance']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
		
	}
	
	@Test(priority=18)
	public void check_Validation_Message_For_Balance_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter Balance.";
		driver.findElement(By.id("balance")).sendKeys("10000");
		driver.findElement(By.id("balance")).clear();
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='balance']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='balance']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	@Test(priority=19)
	public void check_Validation_Message_For_Achievement() throws InterruptedException {
		driver.findElement(By.id("balance")).sendKeys("10000");
		String validation_message="Please Enter Achievement(In %).";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='achievement-percent']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='achievement-percent']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
		
	}
	
	@Test(priority=20)
	public void check_Validation_Message_For_Achievement_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter Achievement(In %).";
		driver.findElement(By.id("achievement-percent")).sendKeys("10000");
		driver.findElement(By.id("achievement-percent")).clear();
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='achievement-percent']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='achievement-percent']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	@Test(priority=21)
	public void check_Validation_Message_For_Sale() throws InterruptedException {
		driver.findElement(By.id("achievement-percent")).sendKeys("10000");
		String validation_message="Please Enter Sale.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nanosale']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='nanosale']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	@Test(priority=22)
	public void check_Validation_Message_For_Sale_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter Sale.";
		driver.findElement(By.id("nanosale")).sendKeys("10000");
		driver.findElement(By.id("nanosale")).clear();
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nanosale']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='nanosale']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	
	@Test(priority=23)
	public void check_Validation_Message_For_Balance_Field() throws InterruptedException {
		driver.findElement(By.id("nanosale")).sendKeys("10");
		String validation_message="Please Enter Balance.";
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nanobalance']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='nanobalance']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	
	@Test(priority=24)
	public void check_Validation_Message_For_Balance_Field_Delete_Value() throws InterruptedException {
		String validation_message="Please Enter Balance.";
		driver.findElement(By.id("nanobalance")).sendKeys("100");
		driver.findElement(By.id("nanobalance")).clear();
		driver.findElement(By.xpath("//*[text()='This Week Achievement']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nanobalance']/following-sibling::label")));
		String actual_message=driver.findElement(By.xpath("//input[@id='nanobalance']/following-sibling::label")).getText();
		Assert.assertEquals(validation_message,actual_message);
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
