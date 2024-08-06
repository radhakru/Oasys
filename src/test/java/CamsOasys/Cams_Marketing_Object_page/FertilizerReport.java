package CamsOasys.Cams_Marketing_Object_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FertilizerReport {
	public WebDriver ldriver;
	public Select select;
	public int total_Page_Value = 0;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public FertilizerReport(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	private By districtValue = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[2]");
	private By nameOfPacsName = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[3]");
	private By Target = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[4]");
	private By Quanti_Of_Fortilizer_pos = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[5]");
	private By LastWeek = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[6]");
	private By Cashsale = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[7]");
	private By BComponent = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[8]");
	private By TotalSale = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[9]");
	private By Out_Of_Which_Urea = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[10]");
	private By Balance = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[11]");
	private By Achievement = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[12]");
	private By Sale = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[13]");
	private By Balance_Urea = By.xpath("(//table[@id='fertilizer_report']/tbody/tr)[1]/td[14]");
//	private By pagination_Value = By.xpath("//li[@id='fertilizer_report_next']/a");
//	private By next_button = By.xpath("//*[@id='fertilizer_report_next']/a");
//	private By last_Page = By.xpath("//ul[@class='pagination']/li[last()-1]");
	
	private By profilel_page = By.xpath("//button[@id='page-header-user-dropdown']");
	private By signout = By.xpath("//button[@id='page-header-user-dropdown']/following-sibling::div/a[3]");

	public WebDriverWait createWaitInstance() {
		wait = new WebDriverWait(ldriver, 120);
		return wait;
	}

	public String get_districtValue() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(districtValue));
		String mes = ldriver.findElement(districtValue).getText();
		return mes;

	}

	public String get_Pacsname() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfPacsName));
		String mes = ldriver.findElement(nameOfPacsName).getText();
		return mes;
	}

	public String get_Target_Value() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Target));
		String mes = ldriver.findElement(Target).getText();
		return mes;

	}

	public String get_Qnt_Of_Fert_Prepositioned() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Quanti_Of_Fortilizer_pos));
		String mes = ldriver.findElement(Quanti_Of_Fortilizer_pos).getText();
		return mes;
	}

	public String get_Last_Week() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastWeek));
		String mes = ldriver.findElement(LastWeek).getText();
		return mes;

	}

	public String get_CashSale() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Cashsale));
		String mes = ldriver.findElement(Cashsale).getText();
		return mes;
	}

	public String get_B_Component() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(BComponent));
		String mes = ldriver.findElement(BComponent).getText();
		return mes;
	}

	public String get_Total_Sale() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(TotalSale));
		String mes = ldriver.findElement(TotalSale).getText();
		return mes;
	}

	public String get_Out_OfWhich_Urea() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Out_Of_Which_Urea));
		String mes = ldriver.findElement(Out_Of_Which_Urea).getText();
		return mes;
	}

	public String get_Balance() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Balance));
		String mes = ldriver.findElement(Balance).getText();
		return mes;
	}

	public String get_Achievement() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Achievement));
		String mes = ldriver.findElement(Achievement).getText();
		return mes;
	}

	public String get_Sale() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Sale));
		String mes = ldriver.findElement(Sale).getText();
		return mes;
	}

	public String get_Balanace_Urea() {
		wait = createWaitInstance();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_Urea));
		String mes = ldriver.findElement(Balance_Urea).getText();
		return mes;
	}
	public void click_On_Signout() {
		ldriver.findElement(profilel_page).click();
		ldriver.findElement(signout).click();

	}

	/*
	 * public void click_On_Next_Button() {
	 * ldriver.findElement(By.xpath("//div[@id='listNonPaddyReport_filter']/label"))
	 * .click(); Actions act = new Actions(ldriver);
	 * act.sendKeys(Keys.PAGE_DOWN).build().perform();
	 * System.out.println(ldriver.findElement(last_Page).isDisplayed());
	 * ldriver.findElement(last_Page).click(); }
	 */
}
