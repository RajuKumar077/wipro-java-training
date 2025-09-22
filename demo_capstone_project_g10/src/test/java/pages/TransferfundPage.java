package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;

public class TransferfundPage {
	private WebDriver driver; // WebDriver instance for interacting with the browser
	private WebDriverWait wait; // WebDriverWait instance for waits

	public TransferfundPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public boolean TransferFund(String Amount) {

		Select Saving1 = new Select(driver.findElement(Locators.From_Account));
		Saving1.selectByValue("1");
		Select Saving2 = new Select(driver.findElement(Locators.To_Account));
		Saving1.selectByValue("3");
		boolean actResult = true;
		driver.findElement(Locators.Amount).sendKeys(Amount);
		
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Descriptions appear for checking')]")));
		} catch (TimeoutException te) {
			actResult = false; // If timeout occurs, login validation fails
		}

		return actResult;

	}

	public boolean TranferfundInfo() {
		driver.findElement(Locators.Continue).click();
		driver.findElement(Locators.TF_submit).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Success_msg));
		} catch (TimeoutException te) {
			actResult = false; // If timeout occurs, login validation fails
		}
		return actResult;
	}

	public boolean SuccessMessage() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Success_msg));
		} catch (TimeoutException te) {
			actResult = false; // If timeout occurs, login validation fails
		}
		return actResult;
	}

	public boolean TransferFundFail() {
		WebElement inputField = driver.findElement(Locators.Amount);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(Locators.Continue).click();
		String message = (String) js.executeScript("return arguments[0].validationMessage;", inputField);
		System.out.println(message);
		boolean actResult;
		if (message.contains(message)) {
			actResult = true;
		} else {
			actResult = false;
		}
		
		return actResult;

	}

}
