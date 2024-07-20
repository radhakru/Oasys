package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaddyReport {

	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public PaddyReport(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By pagination = By.xpath("//*[@id='listPaddyReport_next']/a[text()='Next']");
	private By circle_arcs = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[3]");
	private By block = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[4]");
	private By no_of_Farmer = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[5]");
	private By name_Of_PPC = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[6]");
	private By name_Of_Farmer_Sell_Paddy = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[7]");
	private By quantity_Of_Paddy_Procedure = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[8]");
	private By quntity_Of_Which_Vendor_Receipt_Issue = By
			.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[9]");
	private By quantity_Against_Which_Note_Issue = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[10]");
	private By quantity_Against_Which_Note_Not_Issue = By
			.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[11]");
	private By district_Divison = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[12]");
	private By circle_Arcs = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[13]");
	private By blockBy = By.xpath("(//table[@id='listPaddyReport']/tbody/tr)[last()]/td[14]");
	private By last_Page=By.xpath("//ul[@class='pagination']/li[last()-1]");

	public WebDriverWait createInstanceOfWait() {
		wait = new WebDriverWait(ldriver, 120);
		return wait;
	}

	public String get_Circle_value() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(circle_arcs));
		String mes = ldriver.findElement(circle_arcs).getText();
		return mes;
	}

	public String get_Block_Value() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(block));
		String mes = ldriver.findElement(block).getText();
		return mes;
	}

	public String get_No_Of_farmer() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(no_of_Farmer));
		String mes = ldriver.findElement(no_of_Farmer).getText();
		return mes;
	}

	public String get_Name_Of_PPC() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(name_Of_PPC));
		String mes = ldriver.findElement(name_Of_PPC).getText();
		return mes;
	}

	public String get_Farmer_Sell_Paddy() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(name_Of_Farmer_Sell_Paddy));
		String mes = ldriver.findElement(name_Of_Farmer_Sell_Paddy).getText();
		return mes;
	}

	public String get_Farmer_Paddy_Procedure() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantity_Of_Paddy_Procedure));
		String mes = ldriver.findElement(quantity_Of_Paddy_Procedure).getText();
		return mes;
	}

	public String get_Vendor_Received_Issue() {
		wait = createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quntity_Of_Which_Vendor_Receipt_Issue));
		String mes = ldriver.findElement(quntity_Of_Which_Vendor_Receipt_Issue).getText();
		return mes;
	}
	public String get_enter_Quantity_Against_Which_TP_AC_Note_Issued() {
		wait=createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantity_Against_Which_Note_Issue));
		String mes=ldriver.findElement(quantity_Against_Which_Note_Issue).getText();
		return mes;
	}

	public String get_enter_Quantity_Against_Which_TP_AC_Note_Not_Issued() {
		wait=createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantity_Against_Which_Note_Not_Issue));
		String mes=ldriver.findElement(quantity_Against_Which_Note_Not_Issue).getText();
		return mes;
	}
	public String get_District_Divison() {
		wait=createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(district_Divison));
		String mes=ldriver.findElement(district_Divison).getText();
		return mes;
	}
	public String get_Circle_Arcs() {
		wait=createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(circle_Arcs));
		String mes=ldriver.findElement(circle_Arcs).getText();
		return mes;
	}
	public String get_Block() {
		wait=createInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(blockBy));
		String mes=ldriver.findElement(blockBy).getText();
		return mes;
	}
	
	public void click_On_Next_Button() {
			Actions act=new Actions(ldriver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			System.out.println(ldriver.findElement(last_Page).isDisplayed());
			ldriver.findElement(last_Page).click();
		
	}
	
}
