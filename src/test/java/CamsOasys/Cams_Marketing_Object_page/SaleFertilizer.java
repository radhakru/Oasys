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

public class SaleFertilizer {
	
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait; 
	
	
	
	public SaleFertilizer(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	private By Target=By.id("target");
	private By Quantity_Of_Fertilizer_Preposition=By.id("Prepositioned");
	private By lastWeekAchieveMent=By.id("achievement");
	private By CashSale=By.id("cash-sale");
	private By BCompnenet=By.id("b-component");
	private By TotalSale=By.id("total-sale");
	private By Out_Of_Which_Urea=By.id("urea");
	private By Balance=By.id("balance");
	private By Achievement=By.id("achievement-percent");
	private By Sale=By.id("nanosale");
	private By balance=By.id("nanobalance");
	private By clickOnSubmit=By.xpath("//*[text()='Submit']");
	private By clickOnSumbitpopup=By.xpath("//*[@class='swal2-actions']/button[text()='Submit']");
	private By clickOnOkButton=By.xpath("//*[@class='swal2-actions']/button[text()='OK']");
	
	public WebDriverWait CreateInstanceOfWait() {
		wait=new WebDriverWait(ldriver,120);
		return wait;
	}
	
	public void enter_Target(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
		ldriver.findElement(Target).sendKeys(mes);
		
	}
	public void enter_Quality_Of_Fortilizer_Prepositioned(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Quantity_Of_Fertilizer_Preposition));
		ldriver.findElement(Quantity_Of_Fertilizer_Preposition).sendKeys(mes);
	}
	
	public void enter_LastWeek_Achievement(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastWeekAchieveMent));
		ldriver.findElement(lastWeekAchieveMent).sendKeys(mes);
		
	}
	public void enter_Cash_Sale(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CashSale));
		ldriver.findElement(CashSale).sendKeys(mes);
	}
	public void enter_B_Component(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(BCompnenet));
		ldriver.findElement(BCompnenet).sendKeys(mes);
		
	}
	public void enter_Total_Sale(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(TotalSale));
		ldriver.findElement(TotalSale).sendKeys(mes);
	}
	public void enter_Out_Of_Which_Urea(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Out_Of_Which_Urea));
		ldriver.findElement(Out_Of_Which_Urea).sendKeys(mes);
	}
	public void enter_Balance(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Balance));
		ldriver.findElement(Balance).sendKeys(mes);
	}
	public void enter_Achievement(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Achievement));
		ldriver.findElement(Achievement).sendKeys(mes);
	}
	public void enter_Sale(String mes) {
		Actions act=new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Sale));
		ldriver.findElement(Sale).sendKeys(mes);
			
	}
	public void enter_Balance_Non_Urea(String mes) {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(balance));
		ldriver.findElement(balance).sendKeys(mes);
	}
	
	public void click_On_Submit_Button() {
		
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSubmit));
		ldriver.findElement(clickOnSubmit).click();
	}
	public void click_On_Submit_PopUp() {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSumbitpopup));
		ldriver.findElement(clickOnSumbitpopup).click();
	}
	public void click_On_Ok_Button() {
		wait=CreateInstanceOfWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnOkButton));
		ldriver.findElement(clickOnOkButton).click();
	}

}
