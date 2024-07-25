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

public class NonPaddyReoprt {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public NonPaddyReoprt(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By circle=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[3]");
	private By Block=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[4]");
	private By society=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[5]");
	private By Number_Of_farmer=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[6]");
	private By Name_OfPpc=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[7]");
	private By Sold_paddy=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[8]");
	private By paddy_Procedure=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[9]");
	private By Receipt_Issue=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[10]");
	private By Note_Issue=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[11]");
	private By Note_Not_Issue=By.xpath("(//table[@id='listNonPaddyReport']/tbody/tr)[1]/td[12]");
	//private By last_Page = By.xpath("//ul[@class='pagination']/li[last()-1]");
	private By profilel_page=By.xpath("//button[@id='page-header-user-dropdown']");
	private By signout=By.xpath("//button[@id='page-header-user-dropdown']/following-sibling::div/a[3]");
	
	
	public WebDriverWait createInstanceOfWait() {
		wait = new WebDriverWait(ldriver, 120);
		return wait;
	}

	public String getCircleVal() {
		String mes=ldriver.findElement(circle).getText();
		return mes;
	}
	public String getBlockVal() {
		String mes=ldriver.findElement(Block).getText();
		return mes;
	}
	public String getSociety() {
		String mes=ldriver.findElement(society).getText();
		return mes;
	}
	public String getNumberOffarmer() {
		String mes=ldriver.findElement(Number_Of_farmer).getText();
		return mes;
	}
	public String getNameOfPPc() {
		String mes=ldriver.findElement(Name_OfPpc).getText();
		return mes;
	}
	public String get_Sold_paddy() {
		String mes=ldriver.findElement(Sold_paddy).getText();
		return mes;
	}
	public String get_Paddy_Procedure() {
		String mes=ldriver.findElement(Sold_paddy).getText();
		return mes;
	}
	public String get_Receipt_Issue() {
		String mes=ldriver.findElement(Receipt_Issue).getText();
		return mes;
	}
	public String get_Note_Issue() {
		String mes=ldriver.findElement(Note_Issue).getText();
		return mes;
	}
	public String get_Note_Not_Issue() {
		String mes=ldriver.findElement(Note_Not_Issue).getText();
		return mes;
	}
	
//	public void click_On_Next_Button() {
//		ldriver.findElement(By.xpath("//div[@id='listNonPaddyReport_filter']/label")).click();
//		Actions act = new Actions(ldriver);
//		act.sendKeys(Keys.PAGE_DOWN).build().perform();
//		System.out.println(ldriver.findElement(last_Page).isDisplayed());
//		ldriver.findElement(last_Page).click();
//	}
//	
	public void click_On_Signout() {
		ldriver.findElement(profilel_page).click();
		ldriver.findElement(signout).click();
	}
	

}
