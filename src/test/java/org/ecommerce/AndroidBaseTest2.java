package org.ecommerce;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.stc.utils.AndroidActions;
import org.stc.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest2 extends AppiumUtils{
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	AndroidActions actions;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
	
		service = new AppiumServiceBuilder()
			    .withAppiumJS(new File("C:\\Users\\Anishkumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			    .withIPAddress("127.0.0.1")
			    .usingPort(4723)
			    .build();	
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AnishEmulator");
//  WebDriverManager to manage chromedriver
	 //   WebDriverManager.chromedriver().setup();
	  //  options.setChromedriverExecutable(WebDriverManager.chromedriver().getDownloadedDriverPath());
		options.setApp("C:\\Users\\Anishkumar\\eclipse-workspaceMobile\\RSA\\src\\test\\resources\\General-Store.apk");
	//	options.setAppPackage("com.androidsample.generalstore");
	//	options.setAppActivity("com.androidsample.generalstore.MainActivity");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void LongPressAction(WebElement ele) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId()
			));
		Thread.sleep(2000);
				
	}
	
	public void ScrollToText(String content) throws InterruptedException {
		//Scroll the Text		
		driver.findElement(AppiumBy.androidUIAutomator(
		        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + content + "\"));"
		    ));Thread.sleep(2000);
	}
	
	public void ScrollFewLine() {
		//Scroll few line		
		boolean canScrollFew = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
	}
	public void ScrollToEnd() {
		//Scroll to end of the page	
	  boolean canScrollMore;
			do
			{
				 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
			));
				} while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction, String percentage) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", percentage
        ));
	}
	
	public void DragDrop(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
        	    "elementId", ((RemoteWebElement) ele).getId(),
        	    "endX", 621,
        	    "endY", 626
        	));
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		 if (driver != null) {
	            driver.quit();
		 }
	}
}
