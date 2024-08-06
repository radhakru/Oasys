package CamsOasys.Cams_Marketing_Testing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Oasys.BaseClass;

public class ValidationMessageForPaddyPage extends BaseClass {

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
		js = (JavascriptExecutor) driver;

	}

	@Test(priority = 1)
	public void landing_On_The_Marketing_Page() throws InterruptedException {
		lp.click_On_Login_Dashboard();
		Thread.sleep(2000);
		lp.enter_Username_Field("admin194@gmail.com");
		lp.enter_Password_Field("Cams@1234");
		lp.click_On_Signin_Button();

	}

	@Test(priority = 2)
	public void click_On_Paddy_Page() throws InterruptedException {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Details']")));
		driver.findElement(By.xpath("//*[text()='Procurement Details']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Procurement Of Paddy']")));
		driver.findElement(By.xpath("//*[text()='Procurement Of Paddy']")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void check_Validation_Message_For_Circle_Arcs() throws InterruptedException {
		String actual_Mes = "Please Select Circle ARCS.";
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(2000);
		// driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/div[2]/select[@id='arcs'
		// and @name='CircleARCS']/following-sibling::label")));
		String expected_mes = driver.findElement(By
				.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']/following-sibling::label"))
				.getText();
		Assert.assertEquals(actual_Mes, expected_mes);

	}

	@Test(priority = 4)
	public void check_Validation_Message_For_Circle_Arcs_Delete_Value() throws InterruptedException {
		String actual_Mes = "Please Select Circle ARCS.";
		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']")).click();
		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']")).click();
		Thread.sleep(2000);
		List<WebElement> listOfoption = driver
				.findElements(By.xpath("//select[@id='arcs' and @name='CircleARCS']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list = listOfoption.iterator();
		String[] arr = new String[listOfoption.size()];
		int i = 0;
		// Set<String> arr = new HashSet<>();
		while (list.hasNext()) {
			arr[i++] = list.next().getText();
		}
		System.out.println("1st value =" + arr[0]);

		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']"))
				.sendKeys(arr[2]);
		
		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']")).click();
		
		List<WebElement> listOfoption1 = driver
				.findElements(By.xpath("//select[@id='arcs' and @name='CircleARCS']/option"));
		System.out.println(listOfoption1.size());
		
		Iterator<WebElement> list1 = listOfoption1.iterator();
		String[] arr1 = new String[listOfoption1.size()];
		int i1 = 0;
		
		while (list1.hasNext()) {
			arr1[i1++]=list1.next().getText();
		}
		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']"))
		.sendKeys(arr1[0]);
		
		driver.findElement(By.xpath("//div[@class='row']/div[1]/select[@id='DistrictId' and @name='DistrictCoperativeDivision']/parent::div/label[1]")).click();
		
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Submit']")));
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
	Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		String expected_mes = driver.findElement(By
				.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']/following-sibling::label"))
				.getText();
		Assert.assertEquals(actual_Mes, expected_mes);
		
		
		
		
		
			

	}
	@Test(priority = 5)
	public void check_Validation_Message_For_Block() throws InterruptedException {
		String expected_Mes="Please Select Block.";
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']")).click();
		act.sendKeys(driver.findElement(By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']")),Keys.PAGE_DOWN).build().perform();
		
		driver.findElement(By.xpath("//div[@class='row']/div[1]/select[@id='DistrictId' and @name='DistrictCoperativeDivision']/parent::div/label[1]")).click();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		String actual_Message=driver.findElement(By.xpath("//div[@class='row']/div[3]/select[@id='block' and @ name = 'Block']/following-sibling::label")).getText();
		
		Assert.assertEquals(actual_Message,expected_Mes);
		//Thread.sleep(2000);
		
		
		
		
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	

}
