package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	
	public void verify_login()
	{
		HomePage hp=new HomePage(driver);
		try
		{
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		MyAccount myacc=new MyAccount(driver);
		myacc.isMyAccountExist();
		
		boolean targetpage=myacc.isMyAccountExist();
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
}
