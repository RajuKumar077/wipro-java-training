package BasicProgram;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartFindElementsTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	@Test
	public void testLogin() throws InterruptedException {

		Thread.sleep(1200);
		driver.findElement(By.name("q")).sendKeys("Laptop");

		// Clicking search button
		driver.findElement(By.className("_2iLD__")).click();

		// Wait for the results to load
		Thread.sleep(1324);

		// Fetch all product names
		List<WebElement> productNames = driver.findElements(By.className("KzDlHZ"));
		System.out.println("Products found for 'Laptop':");
		for (int i = 0; i < productNames.size(); i++) {
			System.out.println((i + 1) + ": " + productNames.get(i).getText());
		}

		// Take input from user for nth product
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the product number you want to see among " + productNames.size() + " Products: ");
		int n = scanner.nextInt();
		scanner.close();

		String nthProduct = productNames.get(n - 1).getText();
		System.out.println("You selected product number " + n + ": " + nthProduct);

		// Assert that products are displayed
		Assert.assertTrue(productNames.size() > 0, "No products displayed for the search query: Laptop");
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
