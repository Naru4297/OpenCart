package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends basePage {
	
	//Constructor
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators 
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_FistName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_LastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_Telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_ConfirmPassword;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_Policy;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txt_FistName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_LastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setTelephone(String tphone)
	{
		txt_Telephone.sendKeys(tphone);
	}
	
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txt_ConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacy()
	{
		chk_Policy.click();
	}
	
	public void clickContinue()
	{
		//s1
		btn_Continue.click();
		
		//s2
		//btn_Continue.submit();
		
		//s3
		//Actions act=new Actions(driver);
		//act.moveToElement(btn_Continue).click().perform();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	
	
	
}
