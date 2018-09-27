package ca.amazon.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
		
	public void captureScreenshot(WebDriver driver, String screenshotName) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			FileUtils.copyFile(src, new File(".//Screenshots//"+screenshotName+".png"));
			
		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshot: "+e.getMessage());
			
		}
	}

}
