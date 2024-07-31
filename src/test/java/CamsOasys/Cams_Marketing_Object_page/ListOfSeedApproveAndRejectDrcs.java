package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfSeedApproveAndRejectDrcs {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	
	
	public ListOfSeedApproveAndRejectDrcs(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//status column grap
	private By status=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[5]/span");
	private By lookButton=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/a/button");
	private By locate_Placed_To_Ossc=By.xpath("//*[text()='Indent Placed To OSSC:']/following-sibling::span");
	private By lifted_Vale=By.xpath("//*[text()='Lifted:']/following-sibling::span");
	private By achievement_value=By.xpath("//*[text()='Achievement(In %):']/following-sibling::span");
	private By last_week=By.xpath("//*[text()='Last Week:']/following-sibling::span");
	private By cashSale=By.xpath("//*[text()='Cash Sale:']/following-sibling::span");
	private By b_Componenet=By.xpath("//*[text()='Cash Sale:']/following-sibling::span/parent::td/following::td[1]/span");
	private By total=By.xpath("//*[text()='Total:']/following-sibling::span");
	private By Balance_With_Pacs_Lampcs=By.xpath("//*[text()='Balance With PACS/LAMPCS:']/following-sibling::span");
	private By achievementToIndent=By.xpath("//*[text()='Achievement To Indent:']/following-sibling::span");
	private By back_Button=By.xpath("//*[text()='Back']");
	private By reason=By.id("remarks");
	private By approve_button=By.id("savedata");
	private By reject=By.id("rejectid");
	
	
	
	
	public String get_Status_Value() {
		String status_Message= ldriver.findElement(status).getText();
		return status_Message;
	}
	
	public void click_On_look_Button() {
		ldriver.findElement(lookButton).click();
	}
	
	public String get_Located_Placed_To_Ossc() {
		String located_Placed_To_Ossc=ldriver.findElement(locate_Placed_To_Ossc).getText();
		return located_Placed_To_Ossc;
	}
	
	public String get_Lifted() {
		String lifted=ldriver.findElement(lifted_Vale).getText();
		return lifted;
	}
	
	public String get_Achievement() {
		String achievement=ldriver.findElement(achievement_value).getText();
		return achievement;
	}
	
	public String get_LastWeek() {
		String lastweek=ldriver.findElement(last_week).getText();
		return lastweek;
	}
	public String get_Cashsale() {
		String cashsale=ldriver.findElement(cashSale).getText();
		return cashsale;
	}
	public String get_Bcomponent() {
		String bcomponent=ldriver.findElement(b_Componenet).getText();
		return bcomponent;
	}
	public String get_Total() {
		String totaL=ldriver.findElement(total).getText();
		return totaL;
		
	}
	public String get_Balance_With_Pacs_Lampcs() {
		String balance_with_pacs_lampcs=ldriver.findElement(Balance_With_Pacs_Lampcs).getText();
		return balance_with_pacs_lampcs;
		
	}
	
	public String get_Achievement_To_Indent() {
		String achievement_val=ldriver.findElement(achievementToIndent).getText();
		return achievement_val;
	}
	
	public void click_On_Back_Button() {
		ldriver.findElement(back_Button).click();
	}
	public void click_On_Approve_Button() {
		ldriver.findElement(approve_button).click();
	}
	public void click_On_Reject_Button() {
		ldriver.findElement(reject).click();
	}
	public void enter_Reason(String mes) {
		ldriver.findElement(reason).sendKeys(mes);
	}

}
