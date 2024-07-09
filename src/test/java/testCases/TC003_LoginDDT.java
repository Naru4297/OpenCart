package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//getting data provider from different class

	public void login_DDT(String emial, String pwd, String exp)
	{
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(emial);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		MyAccount myacc=new MyAccount(driver);
		boolean target_page=myacc.isMyAccountExist();
		
		if(exp.equalsIgnoreCase("Valid"))	//if data is valid
		{
			if(target_page==true)			//target page does exist "true"
			{
				myacc.clicklogout();		//logout 
				Assert.assertTrue(true);	//test passed
			}
			else							//target page does not exist "false"
			{
				Assert.assertTrue(false);   //test failed 
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
			if(target_page==true)			//target page does exist "true"
			{
				myacc.clicklogout();		//logout 
				Assert.assertTrue(false);	//test failed
			}
			else						   //target page does not exist 
			{
				Assert.assertTrue(true);	//test passed 
			}
		} catch(Exception e)
		
		{
			Assert.fail();
		}
	}
		
}
