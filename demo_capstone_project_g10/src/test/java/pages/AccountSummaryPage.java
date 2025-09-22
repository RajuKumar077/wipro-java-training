package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import objectrepository.Locators;

public class AccountSummaryPage {

	private WebDriver driver; // WebDriver instance
	private WebDriverWait wait; // WebDriverWait instance for explicit waits

	// Constructor to initialize WebDriver and WebDriverWait
	public AccountSummaryPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// Method to click on the Account Summary link
	public boolean clickAccountSummaryLink() {
		driver.findElement(Locators.ACCOUNT_SUMMARY_LINK).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CASH_ACCOUNTS));
		} catch (TimeoutException te) {
			actResult = false;
		}
		return actResult;
	}

	// Method to validate the presence of Cash Accounts section
	public boolean isCashAccountsVisible() {

		String accountText = driver.findElement(Locators.CASH_ACCOUNTS).getText();
		boolean actResult = true;
		if (!accountText.equals("Cash Accounts")) {
			actResult = false;
		}
		return actResult;
	}

	// Method to validate the presence of Investment Accounts section
	public boolean isInvestmentAccountsVisible() {
		String accountText = driver.findElement(Locators.INVESTMENT_ACCOUNTS).getText();
		boolean actResult = true;
		if (!accountText.equals("Investment Accounts")) {
			actResult = false;
		}

		return actResult;
	}

	// Method to validate the presence of Credit Accounts section
	public boolean isCreditAccountsVisible() {
		String accountText = driver.findElement(Locators.CREDIT_ACCOUNTS).getText();
		boolean actResult = true;
		if (!accountText.equals("Credit Accounts")) {
			actResult = false;
		}

		return actResult;
	}

	// Method to validate the presence of Loan Accounts section by scrolling into view
	public boolean isLoanAccountsVisible() {
		boolean actResult = true;
		try {

			// Scroll to the end of the page
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			// Wait for Loan Accounts element to be visible
			WebElement loanAccountElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(Locators.LOAN_ACCOUNTS));

			// Fetch the text and trim spaces
			String accountText = loanAccountElement.getText();

			// Validate the text
			actResult = accountText.equals("Loan Accounts");

		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("Element not found within the timeout period.");
		} catch (Exception e) {
			actResult = false;
			e.printStackTrace();
		}

		return actResult;
	}

}
