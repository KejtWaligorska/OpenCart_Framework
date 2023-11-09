package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddToCart;
	
	@FindBy(css = "div#product-product > .alert.alert-dismissible.alert-success")
	WebElement msgConfirmation;
	
	@FindBy(linkText="shopping cart")
	WebElement lnkShoppingCart;

	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	public String getConfirmationMsg() {
		try {
			String conf = msgConfirmation.getText();
			return (conf.substring(0, conf.indexOf("!")+1));
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickShoppingCart()
	{
		lnkShoppingCart.click();
	}
}
