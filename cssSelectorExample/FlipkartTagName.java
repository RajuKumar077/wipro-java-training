package cssSelectorExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartTagName {
	@Test
	public void f() throws InterruptedException{
		WebDriver driver = new ChromeDriver();

		// Open Flipkart
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

			// Search for a product
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("iPhone");

		WebElement searchButton = driver.findElement(By.cssSelector("button._2iLD__"));
		searchButton.click();

		// Wait for results to load
		Thread.sleep(2000);

		// Get all anchor tags on the page using Tag Name
		List<WebElement> anchorTags = driver.findElements(By.tagName("a"));

		// Print the text of each anchor tag
		for (WebElement anchor : anchorTags) {
			String text = anchor.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}

		// Close the browser
		driver.quit();
	}
}
