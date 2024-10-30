package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class saleOfSeed {
	private WebDriver ldriver;
	private Select select;
	public WebDriverWait wait;
	
	public saleOfSeed(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	private By district=By.id("DistrictId");
	private By name_Of_Pacs=By.id("pacsnamee");
	private By indent_Placed_To_Ossc=By.id("IndentPlacedtoOSSC");
	private By lifted=By.id("Lifted");
	private By Achievement=By.id("achievement");
	private By last_week=By.id("Lastweek");
	private By cash_Sale=By.id("CashSale");
	private By B_component=By.id("BCompoment");
	private By total=By.id("total");
	private By Balance_with_pacs=By.id("pacslampcs");
	private By AchievementToIndent=By.id("achievementindent");
	private By submitButton=By.id("saveData");
	private By clickOnSubmitPopup=By.xpath("(//div[@class='swal2-actions']/button[@type='button'])[1]");
	private By clickonOkButton=By.xpath("//div[@class='swal2-actions']/button[text()='OK']");
	private By croptype=By.id("croptypeid");
	private By entrydate=By.xpath("//input[@id='entrydate']");
	
	public WebDriverWait createwaitMethodInstance() {
		wait=new WebDriverWait(ldriver,120);
		return wait;
	}
	public void select_District(String distname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(district));
		select=new Select(ldriver.findElement(district));
		select.selectByVisibleText(distname.toUpperCase());
	}
	
	public void select_Name_Of_Pacs(String pacsname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(name_Of_Pacs));
		select=new Select(ldriver.findElement(name_Of_Pacs));
		select.selectByVisibleText(pacsname);
	}
	
	public void enter_Indent_Placed_To_Ossc(String indentname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(indent_Placed_To_Ossc));
		ldriver.findElement(indent_Placed_To_Ossc).sendKeys(indentname);
	}
	public void enter_lifted(String liftedname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lifted));
		ldriver.findElement(lifted).sendKeys(liftedname);
	}
	public void enter_Achievement(String val) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Achievement));
		ldriver.findElement(Achievement).sendKeys(val);
	}
	public void enter_Last_Week(String weekname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(last_week));
		ldriver.findElement(last_week).sendKeys(weekname);
	}
	public void enter_Cash_Sale(String name) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cash_Sale));
		ldriver.findElement(cash_Sale).sendKeys(name);
	}
	public void enter_BComponenet(String b_component) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(B_component));
		ldriver.findElement(B_component).sendKeys(b_component);
	}
	public void enter_Total(String val) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(total));
		ldriver.findElement(total).sendKeys(val);
	}
	
	public void Balance_With_PACS_LAMPCS(String pacs) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_with_pacs));
		ldriver.findElement(Balance_with_pacs).sendKeys(pacs);
	}
	public void enter_Achievement_To_Indent(String indentname) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AchievementToIndent));
		ldriver.findElement(AchievementToIndent).sendKeys(indentname);
	}
	public void click_On_Submit_Button() {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
		ldriver.findElement(submitButton).click();
	}
	public void click_On_Submit_Button_Popup() {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSubmitPopup));
		ldriver.findElement(clickOnSubmitPopup).click();
	}
	public void click_On_Ok_Button() {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickonOkButton));
		ldriver.findElement(clickonOkButton).click();
	}
	public void select_seed_croptype(String mes) {
		wait=createwaitMethodInstance();
		select=new Select(ldriver.findElement(croptype));
		select.deselectByVisibleText(mes);
			
		
	}
	
	public void select_seed_EntryDate(String mes) {
		wait=createwaitMethodInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(entrydate));
		ldriver.findElement(entrydate).sendKeys(mes);
	}

}
