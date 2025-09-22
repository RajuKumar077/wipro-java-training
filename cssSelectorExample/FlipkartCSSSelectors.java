package cssSelectorExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartCSSSelectors {
	@Test
	public void f() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		// Search for a product
		WebElement searchBox = driver.findElement(By.cssSelector("input.Pke_EE"));
		searchBox.sendKeys("Iqoo 13");

		WebElement searchButton = driver.findElement(By.cssSelector("button._2iLD__"));
		searchButton.click();

		// Wait for results to load
		Thread.sleep(2000);

		// Get product names and prices
		List<WebElement> productNames = driver.findElements(By.className("KzDlHZ"));
		List<WebElement> productPrices = driver.findElements(By.cssSelector("div.Nx9bqj._4b5DiR"));

		for (int i = 0; i < productNames.size(); i++) {
			System.out.println(productNames.get(i).getText() + " - " + productPrices.get(i).getText());
		}

		// Close the browser
		driver.quit();
	}
}
