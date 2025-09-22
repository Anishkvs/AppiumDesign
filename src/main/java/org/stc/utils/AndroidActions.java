package org.stc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.Files;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{

	//;

//	public AndroidActions(AndroidDriver driver) {
	//	super(driver);
//		this.driver = driver;
//	}

	public void longPress(WebElement ele, AndroidDriver driver) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 3000));

	}

	public void scrollText(String text, AndroidDriver driver) {
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+text+"\"))"));
	}

	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeContains((ele),"text" , "Cart"));
	}
	public void waitForElementToAppearWithText(WebElement ele, AppiumDriver driver, String expectedText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait.until(ExpectedConditions.attributeContains(ele, "text", expectedText));
	}
	public void waitForElementToClickable(WebElement ele, AppiumDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.elementToBeClickable(ele));
      }
	

	public void scrollToActions(AndroidDriver driver) {
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 75.0
		));
		}while(canScrollMore);
	}
	
	public void scrollChat(AndroidDriver driver) {
		String text = "your_text_to_scroll_to";
		String uiSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))";
	}
	
	public void scrollNew(AndroidDriver driver) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Smartphones\"));"));

	}
	
	public void swipeDown(AndroidDriver driver) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 1
			));
	}
	public void swipeActionNew(String directions, AndroidDriver driver)
	{
		Dimension screenSize = driver.manage().window().getSize();
		int height = screenSize.getHeight();
		int width = screenSize.getWidth();
		boolean scroll;
		do {
		   scroll = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		         "left", 0, "top", 100, "width", width, "height", height / 2,
		         "direction", directions,
		         "percent", 0.75
		   ));
		} while (scroll);
	}
	
	public String getScreenshotPathAndroid(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
				
	}
	
	public void swipeActionNewChat(String directions, By locator, AndroidDriver driver) {
	    Dimension screenSize = driver.manage().window().getSize();
	    int height = screenSize.getHeight();
	    int width = screenSize.getWidth();
	    boolean scroll = true;

	    do {
	        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	                "left", 0, "top", 100, "width", width, "height", height / 2,
	                "direction", directions,
	                "percent", 0.75
	        ));

	        WebElement ele = driver.findElement(locator);
	        if (ele.isDisplayed()) {
	            scroll = false; 
	        }

	    } while (scroll);
	}
	
	public void scrollActionTwo(String directions, AndroidDriver driver) {
		Dimension screenSize = driver.manage().window().getSize();
		int height = screenSize.getHeight();
		int width = screenSize.getWidth();

		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		        "left", 0, "top", 100, "width", width, "height", height / 2,
		        "direction", directions,
		        "percent", 1
		));

	}
	
	public String getPropertyValue(String propertyFileName, String propertyKey) throws IOException {

		String propertyValue = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\" + propertyFileName + ".properties");
			prop.load(fis);
			propertyValue = prop.getProperty(propertyKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
	
	}
	public ArrayList<String> getData(String testcaseName) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\StcTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;

					}

					k++;
				}
				System.out.println(coloumn);

				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {

								a.add(c.getStringCellValue());
							} else {

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}

				}

			}
		}
		return a;

	}

}
