package pageObjects;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2))
	//		.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);

	@FindBy(xpath = "(//input[@placeholder='Username'])[1]")
	WebElement txtUsername;

	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement lnkForgotPassword;

	@FindBy(xpath = "//p[contains(@class,'oxd-text oxd-text--p oxd-alert-content-text')]")
	WebElement invalidErrorMsg;

	@FindBy(xpath = "//span[text()='Required']")
	WebElement emptyErrorMsg;

	public void setUsername(String un) {
		txtUsername.sendKeys(un);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickForgotPassword() {
		lnkForgotPassword.click();
	}

	public boolean areCredentialsInvalid() {
		try {
		return invalidErrorMsg.isDisplayed();
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean isTextEmpty() {
		try {
		return emptyErrorMsg.isDisplayed();
		
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
