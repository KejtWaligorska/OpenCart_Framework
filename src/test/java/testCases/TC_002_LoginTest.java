package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity", "Master"})
	public void test_login()
	{
		try
		{
		logger.info("*** Starting TC_002_LoginTest ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*** Clicked on My Account ***");
		hp.clickLogin();
		logger.info("*** Clicked on Login link ***");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("*** Providing login details ***");
		lp.enterEmail(rb.getString("email"));
		lp.enterPassword(rb.getString("password"));
		logger.info("*** Clicked on Login button ***");
		lp.clickLogin();
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "Invalid login data");	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
	}
}
