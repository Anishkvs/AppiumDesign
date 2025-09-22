package DataProviderFirst;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.ecommerce.AndroidBaseTest;
import org.openqa.selenium.By;
import org.rsa.PageObjectModel.FormPage;
import org.rsa.PageObjectModel.ProductCataloguePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 extends AndroidBaseTest{

	@Test(dataProvider="getData")
	public void POM_App(String name, String gender, String country) throws MalformedURLException, InterruptedException, URISyntaxException {

			FormPage page  = new FormPage(driver);
			page.setLetsShop();
			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
			Assert.assertEquals(toastMessage, "Please enter your name");
    		page.setNameField(name);
			page.setGender(gender);
		    page.setCountrySelection(country);
		    page.setLetsShop();
//Choose the product from the list
		    ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		    catalogue.setProductCount();
		    catalogue.setAddCart(0);
		    catalogue.setAddCart(0);
		    catalogue.setCartButton();
		 
	}
	@DataProvider
	public Object[][] getData()
	{
	    return new Object[][] { {"Test Message", "female", "Argentina"}  };
	}
	
}