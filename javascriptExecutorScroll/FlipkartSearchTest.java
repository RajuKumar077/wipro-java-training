package javascriptExecutorScroll;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartSearchTest {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@BeforeMethod
	public void setup() {
		// Initialize WebDriver
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;

		// Open Flipkart
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		// Close login popup if it appears
		try {
			WebElement closePopup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), '✕')]")));
			closePopup.click();
		} catch (Exception e) {
			System.out.println("Login popup not displayed");
		}
	}

	@Test
	public void searchAndClickItem() {
		String searchItem = "Lenovo Tab"; 

		// Find and input search text
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		searchBox.sendKeys(searchItem);
		searchBox.sendKeys(Keys.ENTER);

		// Wait for results to load
		sleep(3000);

		// Click on the first product dynamically
		try {
			WebElement firstProduct = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/p/')])[1]")));
			js.executeScript("arguments[0].click();", firstProduct); // 🔹 Use JS Executor if necessary
			System.out.println("firstProduct name: "+firstProduct.getText());
			System.out.println("Clicked on the first search result.");
		} catch (Exception e) {
			System.out.println("Failed to click the product: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		sleep(2000);
		driver.quit();
	}

	private void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
