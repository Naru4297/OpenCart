package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {

	public WebDriver driver;

	
/*
	public void setup()
	{

		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	*/

	/*
	public void tearDown()
	{
		driver.quit();
	}
	*/

	@Test
	public void account_registration()
	{

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();

		hp.clickRegister();

		AccountRegistration ar=new AccountRegistration(driver);

		ar.setFirstName(randomstring().toUpperCase());
		ar.setLastName(randomstring().toUpperCase());
		ar.setEmail(randomstring()+"@gmail.com");
		ar.setTelephone(randomnumber());

		String password=randomaplhanumeric();

		ar.setPassword(password);
		ar.setConfirmPassword(password);

		ar.setPrivacy();
		ar.clickContinue();

		String confmsg=ar.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}


	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphanumeric(5);
		return generatedstring;
	}

	public String randomnumber()
	{
		String generatednumber= RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}


	public String randomaplhanumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphanumeric(4);
		String generatednumber= RandomStringUtils.randomNumeric(4);
		return (generatedstring+"@"+generatednumber);
	}


}
