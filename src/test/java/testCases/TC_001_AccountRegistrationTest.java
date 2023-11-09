package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression", "Master"})
	void test_account_Registration()
	{
		logger.debug("application logs...");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		hp.clickRegister();
		logger.info("Clicked on register link");

		logger.info("Providing customer data");
		arp.setFirstName("Tester");
		arp.setLastName("Testowy");
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephone("555-444-888");
		String password = randomAlphaNumber();
		arp.setPassword(password);
		arp.setConfrimPassword(password);
		arp.selectPolicyCheckbox();
		arp.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg = arp.getConfirmationMsg();
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Not getting expected message");
		}
		
		catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}

		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
}
