package ca.amazon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import ca.amazon.base.Base;

public class AddToCart extends Base {
	
	public Actions act;
		
	@FindBy(how=How.ID, using="quantity")
	WebElement quantity;

	@FindBy(how=How.ID, using="add-to-cart-button")
	WebElement AddtoCart;
	
	@FindBy(how=How.ID, using="intl_pop_addToOrder")
	WebElement AddtoOrder;
	
	@FindBy(how=How.XPATH, using="//a[contains(@class,'hucSprite s_checkout hlb-checkout-button')]")
	WebElement ProceedtoCheckout;
	
	/*public AddToCart(WebDriver driver){
		Base.driver=driver;
	}*/
	
	public void increaseQuantity() {
		try{
		Select se=new Select(quantity);
		se.selectByValue("2");
		extenttest.log(LogStatus.PASS, "Increased the qantity of PaperWhite to 2");
		}catch(Exception e){
			extenttest.log(LogStatus.FAIL, "Increased the qantity of PaperWhite to 2");
		}
	}
	
	public void clickAddtoCart() {
		try{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(AddtoCart));
		AddtoCart.click();
		extenttest.log(LogStatus.PASS, " Added PaperWhite into cart");
		}catch(Exception e){
			extenttest.log(LogStatus.FAIL, " Added PaperWhite into cart");
		}
	}
	
	public void clickAddtoOrder() {
		try{
		String windowId=driver.getWindowHandle();
		driver.switchTo().window(windowId);
		AddtoOrder.click();
		extenttest.log(LogStatus.PASS, " Clicked on Add to Order ");
		}catch(Exception e){
			extenttest.log(LogStatus.PASS, " Clicked on Add to Order");
		}
	}
	
	public void clickProceedtoCheckout() {
		try{
		ProceedtoCheckout.click();
		extenttest.log(LogStatus.PASS, " Clicked on Proceed to Checkout button");
		}catch(Exception e){
		extenttest.log(LogStatus.FAIL, " Clicked on Proceed to Checkout button");
		}
	}
}
