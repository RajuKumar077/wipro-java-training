package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollFlipkartTest {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeClass
	public void setup() {

		// Initialize the ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Initialize JavaScript Executor
		js = (JavascriptExecutor) driver;

		// Open Flipkart's homepage
		driver.get("https://www.flipkart.com/");

	}

	@Test
	public void testScrollUsingWebElement() throws InterruptedException {
		// Locate the element to scroll to (Example: Footer)
		WebElement footerElement = driver.findElement(By.xpath("//footer"));

		// Before scrolling
		System.out.println("Before scrolling...");
		Thread.sleep(2000);

		// Scroll to the footer element
		js.executeScript("arguments[0].scrollIntoView(true);", footerElement);
		Thread.sleep(3000); // Wait to see the scroll effect

		// Scroll back to the top
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000); // Wait to see the scroll effect

		// Scroll Down by Pixel using WebElement
		WebElement bodyElement = driver.findElement(By.tagName("body"));
		for (int i = 0; i < 3; i++) {
			js.executeScript("arguments[0].scrollBy(0, 1000);", bodyElement);
			Thread.sleep(2000); // Wait for 2 seconds
		}

		// Scroll Up by Pixel using WebElement
		for (int i = 0; i < 3; i++) {
			js.executeScript("arguments[0].scrollBy(0, -1000);", bodyElement);
			Thread.sleep(2000); // Wait for 2 seconds
		}

		// After scrolling
		System.out.println("After scrolling...");
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
