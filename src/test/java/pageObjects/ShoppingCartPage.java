package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr")
	List<WebElement> rows;
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr/td[2]")
	WebElement productName;
	
	public boolean checkIsProductDisplayed(String expectedProductName)
	{
		for(int i = 0; i < rows.size(); i++)
			{
				String actualProductName = productName.getText();
				if(actualProductName.equals(expectedProductName)) {
					return true;
				}
			}
		return false;
	}
}
