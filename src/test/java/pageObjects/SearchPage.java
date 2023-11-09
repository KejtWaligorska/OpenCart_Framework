package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="iMac")
	WebElement iMac;
	
	//@FindBy(linkText=productName)
	//WebElement searchResult;
	
	public boolean isSearchResultExist()
	{
		try {
			return (iMac.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickIMac()
	{
		iMac.click();
	}
	
	//public void clickSearchResult(String productName)
	//{
	//	
	//}
}
