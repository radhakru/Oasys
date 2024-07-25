package CamsOasys.Cams_Marketing_Object_page;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

	public void select_Circle(String mes) {
		ldriver.findElement(arcs_Circle).click();
		ldriver.findElement(arcs_Circle).click();
		List<WebElement> listOfoption = ldriver.findElements(By.xpath("//select[@id='arcs']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list = listOfoption.iterator();
		// String[] arr=new String[listOfoption.size()];
		// int i=0;
		Set<String> arr = new HashSet<>();
		while (list.hasNext()) {
			arr.add(list.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(arcs_Circle).sendKeys(mes);
		}

	}

	public void select_Block(String mes) {
		ldriver.findElement(arcs_Block).click();
		ldriver.findElement(arcs_Block).click();
		List<WebElement> listOfoption = ldriver.findElements(By.xpath("//select[@id='block']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list = listOfoption.iterator();
		Set<String> arr = new HashSet<>();
		while (list.hasNext()) {
			arr.add(list.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(arcs_Block).sendKeys(mes);
		}
		else {
			System.out.println("block is not present...");
		}
	}

	public void select_Society(String mes) throws InterruptedException {
		ldriver.findElement(Society).click();
		ldriver.findElement(Society).click();
		List<WebElement> listOfoption = ldriver.findElements(By.xpath("//select[@id='society']/option"));
		System.out.println(listOfoption.size());
		Iterator<WebElement> list = listOfoption.iterator();
		Set<String> arr = new HashSet<>();
		while (list.hasNext()) {
			arr.add(list.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(Society).sendKeys(mes);
		}
		else {
			System.out.println("This value is not present in society...");
		}
		
	}

	public void enter_Number_Of_Verifiered_Farmer(String mes) {
		ldriver.findElement(By.xpath("//input[@id='lastweek']/parent::div/label")).click();
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		ldriver.findElement(Number_Of_Verified_Farmer).sendKeys(mes);
		// js.executeScript("document.getElementById('Number_Of_Verified_Farmer').value(mes);");
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

	public void enter_District(String mes) {
		ldriver.findElement(District_Division).click();
		ldriver.findElement(District_Division).click();
		List<WebElement> list_ele = ldriver.findElements(By.xpath("//*[@id='district1']/option"));
		System.out.println("district size" + list_ele.size());
		Iterator<WebElement> district = list_ele.iterator();
		Set<String> arr = new HashSet<>();
		while (district.hasNext()) {
			arr.add(district.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(District_Division).sendKeys(mes);
		}
		else {
			System.out.println("This value is not present in society...");
		}

	}

	public void enter_CirclePacs(String mes) {
		ldriver.findElement(Circle_Pacs).click();
		ldriver.findElement(Circle_Pacs).click();
		List<WebElement> list_ele = ldriver.findElements(By.xpath("//*[@id='arcs1']/option"));
		System.out.println("circle size" + list_ele.size());
		Iterator<WebElement> district = list_ele.iterator();
		Set<String> arr = new HashSet<>();
		while (district.hasNext()) {
			arr.add(district.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(Circle_Pacs).sendKeys(mes);
		}
		else {
			System.out.println("This value is not present in society...");
		}

	}

	public void enter_Block(String mes) {
		ldriver.findElement(block).click();
		ldriver.findElement(block).click();
		List<WebElement> list_ele = ldriver.findElements(By.xpath("//*[@id='block1']/option"));
		System.out.println("block size" + list_ele.size());
		Iterator<WebElement> district = list_ele.iterator();
		Set<String> arr = new HashSet<>();
		while (district.hasNext()) {
			arr.add(district.next().getText());
		}
		if (arr.contains(mes)) {
			ldriver.findElement(block).sendKeys(mes);
		}
		else {
			System.out.println("This value is not present in society...");
		}
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
