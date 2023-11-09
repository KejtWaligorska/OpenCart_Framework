package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String expected)
	{
		logger.info("*** Starting TC_003_LoginDDT ***");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*** Clicked on My Account ***");
		hp.clickLogin();
		logger.info("*** Clicked on Login link ***");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("*** Providing login details ***");
		lp.enterEmail(email);
		lp.enterPassword(password);
		logger.info("*** Clicked on Login button ***");
		lp.clickLogin();
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.isMyAccountPageExists();
		
		if(expected.equals("Valid"))
		{
			if(targetpage==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			} 
			else
			{
				Assert.fail();
			}
		} else if(expected.equals("Invalid"))
		{
			if(targetpage==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			} 
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_003_LoginDDT ***");
	}
}
