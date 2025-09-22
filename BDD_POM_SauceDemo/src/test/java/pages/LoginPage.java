package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Base;
import utils.Reporter;  

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	
	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}
	
	// validate SauceDemo is launched
	public boolean validateURL() {
		
		String currURL = driver.getCurrentUrl();
		
		boolean actResult;
		
		if(currURL.equals("https://www.saucedemo.com/")) {
			actResult = true;
			Reporter.generateReport(driver, test, Status.PASS, "Sauce Demo Launched Successfully");
			
		} else {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Launching Sauce Demo failure");

		}
		
		return actResult;
	}
	
	
	// code for login operations
	public boolean validateLogin(String uname, String pwd) {
		
		driver.findElement(Locators.userName).sendKeys(uname);
		Base.sleep(1000);
		driver.findElement(Locators.password).sendKeys(pwd);
		Base.sleep(1000);
		driver.findElement(Locators.loginButton).click();
		
		boolean actResult = true;
		
		try {
			// explicit wait for Products text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			Reporter.generateReport(driver, test, Status.PASS, "Login is Success");
			
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Login is failure");

		}
		
		return actResult;
	}
	

}
