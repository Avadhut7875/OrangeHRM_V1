package testCases;

import org.testng.Assert;



import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {

	@Test
	public void verify_Login() {
		
		logger.info("***** Starting TC001_LoginTest Successfully *****");
		
		try {
			logger.info("Providing details...");
			Thread.sleep(2000);
			
			LoginPage lp= new LoginPage(driver);
			lp.setUsername(p.getProperty("username"));
			logger.info("setting email...");
			lp.setPassword(p.getProperty("password"));
			logger.info("setting password...");
			lp.clickLogin();
			logger.info("Clicking on Login button...");
			
			DashboardPage dp= new DashboardPage(driver);
		    
			if(dp.isLoginSuccessful()) {
				logger.info("Logged in Successfully");
				Thread.sleep(2000);
			}else {
				logger.info("Not Logged in ");
			}
		
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_LoginTest Successfully *****");
	}
}
