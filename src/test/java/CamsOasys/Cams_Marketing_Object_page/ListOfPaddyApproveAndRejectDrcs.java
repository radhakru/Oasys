package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class ListOfPaddyApproveAndRejectDrcs {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public ListOfPaddyApproveAndRejectDrcs(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By status=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[5]/span");
	private By lookButton=By.xpath("//table[@id='datatable']/tbody/tr[last()]/td[6]/a/button");
	private By circle_Pacs = By.xpath("(//*[text()='Circle ARCS:']/following-sibling::span)[1]");
	private By block_Pacs = By.xpath("//*[text()='Block:']/following-sibling::span");
	private By Society = By.xpath("//*[text()='Society:']/following-sibling::span");
	private By numberOfVerifiredFarmer = By.xpath("//*[text()='Number Of Verified Farmers:']/following-sibling::span");
	private By nameOfPPc = By.xpath("//*[text()='Name Of PPC(Multiple PPC Can Be Checked):']/following-sibling::span");
	private By numberOfFarmerSoldPaddy = By
			.xpath("//*[text()='Number Of Farmers Sold Paddy:']/following-sibling::span");
	private By quantityOfPaddyProcedure = By.xpath("//*[text()='Quantity Of Paddy Procured:']/following-sibling::span");
	private By quantityagainstwhichvendorrReceipt = By
			.xpath("//*[text()='Quantity Against Which Vendor Receipt Issued:']/following-sibling::span");
	private By quantity_Against_Tp_Ac_Note_Issue = By
			.xpath("//*[text()='Quantity Against Which TP/AC Note Issued:']/following-sibling::span");
	private By quantity_Against_Tp_Ac_Note_Not_Issue = By
			.xpath("//*[text()='Quantity Against Which TP/AC Note Not Issued:']/following-sibling::span");
	private By division = By.xpath("(//*[text()='District/Cooperative Division:']/following-sibling::span)[2]");
	private By circle = By.xpath("(//*[text()='Circle ARCS:']/following-sibling::span)[2]");
	private By block = By.xpath("(//*[text()='Block:']/following-sibling::span)[2]");
	private By reason=By.xpath("//*[text()='Reason:']/following-sibling::textarea");
	private By back_Button=By.xpath("//*[text()='Back']");
	private By approve_button=By.id("savedata");
	private By reject_button=By.id("rejectid");
	
	
	public String get_Status() {
		String actual_mes=ldriver.findElement(status).getText();
		return actual_mes;
	}
	public void click_On_lookButton() {
		ldriver.findElement(lookButton).click();
	}
	
	public String get_Circle() {
		String actual_mes = ldriver.findElement(circle_Pacs).getText();
		return actual_mes;
	}

	public String get_block() {
		String actual_mes = ldriver.findElement(block_Pacs).getText();
		return actual_mes;
	}

	public String get_Society() {
		String actual_mes=ldriver.findElement(Society).getText();
		return actual_mes;
	}
	
	public String get_Number_Of_Verifired_Framer() {
		String actual_mes=ldriver.findElement(numberOfVerifiredFarmer).getText();
		return actual_mes;
	}
	public String get_Name_Of_Ppc() {
		String actual_mes=ldriver.findElement(nameOfPPc).getText();
		return actual_mes;
	}
	public String get_Number_Of_Farmer_Sold_Paddy() {
		String actual_mes=ldriver.findElement(numberOfFarmerSoldPaddy).getText();
		return actual_mes;
	}
	
	public String get_Quantity_Of_Paddy_Produce() {
		String actual_mes=ldriver.findElement(quantityOfPaddyProcedure).getText();
		return actual_mes;
	}
	public String get_Quantity_Anaginst_Which_Vendor_Receipt_Issue() {
		String actual_mes=ldriver.findElement(quantityagainstwhichvendorrReceipt).getText();
		return actual_mes;
	}
	public String get_Quantity_Against_Which_TP_AC_Note_Issue() {
		String actual_mes=ldriver.findElement(quantity_Against_Tp_Ac_Note_Issue).getText();
		return actual_mes;
	}
	public String get_Qauntity_Against_Which_TP_AC_Note_Not_Issue() {
		String actual_mes=ldriver.findElement(quantity_Against_Tp_Ac_Note_Not_Issue).getText();
		return actual_mes;
	}
	public String get_District_Des() {
		String actual_mes=ldriver.findElement(division).getText();
		return actual_mes;
	}
	public String get_Circle_Des() {
		String actual_mes=ldriver.findElement(circle).getText();
		return actual_mes;
	}
	public String get_Block_Des() {
		String actual_mes=ldriver.findElement(block).getText();
		return actual_mes;
	}
	public void enter_reason(String mes) {
		ldriver.findElement(reason).sendKeys(mes);
	}
	public void click_On_Approve_Button() {
		ldriver.findElement(approve_button).click();
	}
	public void click_On_Reject_Button() {
		ldriver.findElement(reject_button).click();
	}
	public void click_On_BackButton() {
		ldriver.findElement(back_Button).click();
	}
	
}
