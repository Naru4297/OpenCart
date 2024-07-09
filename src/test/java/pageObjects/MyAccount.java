package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends basePage{
	
	//constructor 
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	//locators 
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Msgheading;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement lnklogout;
	
	public boolean isMyAccountExist ()
	{
		try
		{
		return (Msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
}
