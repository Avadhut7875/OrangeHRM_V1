package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);

	}
	
//	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2))
//			.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);
	
	@FindBy(xpath = "(//h6[normalize-space()='Dashboard'])[1]")
	WebElement heading;
	
	@FindBy(xpath = "(//p[@class='oxd-userdropdown-name'])[1]")
	WebElement profile;
	
	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	WebElement lnkLogout;

	public boolean isLoginSuccessful() {
		try {
		return heading.isDisplayed();
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void clickLogout() {
		profile.click();
		lnkLogout.click();
	}
	
	

}
