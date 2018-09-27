package ca.amazon.base;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestListeners implements ISuiteListener, ITestListener , IRetryAnalyzer {
	protected static WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest extenttest;
	
	int counter = 0;
	int retryLimit = 3; 	
	Utility util=new Utility();
	
	public void onFinish(ITestContext arg0) {
		//Reporter.log("Reporter Test Finish" + arg0.getName(), true);
		System.out.println("Finish Test level");
  	}

	public void onStart(ITestContext arg0) {
		
		Reporter.log("Reporter Test Start " + arg0.getName(), true);
		extenttest = extent.startTest(arg0.getName());
			
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		//Reporter.log("Reporter Test Failed success" + arg0.getName(), true);
		//extenttest.log(LogStatus.FAIL, "Test failure reported");
		extent.flush();
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		Reporter.log("Reporter Test Failure" + arg0.getName(), true);
		util.captureScreenshot(Base.driver, arg0.getName());
		//extenttest.log(LogStatus.FAIL, "Test failure reported and name of test is: "+ arg0.getName());
		extent.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {
	
		Reporter.log("Test Skipped" + arg0.getName(), true);
		//extenttest.log(LogStatus.INFO, "Skipped test case is: " +arg0.getName());
		extent.flush();
	}

	public void onTestStart(ITestResult arg0) {
		
		Reporter.log("Test Start" + arg0.getName(), true);
		//ExtentTest extenttest = extent.startTest(arg0.getName());
		System.out.println("Start on Test Level");
	}

	public void onTestSuccess(ITestResult arg0) {
		
		Reporter.log("Reporter logs Test Success" + arg0.getName(), true);
		//extenttest.log(LogStatus.PASS, "Test passed reported and name of test is: "+ arg0.getName());
		//extent.flush();
		
	}

	public void onFinish(ISuite arg0) {
	
		//Reporter.log("Reporter Testsuite Finish" + arg0.getName(), true);
		extent.flush();
		System.out.println("Suite End");
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		if (extent==null){
		   extent = new ExtentReports(".\\ExtentReports\\ExtentReportResults.html", true);
	       System.out.println("Suite Start");
		}
	    }

	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}
}
	