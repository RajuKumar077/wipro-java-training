package assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CountyCurrentPrice {
	WebDriver driver = new ChromeDriver();
	Scanner scanner = new Scanner(System.in);
	List<String> companyList = new ArrayList<>();

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		waitForPageLoad();
	}

	@Test
	public void f() {
		// Locate all company names
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[contains(., 'Company')]//tbody/tr/td[1]"));

		// Display and store all company names
		System.out.println("Available Company Names:");
		for (WebElement companyName : companyNames) {
			String name = companyName.getText();
			companyList.add(name);
			System.out.println(name);
		}

		// Ask user to select a company name from the list
		System.out.print("\nEnter the exact company name from the list above to get the current price: ");
		String userInput = scanner.nextLine().trim().toLowerCase();

		// Loop through each row and check for the selected company name
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(., 'Company')]//tbody/tr"));
		boolean found = false;
		for (WebElement row : rows) {
			WebElement companyNameElement = row.findElement(By.xpath("td[1]"));
			String companyName = companyNameElement.getText().trim().toLowerCase();

			// If the selected company name matches, get the current price
			if (companyName.equals(userInput)) {
				WebElement currentPriceElement = row.findElement(By.xpath("td[4]"));
				String currentPrice = currentPriceElement.getText();
				System.out.println("Current Price of " + companyName + ": " + currentPrice);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Company not found. Please ensure you typed the name exactly as shown.");
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		scanner.close();
	}

	// Wait for the table to fully load using Explicit Wait
	void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(., 'Company')]")));
	}
}
