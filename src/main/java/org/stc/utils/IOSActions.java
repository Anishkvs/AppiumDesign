package org.stc.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{
	
		
	public void longPressAction(WebElement ele, IOSDriver driver)
	{
		Map <String,Object>params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
			
		driver.executeScript("mobile:touchAndHold", params);
	}

	public void scrollToEndAction(IOSDriver driver)
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	public void scrollToWebElement(WebElement ele, IOSDriver driver)
	{
		
		Map<String,Object> params = new HashMap<>();
		params.put("direction", "down");		
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
	}
	
	
	public void swipeAction(WebElement ele,String direction, IOSDriver driver)
	{
		Map<String,Object> params1 = new HashMap<String,Object> ();
		params1.put("direction","left");
		driver.executeScript("mobile:swipe", params1);
	}

}
