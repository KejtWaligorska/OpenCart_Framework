package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space(text()) = 'My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	@FindBy(xpath="//div[@id='search']//input[@name='search']")
	WebElement txtSearchField;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']")
	WebElement btnSearch;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement btnCart;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void login()
	{
		lnkMyAccount.click();
		lnkLogin.click();
	}
	
	public void search(String product)
	{
		txtSearchField.click();
		txtSearchField.sendKeys(product);
		btnSearch.click();
	}
	
	public void clickCart()
	{
		btnCart.click();
	}
	
}
