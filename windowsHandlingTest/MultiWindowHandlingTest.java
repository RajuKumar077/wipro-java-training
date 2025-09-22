package windowsHandlingTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiWindowHandlingTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		// Initialize the Chrome WebDriver
		driver = new ChromeDriver();
		// Set an explicit wait time of 10 seconds
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Flipkart website
		driver.get("https://www.flipkart.com");

		// Close the login popup if it appears
		try {
			WebElement closeLoginPopup = wait.until(ExpectedConditions.elementToBeClickable(By.className("Pke_EE")));
			closeLoginPopup.click();
		} catch (Exception e) {
			System.out.println("Login popup not displayed");
		}
	}

	@Test
	public void handleMultipleWindows() throws InterruptedException {
		// Define the product to be searched
		String searchProduct = "iPhone";

		// Locate and interact with the search box dynamically
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable((By.className("Pke_EE"))));
		searchBox.sendKeys(searchProduct);
		searchBox.submit();

		// Wait for search results to load
		Thread.sleep(3000);

		// Click on the first product link dynamically
		WebElement firstProduct = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'/p/')])[1]")));
		firstProduct.click();

		// Store the parent window handle
		String parentWindow = driver.getWindowHandle();

		// Get all open windows (handles)
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();

		// Iterate through all open windows
		while (iterator.hasNext()) {
			String childWindow = iterator.next();

			// Switch to the new tab (child window) if it's not the parent window
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Switched to new tab: " + driver.getTitle());

				// Extract product title
				WebElement productTitleElement = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'VU-ZEz')]")));
				String productTitle = productTitleElement.getText();

				// Extract product price
				WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class, 'Nx9bqj') and contains(text(), '₹')]")));
				String price = priceElement.getText();

				// Print product details
				System.out.println("Product Title: " + productTitle);
				System.out.println("Product Price: " + price);

				// Wait for 3 seconds to observe output before closing the child window
				Thread.sleep(3000);

				// Close the child window (new tab)
				driver.close();
			}
		}

		// Switch back to the main parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Back to Parent Window: " + driver.getTitle());
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		// Wait for 2 seconds before quitting the browser
		Thread.sleep(2000);
		// Close the browser and end the session
		driver.quit();
	}
}
