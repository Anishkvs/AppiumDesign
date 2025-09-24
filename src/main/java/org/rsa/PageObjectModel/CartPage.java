package org.rsa.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.stc.utils.AndroidActions;
import org.stc.utils.AppiumUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AppiumUtils{

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
    	//super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="android:id/button1")
    private WebElement CloseTC;
    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    private WebElement TCButton;
    @AndroidFindBy(className="android.widget.CheckBox")
    private WebElement CheckBox;
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    private WebElement Proceed;
   
    public void setAcceptTC() {
        AndroidActions actions = new AndroidActions();
 
    	WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
    	actions.longPress(ele, driver);
    	CloseTC.click();
    }
  
public void setClassName() {
	   CheckBox.click();
   }
   public void setProceed() throws InterruptedException {
	   Proceed.click();
	   Thread.sleep(5000);
   }
    
}