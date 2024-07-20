package CamsOasys.Cams_Marketing_Object_page;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class ProcurementOfPaddy {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public ProcurementOfPaddy(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By arcs_Circle = By.xpath("//div[@class='row']/div[2]/select[@id='arcs' and @name='CircleARCS']");
	private By all_Circle_List = By.xpath("//select[@id='arcs']/option");
	private By arcs_Block = By.id("block");
	private By all_Block_List = By.xpath("//select[@id='block']/option");
	private By Society = By.id("society");
	private By all_Society_List = By.xpath("//select[@id='society']/option");
	private By Number_Of_Verified_Farmer = By.id("lastweek");
	private By Name_Of_PPC = By.id("pccid");
	private By Number_Of_Farmer = By.id("bcomponent");
	private By Quantity_Of_Paddy_Produce = By.id("QuantityofPaddy");
	private By Qauntity_Against_Vendor_Issue = By.id("QuantityAgainstReceipt");
	private By Qauntity_Against_TPORACNOTE_ISSUED = By.id("QuantityAgainstNote");
	private By Quantity_Against_Which_TP_AC_Note_Not_Issued = By.id("achievementindent");
	private By District_Division = By.id("district1");
	private By Circle_Pacs = By.id("arcs1");
	private By block = By.id("block1");
	private By SubmitButton = By.xpath("//*[text()='Submit']");
	private By submitbuttonpopup = By.xpath("//*[@class='swal2-actions']/button[text()='Submit']");
	private By okbuttob = By.xpath("//*[@class='swal2-actions']/button[text()='OK']");

	public WebDriverWait createInstanceOfWait() {
		wait = new WebDriverWait(ldriver, 120);
		return wait;
	}

	public void select_Circle() {
		ldriver.findElement(arcs_Circle).click();
		ldriver.findElement(arcs_Circle).click();
		List<WebElement> listOfoption=ldriver.findElements(By.xpath("//select[@id='arcs']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list=listOfoption.iterator();
		String[] arr=new String[listOfoption.size()];
		int i=0;
		while(list.hasNext()) {
			arr[i++]=list.next().getText();	
		}
		ldriver.findElement(arcs_Circle).sendKeys(arr[1]);
		


	}

	public void select_Block() {
		ldriver.findElement(arcs_Block).click();
		ldriver.findElement(arcs_Block).click();
		List<WebElement> listOfoption=ldriver.findElements(By.xpath("//select[@id='block']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list=listOfoption.iterator();
		String[] arr=new String[listOfoption.size()];
		int i=0;
		while(list.hasNext()) {
			arr[i++]=list.next().getText();	
		}
		ldriver.findElement(arcs_Block).sendKeys(arr[1]);
	}

	public void select_Society() {
		ldriver.findElement(Society).click();
		ldriver.findElement(Society).click();
		List<WebElement> listOfoption=ldriver.findElements(By.xpath("//select[@id='society']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list=listOfoption.iterator();
		String[] arr=new String[listOfoption.size()];
		int i=0;
		while(list.hasNext()) {
			arr[i++]=list.next().getText();	
		}
		ldriver.findElement(Society).sendKeys(arr[1]);
	}

	public void enter_Number_Of_Verifiered_Farmer(String mes) {
		ldriver.findElement(Number_Of_Verified_Farmer).sendKeys(mes);
	}

	public void enter_NameOf_PPC(String mes) {
		ldriver.findElement(Name_Of_PPC).sendKeys(mes);
	}

	public void enter_Number_Of_Farmer_Sold_Paddy(String mes) {
		ldriver.findElement(Number_Of_Farmer).sendKeys(mes);
	}

	public void enter_QuatityOf_Paddy_Procedure(String mes) {
	
		ldriver.findElement(Quantity_Of_Paddy_Produce).sendKeys(mes);
	}

	public void enter_Quatity_Against_With_Vendor_Vendor_Receipt_Issue(String mes) {
		
		ldriver.findElement(Qauntity_Against_Vendor_Issue).sendKeys(mes);
	}

	public void enter_Quantity_Against_Which_TP_AC_Note_Issued(String mes) {
		
		ldriver.findElement(Qauntity_Against_TPORACNOTE_ISSUED).sendKeys(mes);
	}

	public void enter_Quantity_Against_Which_TP_AC_Note_Not_Issued(String mes) {
		ldriver.findElement(Quantity_Against_Which_TP_AC_Note_Not_Issued).sendKeys(mes);
		
	}

	public void enter_District() {
		Actions act=new Actions(ldriver);
		act.moveToElement(ldriver.findElement(District_Division),0,900).build().perform();
//		select = new Select(ldriver.findElement(District_Division));
//		select.selectByIndex(1);
		ldriver.findElement(District_Division).click();
		ldriver.findElement(District_Division).click();
		List<WebElement> list_ele=ldriver.findElements(By.xpath("//*[@id='district1']/option"));
		System.out.println("district size"+list_ele.size());
		Iterator<WebElement> district=list_ele.iterator();
		String arr[]=new String[list_ele.size()];
		int i=0;
		while(district.hasNext()) {
			arr[i++]=district.next().getText();
		}
		ldriver.findElement(District_Division).sendKeys(arr[2]);
	}

	public void enter_CirclePacs() {
		select = new Select(ldriver.findElement(Circle_Pacs));
		select.selectByIndex(1);
	}

	public void enter_Block() {
		select = new Select(ldriver.findElement(block));
	}

	public void click_onsubmitbutton() {
		ldriver.findElement(SubmitButton).click();
	}

	public void click_onsubmitbuttonpopUp() {
		ldriver.findElement(submitbuttonpopup).click();
	}

	public void click_on_ok() {
		ldriver.findElement(okbuttob).click();
	}

}
