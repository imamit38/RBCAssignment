package ca.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.LogStatus;


public class Base extends TestListeners {
	
	public FileInputStream fis;
	public Properties prop;
	protected static WebDriver driver;

				
	//Configuring the property file and launching the browser
	@BeforeTest
	@Parameters("browser")
	public void startBrowser(String browserName){		
		
		try{
		PropertyConfigurator.configure("Log4j.properties");
		File file=new File("./src/main/java/ca/amazon/resources/config.properties");
		fis = new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromePath"));
			driver=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxPath"));
			driver=new FirefoxDriver();
			
		}else {
			
			System.setProperty("webdriver.ie.driver",prop.getProperty("iePath"));
			driver=new InternetExplorerDriver();
		}
		
		Reporter.log(browserName+" broswer Launched successfully", true);
		extenttest.log(LogStatus.INFO, browserName+" is launched");
				
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		Reporter.log(prop.getProperty("url")+" URL is accessed succefully", true);
	//	extenttest.log(LogStatus.PASS, prop.getProperty("url")+" URL is accessed succefully");
		
		}catch(Exception e) {
		System.out.println("Exception while launching the browser: "+e.getMessage());
		}
	}
	
	//Closing WebDriver instance
	@AfterTest
	public void closeWebDriver() {
		
		driver.close();
		Reporter.log("Application is closed",1, true);
		extenttest.log(LogStatus.INFO, "Application is closed");
	}
}
