package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CamsOasys.Cams_Oasys.BaseClass;

public class LoginPage extends BaseClass{
	public static WebDriver ldriver;
	public WebDriverWait wait;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	private By login_button=By.xpath("//*[@id='btnseed1']");
	private By username=By.xpath("//*[text()='PACS Username']/following-sibling::input[@id='username']");
	private By password=By.id("userpassword");
	private By username_arcs=By.xpath("//*[text()='ARCS/DRCS Username']/following-sibling::input[@id='username']");
	private By password_arcs=By.xpath("//*[text()='ARCS/DRCS Username']/following-sibling::input[@id='username']/parent::div/following::div/input[@name='Password']");
	
	private By signin_button=By.xpath("(//button[@type='submit'])[1]");
	private By signin_button_Drcs=By.xpath("//form[@class='arcs-form']/div[4]/button[text()='Login']");
	private By pacs_name_dashboard=By.xpath("//button[@id='page-header-user-dropdown']/span");
	private By pacs_profile_dropdown=By.xpath("//button[@id='page-header-user-dropdown']");
	private By Signout_button_profile=By.xpath("//span[text()='Sign out']");
	
	private By arcsanddrcslogin=By.xpath("//button[text()='ARCS / DRCS']");
	private By registor=By.xpath("//button[text()='Registrar']");
	
	
	
	public void click_On_Login_Dashboard() {
		wait=new WebDriverWait(ldriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login_button));
		ldriver.findElement(login_button).click();
		//ldriver.findElement(login_button).click();
	}
	
	public void enter_Username_Field(String user) {
		ldriver.findElement(username).sendKeys(user.trim());
	}
	
	public void enter_Password_Field(String pass) {
		ldriver.findElement(password).sendKeys(pass.trim());
	}
	public void click_On_Signin_Button() {
		ldriver.findElement(signin_button).click();
	}
	
	public String text_Value_Of_Profile() {
		String text=ldriver.findElement(pacs_name_dashboard).getText();
		return text;
	}
	
	public void click_On_Profile_Button() {
		ldriver.findElement(pacs_profile_dropdown).click();
	}
	public void click_On_Sign_Out() {
		ldriver.findElement(Signout_button_profile).click();
	}
	
	public void click_On_Arcs_And_Drcs() {
		ldriver.findElement(arcsanddrcslogin).click();
	}
	public void click_On_Registor() {
		ldriver.findElement(registor).click();
	}
	public void enter_UserNameForArcsandDrcs(String mes) {
		ldriver.findElement(username_arcs).isDisplayed();
		ldriver.findElement(username_arcs).sendKeys(mes.trim());
		
	}
	public void enter_PasswordForArcsandDrcs(String mes) {
		ldriver.findElement(password_arcs).isDisplayed();
		ldriver.findElement(password_arcs).sendKeys(mes.trim());
	}
	
	public void click_On_Sign_In_Button_ArcsandDrcs() {
		ldriver.findElement(signin_button_Drcs).isDisplayed();
		ldriver.findElement(signin_button_Drcs).click();
	}

	
}
