package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_005_AddingProductTest extends BaseClass{

	@Test
	void test_addingProductToCart()
	{
		String product = "iMac";
		
		try
		{
			logger.info("*** Starting TC_005_AddingProductTest ***");
			HomePage hp = new HomePage(driver);
			logger.info("*** Providing product name ***");
			hp.search(product);
			
			SearchPage sp = new SearchPage(driver);
			boolean searchResult = sp.isSearchResultExist();
			if(searchResult==true)
			{
				sp.clickIMac();
			}
			else 
			{
				Assert.fail();
			}
			
			ProductPage pp = new ProductPage(driver);
			logger.info("*** Clicked add to cart button ***");
			pp.clickAddToCart();
			logger.info("*** Validating expected message ***");
			String confmsg = pp.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Success: You have added " + product + " to your shopping cart!", "Not getting expected message");
			logger.info("*** Clicked shopping cart on confirmation message ***");
			pp.clickShoppingCart();
			
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			logger.info("*** Validating if product is displayed in the shopping cart ***");
			boolean productList = scp.checkIsProductDisplayed(product);
			Assert.assertEquals(productList, true, "Product is not in the shopping cart!");
		}

		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_005_AddingProductTest ***");
	}
}
