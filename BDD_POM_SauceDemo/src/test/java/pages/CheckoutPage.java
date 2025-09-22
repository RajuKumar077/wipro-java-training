package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Reporter;

public class CheckoutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public CheckoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	// Click on the Cart Icon to navigate to the Cart Page
	public boolean goToCart() {
		driver.findElement(Locators.verifyCart).click();
		boolean actResult = true;
		try {
			// Wait until 'Checkout' button is visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.checkoutButton));
			Reporter.generateReport(driver, test, Status.PASS, "Navigated to checkout Page");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Failed to Navigated to checkout Page");
		}
		return actResult ;
	}

	// Click on the "Checkout" button
	public boolean clickCheckout() {
		driver.findElement(Locators.checkoutButton).click();
		boolean actResult = true;
		try {
			// Wait until checkout page loads
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifycheckoutButton));
			Reporter.generateReport(driver, test, Status.PASS, "Clicked on Checkout successfully");
		} catch (TimeoutException te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Checkout button click failed");
		}
		return actResult ; 
	}
}
