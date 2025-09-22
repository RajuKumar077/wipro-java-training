package alertHandlingTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandlingTestAccept {

	WebDriver driver;

	// Setup method using @Before
	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
	}

	// Test method for alert handling
	@Test
	public void testAlertHandling() {
		try {
			// Click the button to trigger the alert
			driver.findElement(By.id("alertButton")).click();

			// Wait for the alert to be present
			sleep(2000);

			// Switch to the alert and accept it
			Alert alert = driver.switchTo().alert();
			alert.accept();

			System.out.println("Alert accepted successfully!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	// Tear down method using @After
	@AfterMethod
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
