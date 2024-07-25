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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcurementOfNonPaddy {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public ProcurementOfNonPaddy(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By circle = By.id("arcs");
	private By block = By.id("block");
	private By society = By.id("society");
	private By Number_Of_farmer = By.id("lastweek");
	private By Number_Of_ppc = By.id("cashsale");
	private By sold_Paddy = By.id("bcomponent");
	private By paddy_Procedure = By.id("QuantityofPaddy");
	private By Receipt_Issue = By.id("QuantityAgainstReceipt");
	private By Note_Issue = By.id("QuantityAgainstNote");
	private By not_Issue = By.id("achievementindent");
	private By SubmitButton = By.xpath("//*[text()='Submit']");
	private By submitbuttonpopup = By.xpath("//*[@class='swal2-actions']/button[text()='Submit']");
	private By okbuttob = By.xpath("//*[@class='swal2-actions']/button[text()='OK']"); 

	public void select_Circle(String mes) {
		ldriver.findElement(circle).click();
		ldriver.findElement(circle).click();
		List<WebElement> circle_list = ldriver.findElements(By.xpath("//select[@id='arcs']/option"));
		Iterator<WebElement> circle_list_arcs = circle_list.iterator();
		System.out.println("circle list=" + circle_list.size());
		Set<String> circle_set = new HashSet<>();
		while (circle_list_arcs.hasNext()) {
			circle_set.add(circle_list_arcs.next().getText());
		}
		if (circle_set.contains(mes)) {
			ldriver.findElement(circle).sendKeys(mes);
		}
		else {
			System.out.println("this circle not present in this .......");
		}
	}
	
	public void select_block(String mes) {
		ldriver.findElement(block).click();
		ldriver.findElement(block).click();
		List<WebElement> block_List=ldriver.findElements(By.xpath("//select[@id='block']/option"));
		Iterator<WebElement> block_list=block_List.iterator();
		System.out.println("block list="+block_List.size());
		Set<String> block_set=new HashSet<>();
		while(block_list.hasNext()) {
			block_set.add(block_list.next().getText());
		}
		if(block_set.contains(mes)){
			ldriver.findElement(block).sendKeys(mes);
		}
		else {
			System.out.println("this block is not present in block set....");
		}
	}
	public void select_Society(String mes) {
		ldriver.findElement(society).click();
		ldriver.findElement(society).click();
		List<WebElement> society_List=ldriver.findElements(By.xpath("//select[@id='society']/option"));
		System.out.println("society list"+society_List.size());
		Iterator<WebElement> society_iterator= society_List.iterator();
		Set<String> society_set=new HashSet<>();
		while(society_iterator.hasNext()) {
			society_set.add(society_iterator.next().getText());
		}
		if(society_set.contains(mes)) {
			ldriver.findElement(society).sendKeys(mes);
		}
		else {
			System.out.println("society not present...");
		}
		
	}
	
	
	public void enter_Number_Of_Verifired_number(String mes) {
		ldriver.findElement(Number_Of_farmer).click();
		Actions act=new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		ldriver.findElement(Number_Of_farmer).sendKeys(mes);
		
		
	}
	public void enter_Name_Of_Ppc(String mes) {
		ldriver.findElement(Number_Of_ppc).sendKeys(mes);
	}
	public void enter_Sold_Paddy(String mes) {
		ldriver.findElement(sold_Paddy).sendKeys(mes);
	}
	public void enter_Paddy_Procedure(String mes) {
		ldriver.findElement(paddy_Procedure).sendKeys(mes);
	}
	public void enter_Reccepit_Issued(String mes) {
		ldriver.findElement(Receipt_Issue).sendKeys(mes);
	}
	
	public void enter_NoteIssue(String mes) {
		ldriver.findElement(Note_Issue).sendKeys(mes);
	}
	public void enter_NoteNotIssue(String mes) {
		ldriver.findElement(not_Issue).sendKeys(mes);
	}
	
	public void clickonsubmitbutton() {
		ldriver.findElement(SubmitButton).click();
	}
	public void click_onsubmitbuttonpopUp() {
		ldriver.findElement(submitbuttonpopup).click();
	}
	public void click_on_ok() {
		ldriver.findElement(okbuttob).click();
	}

	

}
