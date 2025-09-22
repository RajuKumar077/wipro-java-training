package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import objectrepository.Locators;

public class OnlineStatementPage {
	private WebDriver driver; // WebDriver instance for interacting with the browser
	private WebDriverWait wait; // WebDriverWait instance for explicit waits

	public OnlineStatementPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait
	}

	// Actions
	public boolean clickOnlineStatements() {
		boolean actResult = true;
		driver.findElement(Locators.OnlineStatement).click();
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.OnlineStatementLoadSuccess));
		} catch(TimeoutException e) {
			actResult = false;
		}
		return actResult;
	}

	public boolean selectAccountType() {
		Select dropdown = new Select(driver.findElement(Locators.AccountTypeOnlineStatment));
		dropdown.selectByContainsVisibleText("Brokerage");
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		
		boolean actResult = true;
		if(!selectedOption.equals("Brokerage")) {
			System.out.println("Account Type Selecting Failed");
			actResult = false;
		}
		return actResult;
	}

	public boolean selectYear() {
		boolean actResult = true;
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.StatementYear));

		WebElement year = driver.findElement(Locators.StatementYear);
		year.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.StatementYearVerifier));
		String yearFetched = driver.findElement(Locators.StatementYearVerifier).getText();
		
		if(!yearFetched.equals("2011")) {
			System.out.println("Year Selecting Failed");
			actResult = false;
		}
		return actResult;
	}

	public boolean clickStatementDownloadLink() {
		boolean actResult = true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.StatementDownloadLink));
		driver.findElement(Locators.StatementDownloadLink).click();
		} catch(Exception e) {
			actResult = false;
			System.out.println("Something went wrong while Clicking statement Download Link");
		}
		return actResult;
	}
	
	public boolean verifyStatement() {
		
		boolean actResult = true;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.StatementDownloadLink));
		String statement = driver.findElement(Locators.StatementDownloadLink).getText();
		
		if(!statement.contains("Statement")) {
			actResult = false;
		}
		} catch(Exception e) {
			actResult = false;
			System.out.println("Something went wrong while Clicking statement Download Link");
		}
		return actResult;
	}

}
