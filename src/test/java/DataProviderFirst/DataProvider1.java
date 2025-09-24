package DataProviderFirst;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import org.ecommerce.AndroidBaseTest;
import org.openqa.selenium.By;
import org.rsa.PageObjectModel.CartPage;
import org.rsa.PageObjectModel.FormPage;
import org.rsa.PageObjectModel.ProductCataloguePage;
import org.stc.utils.AndroidActions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 extends AndroidBaseTest{

	@Test(dataProvider="getData")
	public void homePage(HashMap<String, String> input) throws MalformedURLException, InterruptedException, URISyntaxException {

			FormPage page  = new FormPage(driver);
			page.setLetsShop();
			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
			Assert.assertEquals(toastMessage, "Please enter your name");
    		page.setNameField(input.get("name"));
    		page.setGender(input.get("gender"));
    		page.setCountrySelection(input.get("country"));
		    page.setLetsShop();
//Choose the product from the list
	} 
			@Test()
		    public void findProduct() {
		        AndroidActions actions = new AndroidActions();
			    actions.scrollText("Air Jordan 9 Retro",driver);
		        actions.scrollText("Jordan 6 Rings",driver);
		}
		    
			@Test()
		 public void addProduct() {
			 ProductCataloguePage catalogue = new ProductCataloguePage(driver);
			  catalogue.setProductCount();
		      catalogue.setAddCart(0);
			  catalogue.setAddCart(0);
			  catalogue.setCartButton();
		 }
			@Test()
			public void TC() {
			    CartPage cart = new CartPage(driver);
			    cart.setAcceptTC();
			}
			@Test()
			public void proceed() throws InterruptedException {
			    CartPage cart = new CartPage(driver);
			    	cart.setClassName();
				    cart.setProceed();
				   
			}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//ecommerce//testdata//eCommerce.json");
	    return new Object[][] { {data.get(0)}, {data.get(1)} };                            

	}
	
}