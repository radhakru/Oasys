package CamsOasys.Cams_Marketing_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CamsOasys.Cams_Marketing_Object_page.ListOfSeedApproveAndRejectDrcs;
import CamsOasys.Cams_Marketing_Object_page.LoginPage;
import CamsOasys.Cams_Marketing_Utility.ListOfSeedExcelRead;
import CamsOasys.Cams_Marketing_Utility.ReadCamsMarketingExcel;
import CamsOasys.Cams_Oasys.BaseClass;

public class VerifyListOfSeedApproveAndRejectDRCS extends BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public WebDriverWait driverwait;
	public ListOfSeedApproveAndRejectDrcs loaar;
	public String value = null;
	public ListOfSeedExcelRead readexcel;
	public int count=0;
	@BeforeTest
	public void setUp() {
		driver = getDriver();
		lp = new LoginPage(driver);
		loaar = new ListOfSeedApproveAndRejectDrcs(driver);
		driverwait = new WebDriverWait(driver, 120);
		readexcel=new ListOfSeedExcelRead();

	}

	@Test(priority = 1)
	public void click_On_Login() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://cams.demoapplication.in/");
		lp.click_On_Login_Dashboard();
		Thread.sleep(2000);
		lp.click_On_Arcs_And_Drcs();
		Thread.sleep(2000);
		lp.enter_UserNameForArcsandDrcs("payal@oasys.com");//previous username-payal1@gmail.com
		lp.enter_PasswordForArcsandDrcs("Oasys@1234");
		lp.click_On_Sign_In_Button_ArcsandDrcs();

	}

	@Test(dataProvider = "test", dataProviderClass = ListOfSeedExcelRead.class, priority = 2)
	public void check_List_Of_Seed(String name, String emailId, String password, String districtname, String NameOfPacs,
			String indent_placed_To_Ossc, String Lifted, String Achievement, String LastWeek, String Cashsale,
			String BComplement, String total_value, String balance_With_Pacs_Or_LAMPS, String Achievement_To_Indent) {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Input Marketing']")));
		driver.findElement(By.xpath("//*[text()='Input Marketing']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='List Of Seed']")));
		driver.findElement(By.xpath("//*[text()='List Of Seed']")).click();

		System.out.println("Status value= " + loaar.get_Status_Value());
		try {
			if (loaar.get_Status_Value().equalsIgnoreCase("Pending")) {
				loaar.click_On_look_Button();
				Assert.assertEquals(indent_placed_To_Ossc, loaar.get_Located_Placed_To_Ossc());
				Assert.assertEquals(Lifted, loaar.get_Lifted());
				Assert.assertEquals(LastWeek, loaar.get_LastWeek());
				Assert.assertEquals(Cashsale, loaar.get_Cashsale());
				Assert.assertEquals(BComplement, loaar.get_Bcomponent());
				Assert.assertEquals(total_value, loaar.get_Total());
				Assert.assertEquals(balance_With_Pacs_Or_LAMPS, loaar.get_Balance_With_Pacs_Lampcs());
				Assert.assertEquals(Achievement_To_Indent, loaar.get_Achievement_To_Indent());
				Thread.sleep(2000);
				loaar.enter_Reason("Reject.....");
				Thread.sleep(2000);
				loaar.click_On_Approve_Button();
				//loaar.click_On_Reject_Button();
				Thread.sleep(2000);
				count++;
				System.out.println("Status...  "+loaar.get_Status_Value());
				
				readexcel.update_cell_value(count,loaar.get_Status_Value());
				
				Thread.sleep(2000);

			}

			else {
				value = " not pending..";
				System.out.println("last row status "+value);
				
			}

		} catch (Throwable e) {
			e.getMessage();
		}
		
		if (value != null || value==null) {
			loaar.click_On_look_Button();
			System.out.println("loctaed value= " + loaar.get_Located_Placed_To_Ossc());
			System.out.println("lifted value= " + loaar.get_Lifted());
			System.out.println("Achievement = " + loaar.get_Achievement());
			System.out.println("Lastweek=" + loaar.get_LastWeek());
			System.out.println("Cash Sale=" + loaar.get_Cashsale());
			System.out.println("b componenet" + loaar.get_Bcomponent());
			System.out.println("Total= " + loaar.get_Total());
			System.out.println("balance with pacs and lampcs " + loaar.get_Balance_With_Pacs_Lampcs());
			System.out.println("Achievement to indent " + loaar.get_Achievement_To_Indent());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.getMessage();
			}
			loaar.click_On_Back_Button();
		}

	}

//	@AfterTest
//	public void tearDown() {
//		driver.close();
//	}

}
