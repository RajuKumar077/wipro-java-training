package alertHandlingTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromtButtonAlert {

	WebDriver driver;

	// Setup method using @BeforeClass
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
	}

	// Test method for alert handling
	@Test
	public void testAlertHandling() {
		try {
			// Locate the alert button to scroll into view
			WebElement promtButton = driver.findElement(By.id("promtButton"));

			// Scroll down to make the alert button visible using scrollIntoView
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", promtButton);

			// Wait for the scroll to complete
			sleep(1000);

			// Click the button to trigger the alert
			promtButton.click();

			// Wait for the alert to be present
			sleep(2000);

			// Switch to the alert and accept it
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("Alter from Testing");
			alert.accept();

			System.out.println("Alert Written in promtButton accepted successfully!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	// Tear down method using @AfterClass
	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	// Sleep function
	void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
