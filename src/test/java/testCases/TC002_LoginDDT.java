package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
public class TC002_LoginDDT extends BaseClass {

	public void verify_Login_DDT(String email, String pwd, String exp) throws InterruptedException {
		logger.info("*****  Starting TC002_LoginDDT successfully  *****");

		try {
			LoginPage lp = new LoginPage(driver);
			logger.info("Typing Username...");
			lp.setUsername(email);
			logger.info("Typing password...");
			lp.setPassword(pwd);
			logger.info("clicking on Login Button...");
			lp.clickLogin();

			DashboardPage dp = new DashboardPage(driver);
			System.out.println(exp);

			if (exp.equalsIgnoreCase("Valid")) {

				boolean targetPage = dp.isLoginSuccessful();

				if (targetPage == true) {

					Assert.assertTrue(true);
					dp.clickLogout();

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {

				boolean invalidDetails = lp.areCredentialsInvalid();

				boolean emptytxtField = lp.isTextEmpty();
				boolean targetPage = dp.isLoginSuccessful();

				if (targetPage == true) {

					dp.clickLogout();
					Assert.assertTrue(false);

				} else if (invalidDetails == true) {
					Assert.assertTrue(true);
					logger.info("Invalid Credensials...");

				} else if (emptytxtField == true) {
					Assert.assertTrue(true);
					logger.info("Text field is Empty...");

				}
			}
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}

		logger.info("*****  Finsished TC002_LoginDDT successfully  *****");
	}

}
