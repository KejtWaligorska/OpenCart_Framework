package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;

public class TC_004_SearchTest extends BaseClass{

	@Test
	void test_searchProduct()
	{
		String product = "iMac";
		
		try
		{
			logger.info("*** Starting TC_004_SearchTest ***");
			HomePage hp = new HomePage(driver);
			logger.info("*** Providing product name ***");
			hp.search(product);
			
			SearchPage sp = new SearchPage(driver);
			boolean searchResult = sp.isSearchResultExist();
			Assert.assertEquals(searchResult, true, "Invalid product data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** TC_004_SearchTest ***");
	}
}
