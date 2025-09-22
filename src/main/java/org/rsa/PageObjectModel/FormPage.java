package org.rsa.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.stc.utils.AndroidActions;
import org.stc.utils.AppiumUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AppiumUtils{

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
    //	super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("test");
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    // driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;
    
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='male']")
    private WebElement maleOption;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement LetsShop;
   
    @AndroidFindBy(id="android:id/text1")
    private WebElement CountrySelection;
    
    public void setNameField(String name) {
    	nameField.sendKeys(name);
    	driver.hideKeyboard();;
    }
    
    public void setGender(String gender) 
    {
    	if(gender.contains("female"))
    		femaleOption.click();
    	else
    		maleOption.click();
    }
    public void setLetsShop() {
    	LetsShop.click();
    }
    
    public void setCountrySelection(String CountryName) {
    	CountrySelection.click();
    //	scrollText(CountryName);
    	   driver.findElement(AppiumBy.androidUIAutomator(
    		        "new UiScrollable(new UiSelector().scrollable(true))" +
    		        ".scrollIntoView(new UiSelector().text(\"" + CountryName + "\"));"
    		    ));
    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
	   
    }
    
}