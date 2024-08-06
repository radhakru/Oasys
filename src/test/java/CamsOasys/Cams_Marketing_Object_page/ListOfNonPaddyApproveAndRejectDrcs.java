package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfNonPaddyApproveAndRejectDrcs {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public ListOfNonPaddyApproveAndRejectDrcs(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	private By status=By.xpath("//table[@id='datatable']/tbody/tr[1]/td[5]/span");
	private By lookButton=By.xpath("//table[@id='datatable']/tbody/tr[1]/td[6]/a/button");
	private By circle=By.xpath("//*[text()='Circle ARCS:']/following-sibling::span");
	private By block=By.xpath("//*[text()='Block:']/following-sibling::span");
	private By society=By.xpath("//*[text()='Society:']/following-sibling::span");
	private By number_Of_Verifired_Farmer=By.xpath("//*[text()='Number Of Verified Farmers:']/following-sibling::span");
	private By name_Of_Ppc=By.xpath("//*[text()='Name Of PPC(Multiple PPC Can Be Checked):']/following-sibling::span");
	private By numberOfSoldpaddy=By.xpath("//*[text()='Number Of Farmers Sold Paddy:']/following-sibling::span");
	private By quantityOfPaddyProcedure=By.xpath("//*[text()='Quantity Of Paddy Procured:']/following-sibling::span");
	private By qauntityAgainstwhichvendorreceiptissued=By.xpath("//*[text()='Quantity Against Which Vendor Receipt Issued:']/following-sibling::span");
	private By qantityOfNoteIssue=By.xpath("//*[text()='Quantity Against Which TP/AC Note Issued:']/following-sibling::span");
	private By qantityOfNoteNotIssue=By.xpath("//*[text()='Quantity Against Which TP/AC Note Not Issued:']/following-sibling::span");
	private By reason=By.xpath("//*[text()='Reason:']/following-sibling::textarea");
	private By back_Button=By.xpath("//*[text()='Back']");
	private By approve_button=By.id("savedata");
	private By reject_button=By.id("rejectid");
	
	
	
	public String get_Status() {
		return ldriver.findElement(status).getText();
	}
	public void click_On_lookButton() {
		ldriver.findElement(lookButton).click();
	}
	public String get_circle() {
		return ldriver.findElement(circle).getText();
	}
	public String get_block() {
		return ldriver.findElement(block).getText();
	}
	public String get_Society() {
		return ldriver.findElement(society).getText();
	}
	public String get_Number_Of_Verifired_Farmer() {
		return ldriver.findElement(number_Of_Verifired_Farmer).getText();
	}
	public String get_Name_Of_Ppc() {
		return ldriver.findElement(name_Of_Ppc).getText();
	}
	public String get_Number_Of_Farmer_Sold_Paddy() {
		return ldriver.findElement(numberOfSoldpaddy).getText();
	}
	public String get_Qauntity_Of_Paddy_Procedure() {
		return ldriver.findElement(quantityOfPaddyProcedure).getText();
	}
	public String get_Qauntity_Against_Which_Vendor_Receipt_Issued() {
		return ldriver.findElement(qauntityAgainstwhichvendorreceiptissued).getText();
	}
	public String get_Qauntity_Against_Note_Issue() {
		return ldriver.findElement(qantityOfNoteIssue).getText();
	}
	public String get_Qaunti_Against_Note_Not_Issue() {
		return ldriver.findElement(qantityOfNoteNotIssue).getText();
	}
	
	public void enter_Reason(String mes) {
		ldriver.findElement(reason).sendKeys(mes);
	}
	public void click_On_Approve_Button() {
		ldriver.findElement(approve_button).click();
	}
	public void click_On_Reject_Button() {
		ldriver.findElement(reject_button).click();
	}
	public void click_On_Back_Button() {
		ldriver.findElement(back_Button).click();
	}

}
