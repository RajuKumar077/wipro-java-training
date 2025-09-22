package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;

public class OnlineBookingPage {
	private WebDriver driver; // WebDriver instance 
	private WebDriverWait wait; // WebDriverWait instance for waits
	
	public OnlineBookingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait

	}
	
	
	public boolean MyAccountSummery() {	
		driver.findElement(Locators.Account_Summery).click();
		boolean actResult = true;

//		try {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators));
//		} catch (TimeoutException te) {
//			actResult = false; 
//		}

		return actResult;
		
	}
	
	public boolean transferfund() {
		driver.findElement(Locators.Transfer_fund).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.From_Account));
		} catch (TimeoutException te) {
			actResult = false; 
		}

		return actResult;
		
	}
	
	public boolean Paybills() {
		driver.findElement(Locators.Pay_bills).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Pay_Bill));
		} catch (TimeoutException te) {
			actResult = false; 
		}

		return actResult;
		
	}
	
	public boolean OnlineStatement() {
		driver.findElement(Locators.Online_Statement).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OnlineStatement));
		} catch (TimeoutException te) {
			actResult = false; 
		}

		return actResult;
		
	}
	
	

}
