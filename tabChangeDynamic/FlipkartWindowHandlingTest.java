package tabChangeDynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class FlipkartWindowHandlingTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		// Initialize the ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open Flipkart's homepage
		driver.get("https://www.flipkart.com/");

	}

	@Test
	public void testWindowHandling() throws InterruptedException {
		// Click on a link that opens in a new window/tab (Example: Advertisements or
		// Product Link)
		WebElement electronicsLink = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		electronicsLink.click();

		// Get the main window handle
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Main Window Handle: " + mainWindowHandle);

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		// Iterate through windows
		while (iterator.hasNext()) {
			String childWindowHandle = iterator.next();
			if (!mainWindowHandle.equals(childWindowHandle)) {
				// Switch to child window
				driver.switchTo().window(childWindowHandle);
				System.out.println("Switched to Child Window: " + childWindowHandle);

				// Perform actions on the new window
				Thread.sleep(3000); // Wait for the page to load

				// Print the title of the new window
				System.out.println("Child Window Title: " + driver.getTitle());
				Thread.sleep(2000);

				// Close the child window
				driver.close();
				System.out.println("Closed Child Window: " + childWindowHandle);
			}
		}

		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switched back to Main Window: " + mainWindowHandle);

		// Verify main window title
		System.out.println("Main Window Title: " + driver.getTitle());
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() {
		// Close the main browser window
		driver.quit();
	}
}
