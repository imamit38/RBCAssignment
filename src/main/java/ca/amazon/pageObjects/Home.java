package ca.amazon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import ca.amazon.base.Base;

public class Home extends Base{
	//public WebDriver driver;
	public Actions action;
		
	@FindBy(how=How.ID, using="nav-link-shopall")
	WebElement ShopByDept;

	@FindBy(how=How.XPATH, using="//span[@aria-label='Kindle']")
	WebElement kindle;
	
	@FindBy(how=How.XPATH, using="//span[text()='Kindle Paperwhite']")
	WebElement paperWhite;
	
	/*public Home(WebDriver driver){
		Base.driver=driver;
	}*/
	
	//WebDriver driver=Base.driver;
	public void selectShopByDept() {
		try{
		action=new Actions(driver);
		action.moveToElement(ShopByDept).build().perform();
		extenttest.log(LogStatus.PASS, " Clicked on Shop By Department");
			}catch(Exception e){
				extenttest.log(LogStatus.FAIL, " Clicked on Shop By Department");
			}
	}
	
	public void selectKindle() {
		try{
		action=new Actions(driver);
		action.moveToElement(kindle).build().perform();
		extenttest.log(LogStatus.PASS, " Selected Kindle option");
		}catch(Exception e){
			extenttest.log(LogStatus.FAIL, " Selected Kindle option");
		}
	}
		
	public void clickPaperWhite() {
		try{
		paperWhite.click();
		extenttest.log(LogStatus.PASS, " Clicked on Kindle PaperWhite option");
		}catch(Exception e){
			extenttest.log(LogStatus.FAIL, " Clicked on Kindle PaperWhite option");
		}
	}
}
