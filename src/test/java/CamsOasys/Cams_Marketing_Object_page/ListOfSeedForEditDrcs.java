package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfSeedForEditDrcs {
	
	public WebDriver ldriver;
	public WebDriverWait wait;
	public Actions actions;
	
	
	public ListOfSeedForEditDrcs(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		wait=new WebDriverWait(ldriver,120);
	}
	
	
	private By status=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[5]/span");
	private By lookButton=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/a/button");
	private By editButton=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/button");
	private By indentPlacedtoossc=By.xpath("//form[@id='Editseed']/div/div/fieldset/div/div[3]/input[@id='target' and @name='IndentPlacedtoOSSC']");
	private By lifted=By.xpath("//input[@id='f-repositioned']");
	private By lastweek=By.xpath("//input[@id='last-week']");
	private By cashsale=By.xpath("//input[@id='cash-sale']");
	private By b_component=By.xpath("//input[@id='b-component']");
	private By total=By.xpath("//input[@id='total']");
	private By BalanceWithPacs=By.xpath("//input[@id='pacslampcs']");
	private By achievement=By.xpath("//input[@id='achievementindent']");
	private By submitbutton=By.xpath("//*[text()='Submit']");
	private By updatebutton=By.xpath("//button[text()='Update']");
	private By cancelbutton=By.xpath("//button[text()='Update']/following-sibling::button[2]");
	private By okbutton=By.xpath("//button[contains(text(),'OK')]"); 
	
	
	public String get_Status() {
		return ldriver.findElement(status).getText();
	}
	public void click_On_Edit_Button() {
		ldriver.findElement(editButton).click();
	}
	public void enter_indentPlacetoOssc(String mes) throws InterruptedException {
		
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(indentPlacedtoossc)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
		Thread.sleep(2000);
		
	}
	public void enter_Lifted(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(lifted)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	public void enter_LastWeek(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(lastweek)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	public void enter_Cashsale(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(cashsale)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	public void enter_B_Component(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(b_component)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	
	public void enter_Total(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(total)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	
	public void enter_Balance_With_Pacs(String mes) {
		
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(BalanceWithPacs)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	public void enter_Achievement(String mes) {
		actions=new Actions(ldriver);
		actions.click(ldriver.findElement(achievement)).doubleClick().build().perform();
		actions.doubleClick().build().perform();
		actions.sendKeys(mes.trim()).build().perform();
	}
	public void click_On_Submit_Button() {
		
		ldriver.findElement(submitbutton).click();
		
	}
	public void click_On_UpdateButton() {
		
		ldriver.findElement(updatebutton).click();
	}
	public void clicl_On_Cancel_Button() {
		
		ldriver.findElement(cancelbutton).click();
	}
	public void click_On_Ok_Button() {
		ldriver.findElement(okbutton).click();
	}
}
