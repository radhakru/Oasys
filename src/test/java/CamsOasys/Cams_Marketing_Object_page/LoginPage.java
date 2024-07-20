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
	private By signin_button=By.xpath("(//button[@type='submit'])[1]");
	private By pacs_name_dashboard=By.xpath("//button[@id='page-header-user-dropdown']/span");
	private By pacs_profile_dropdown=By.xpath("//button[@id='page-header-user-dropdown']");
	private By Signout_button_profile=By.xpath("//span[text()='Sign out']");
	
	
	
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

	
}
