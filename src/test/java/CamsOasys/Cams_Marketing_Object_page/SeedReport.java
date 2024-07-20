package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeedReport {
	public WebDriver ldriver;
	public Select select;
	public String value = "GANJAM";
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public SeedReport(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	private By district = By.id("districtid");
	private By pacs = By.id("pacsid");
	private By Searchbutton = By.xpath("//*[@type='button' and text()='Search']");
	private By LasttabledistrictValue = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[2]");
	private By lasttable_pacsname = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[3]");
	private By Indent_Placed_To_OSSC = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[4]");
	private By Lifted = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[5]");
	private By Achievement = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[6]");
	private By LastWeek = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[7]");
	private By Cashsale = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[8]");
	private By BComponent = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[9]");
	private By Total = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[10]");
	private By Balance_with_pacs = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[11]");
	private By achievement_To_Indent = By.xpath("(//table[@id='listOfSeedReport']/tbody/tr)[last()]/td[12]");
	private By pagination = By.xpath("//div[@id='listOfSeedReport_paginate']/ul/li[@id='listOfSeedReport_next']/a");
	private By next_button = By.xpath("//*[@id='listOfSeedReport_next']/a");
	private By last_Page=By.xpath("//ul[@class='pagination']/li[last()-1]");

	public WebDriverWait createwaitMethodInstance() {
		wait = new WebDriverWait(ldriver, 120);
		return wait;
	}

	public void enter_District(String distname) {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(district));
		select = new Select(ldriver.findElement(district));
		select.selectByVisibleText(distname);
	}

	public void enter_Pacs(String pacs_name) {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pacs));
		select = new Select(ldriver.findElement(pacs));
		select.selectByVisibleText(pacs_name);
	}

	public void click_On_Submit_Button() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Searchbutton));
		ldriver.findElement(Searchbutton).click();
	}

	public String get_District_Value_Of_Lastrow() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasttabledistrictValue));
		value = ldriver.findElement(LasttabledistrictValue).getText();
		if (value == null) {
			return null;
		}
		return value;
	}

	public String get_Pacs_Value_Of_Lastrow() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lasttable_pacsname));
		value = ldriver.findElement(lasttable_pacsname).getText();
		if (value == null) {
			return null;
		}
		return value;

	}

	public String get_Indenet_Placed_To_OSSC() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Indent_Placed_To_OSSC));
		String mes = ldriver.findElement(Indent_Placed_To_OSSC).getText();
		return mes;
	}

	public String get_Lifted() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Lifted));
		String mes = ldriver.findElement(Lifted).getText();
		return mes;
	}

	public String get_Achievement() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Achievement));
		String mes = ldriver.findElement(Achievement).getText();
		return mes;
	}

	public String get_LastWeek() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastWeek));
		String mes = ldriver.findElement(LastWeek).getText();
		return mes;
	}

	public String get_Cash_Sale() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Cashsale));
		String mes = ldriver.findElement(Cashsale).getText();
		return mes;
	}

	public String get_B_Component() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(BComponent));
		String mes = ldriver.findElement(BComponent).getText();
		return mes;
	}

	public String get_Total() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Total));
		String mes = ldriver.findElement(Total).getText();
		return mes;
	}

	public String get_Balanace_With_Pacs() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_with_pacs));
		String mes = ldriver.findElement(Balance_with_pacs).getText();
		return mes;

	}

	public String get_Achievement_To_Indent() {
		wait = createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(achievement_To_Indent));
		String mes = ldriver.findElement(achievement_To_Indent).getText();
		return mes;
	}

//	public void click_On_Next() {
//		ldriver.findElement(next_button).click();
//	}

	public void click_On_Next_Button() throws InterruptedException {
		Actions act=new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("element is present or not ..." + ldriver.findElement(last_Page).isDisplayed());
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(last_Page));
		ldriver.findElement(last_Page).click();
	}

}
