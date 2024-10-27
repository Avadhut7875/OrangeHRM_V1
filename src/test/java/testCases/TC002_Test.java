package testCases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;


public class TC002_Test {
        public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    driver.manage().window().maximize();
		    Thread.sleep(1000);
			LoginPage lp= new LoginPage(driver);
			lp.setUsername("Admin");
			Thread.sleep(1000);
			lp.setPassword("admin123");
			lp.clickLogin();
        
        }
        
       
}
