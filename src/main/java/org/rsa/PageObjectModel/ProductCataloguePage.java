package org.rsa.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.stc.utils.AndroidActions;
import org.stc.utils.AppiumUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCataloguePage extends AppiumUtils{

   	AndroidDriver driver;

    public ProductCataloguePage(AndroidDriver driver) {
   // 	super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addCart;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement CartButton;
    
    public void setAddCart(int index) {
    	addCart.get(index).click();
    }
    public void setCartButton() {
    	CartButton.click();
    }
    
    public void setProductCount() {
      //  AndroidActions actions = new AndroidActions();
   //     actions.scrollText("Air Jordan 9 Retro",driver);
    //    actions.scrollText("Jordan 6 Rings",driver);
       int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	    for (int i = 0; i < productCount; i++) {
		        String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName"))
		                                   .get(i)
		                                   .getText();

		        if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
		            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"))
		                  .get(i)
		                  .click();
		        }
		    }
    }
    
    
}