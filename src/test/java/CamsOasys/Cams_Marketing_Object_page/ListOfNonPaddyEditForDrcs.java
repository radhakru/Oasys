package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ListOfNonPaddyEditForDrcs {
	
	public WebDriver ldriver;
	public Actions action;
	public ListOfNonPaddyEditForDrcs(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		action=new Actions(ldriver);
	}

	private By status = By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[5]/span");
	private By lookButton = By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/a/button");
	private By editButton = By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/button");
	private By circle_Arcs=By.xpath("//*[@id='arcs']");
	private By block_Arcs=By.xpath("//*[@id='block']");
	private By society_Arcs=By.xpath("//*[@id='society']");
	private By verifired_Farmer=By.xpath("//input[@id='lastweek']");
	private By nameofppc=By.xpath("//input[@id='cashsale']");
	private By soldPaddy=By.xpath("//*[@id='bcomponent']");
	private By paddyprocedure=By.xpath("//input[@id='total']");
	private By receiptIssue=By.xpath("//input[@id='pacslampcs']");
	private By noteIssue=By.xpath("//input[@id='achievementindent']");
	private By noteNotIssue=By.xpath("//input[@id='achievementindentNI']");
	private By submitbutton = By.xpath("//*[text()='Submit']");
	private By updatebutton = By.xpath("//button[text()='Update']");
	private By cancelbutton = By.xpath("//button[text()='Update']/following-sibling::button[2]");
	private By okbutton = By.xpath("//button[contains(text(),'OK')]");

	
	public String get_Status() {
		return ldriver.findElement(status).getText();
	}

	public void click_On_Edit_Button() {
		ldriver.findElement(editButton).click();
	}

	public void update_On_Circle(String mes) {
		ldriver.findElement(circle_Arcs).sendKeys(mes.trim());
	}
	public void update_On_Block(String mes) {
		ldriver.findElement(block_Arcs).sendKeys(mes);;
//		Select select=new Select(ldriver.findElement(block_Arcs));
//		select.selectByVisibleText(mes);
	}
	
	//Rangeilunda
	
	public void update_On_Society(String mes) {
		ldriver.findElement(society_Arcs).click();
		ldriver.findElement(society_Arcs).sendKeys(mes);
		
	}
	public void update_Number_Of_Verifired_Farmer(String mes) {
		action.doubleClick(ldriver.findElement(verifired_Farmer)).sendKeys(mes).build().perform();
	}
	
	public void update_PPC_Value(String mes) {
		action.doubleClick(ldriver.findElement(nameofppc)).sendKeys(mes).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	public void update_Paddy_Procedure(String mes) {
		action.doubleClick(ldriver.findElement(paddyprocedure)).sendKeys(mes).build().perform();
	}
	
	public void update_Sold_Paddy(String mes) {
		action.doubleClick(ldriver.findElement(soldPaddy)).sendKeys(mes).build().perform();
	}
	
	public void update_Receipt_Issue(String mes) {
		action.doubleClick(ldriver.findElement(receiptIssue)).sendKeys(mes).build().perform();
	}
	public void update_Note_Issue(String mes) {
		action.doubleClick(ldriver.findElement(noteIssue)).sendKeys(mes).build().perform();
	}
	public void update_Note_Not_Issue(String mes) {
		action.doubleClick(ldriver.findElement(noteNotIssue)).sendKeys(mes).build().perform();
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
