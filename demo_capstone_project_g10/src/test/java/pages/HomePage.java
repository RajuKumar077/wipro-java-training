package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;

public class HomePage {
	private WebDriver driver; // WebDriver instance 
	private WebDriverWait wait; // WebDriverWait instance for waits

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait

	}

	public boolean validatePage() {
		String Home_Page = driver.findElement(Locators.Home).getText();
		System.out.println(Home_Page);
		boolean actResult;
		if (Home_Page.equals("HOME")) {
			actResult = true;

		} else {
			actResult = false;
		}
		return actResult;
	}

	public boolean OnlineBanking() {

		driver.findElement(Locators.OnlineBanking).click();
		boolean actResult = true;
		try {
			// explicit wait for Account Summary text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_summary_link")));
		} catch (TimeoutException te) {
			actResult = false;
		}
		return actResult;
	}

}
