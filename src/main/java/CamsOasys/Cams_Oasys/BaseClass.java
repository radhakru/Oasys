package CamsOasys.Cams_Oasys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class BaseClass {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		
		if(driver==null) {
			driver=new ChromeDriver();
		}
		return driver;
	}
}
