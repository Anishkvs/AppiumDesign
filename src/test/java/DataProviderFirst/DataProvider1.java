package DataProviderFirst;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import org.ecommerce.AndroidBaseTest;
import org.openqa.selenium.By;
import org.rsa.PageObjectModel.FormPage;
import org.rsa.PageObjectModel.ProductCataloguePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 extends AndroidBaseTest{

	@Test(dataProvider="getData")
	public void POM_App(HashMap<String, String> input) throws MalformedURLException, InterruptedException, URISyntaxException {

			FormPage page  = new FormPage(driver);
			page.setLetsShop();
			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
			Assert.assertEquals(toastMessage, "Please enter your name");
    		page.setNameField(input.get("name"));
    		page.setGender(input.get("gender"));
    		page.setCountrySelection(input.get("country"));
		    page.setLetsShop();
//Choose the product from the list
		    ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		    catalogue.setProductCount();
		    catalogue.setAddCart(0);
		    catalogue.setAddCart(0);
		    catalogue.setCartButton();
		 
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//ecommerce//testdata");
	    return new Object[][] { {data.get(0)}, {data.get(1)} };

	}
	
}