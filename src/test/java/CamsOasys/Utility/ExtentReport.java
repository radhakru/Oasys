package CamsOasys.Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CamsOasys.Cams_Marketing_Object_page.LoginPage;

public class ExtentReport implements ITestListener {
	ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
	ExtentReports extent = new ExtentReports();

	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started method name on test start ="+result.getName());
//		extent.attachReporter(spark);
//		extent.createTest(result.getName());
//		extent.flush();
//		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test result status="+result.getStatus());
		System.out.println("Test started method name on test success="+result.getTestClass());
		extent.attachReporter(spark);
		extent.createTest(result.getName()).log(Status.PASS, result.getName());
		extent.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		System.out.println("Test result status on failure="+result.getStatus());
		System.out.println("Test started method name ontestfailure="+result.getName());
		extent.attachReporter(spark);
		extent.createTest(result.getName()).log(Status.FAIL, result.getName());
		extent.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		System.out.println("Test started method name ontestskipped="+result.getName());
//		extent.attachReporter(spark);
//		extent.createTest(result.getName()).log(Status.SKIP, result.getName());
//		extent.flush();
//		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println("Test started method name ontestfailurewithinsuccess ="+result.getName());
//		extent.attachReporter(spark);
//		extent.createTest(result.getName());
//		extent.flush();
//		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test started method name on testfailedwithouttimeout ="+result.getName());
//		extent.attachReporter(spark);
//		extent.createTest(result.getName());
//		extent.flush();
//		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started method name onstart ="+context.getName());
//		ExtentHtmlReporter spark = new ExtentHtmlReporter("target/spark.html");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(spark);
//		extent.flush();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Test started method name of onfinish ="+context.getName());
		ExtentHtmlReporter spark = new ExtentHtmlReporter("target/spark.html");
	}

//	public void addreport() throws IOException {
//	// directory where output is to be printed
//	ExtentHtmlReporter spark = new ExtentHtmlReporter("target/spark.html");
//	ExtentReports extent = new ExtentReports();
//	extent.attachReporter(spark);
//	extent.createTest("Making report");
//	
////	spark.loadXMLConfig(System.getProperty("user.dir")+"//extent-config.xml");
////	ExtentReports extent = new ExtentReports();
////	extent.attachReporter(spark);
//	
//	extent.flush();
//	}

}
