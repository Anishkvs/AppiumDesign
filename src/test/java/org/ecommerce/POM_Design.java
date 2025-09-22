package org.ecommerce;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rsa.PageObjectModel.CartPage;
import org.rsa.PageObjectModel.FormPage;
import org.rsa.PageObjectModel.ProductCataloguePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class POM_Design extends AndroidBaseTest{

	@Test
	public void POM_App() throws MalformedURLException, InterruptedException, URISyntaxException {

			FormPage page  = new FormPage(driver);
		
			
			page.setLetsShop();
			
    	 //   driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
			Assert.assertEquals(toastMessage, "Please enter your name");

		 //   driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test");
			page.setNameField("test");
			
		 //   driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
			page.setGender("female");
			
		    page.setCountrySelection("Armenia");
		  //  driver.findElement(AppiumBy.id("android:id/text1")).click();
		   // ScrollToText("Armenia");
		   // driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Armenia']")).click();
		    
		 //   driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		    page.setLetsShop();
//Choose the product from the list
		  //  ScrollToText("Air Jordan 9 Retro");
		   // ScrollToText("Jordan 6 Rings");
		    ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		    catalogue.setProductCount();
		    catalogue.setAddCart(0);
		    catalogue.setAddCart(0);
		    catalogue.setCartButton();
		 
		    
		  //  driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		    Thread.sleep(5000);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		    
		    String lastTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Jordan 6 Rings']")).getText();
		    Assert.assertEquals(lastTitle, "Jordan 6 Rings");
		    
//Long Press
		    CartPage cart = new CartPage(driver);
		    cart.setAcceptTC();
		  //  WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
		   // LongPressAction(ele);
		   // driver.findElement(AppiumBy.id("android:id/button1")).click();
		    cart.setClassName();
		    // driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		    cart.setProceed();
		    //  driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		    
		    
//Hybrid App
		    Set<String> contexts = driver.getContextHandles();
		    for(String contextName : contexts)
		    {
		        System.out.println(contextName);
		    }

		    driver.context("WEBVIEW_com.androidsample.generalstore");
		    driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    driver.context("NATIVE_APP");
	}
}