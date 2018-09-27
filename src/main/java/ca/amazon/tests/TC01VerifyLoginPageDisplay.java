package ca.amazon.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ca.amazon.base.Base;
import ca.amazon.pageObjects.AddToCart;
import ca.amazon.pageObjects.Home;

public class TC01VerifyLoginPageDisplay extends Base{
	
	Home home;
	
	@Test
	public void verifyLogin(){
				
		home=PageFactory.initElements(driver, Home.class);
		//Mouse hover over Shop By Department
		home.selectShopByDept();
		
		//Mouse hover over Kindle option
		home.selectKindle();
	
		
		
		//Clicking on PaperWhite option
		home.clickPaperWhite();
	
			
		
		AddToCart addtocart=PageFactory.initElements(driver, AddToCart.class);
		//Increasing the quantity to 2
		addtocart.increaseQuantity();
	
				
		//Clicking on Add to Cart button
		addtocart.clickAddtoCart();
	
		
		//Clicking on Add to Order button
		addtocart.clickAddtoOrder();
		
		
		//Clicking on Proceed to Checkout button
		addtocart.clickProceedtoCheckout();
			
	
		//Verifying email and password fields are displayed
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Amazon Sign In";
		try{
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		Reporter.log("Login Page is displayed", 1, true);
		extenttest.log(LogStatus.PASS, "Login Page is displayed");
		}catch(Exception e){
			extenttest.log(LogStatus.FAIL, "Login Page is displayed");
		}
	}
		
}
