package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Flipkart {
	@Test
	public void testLogin() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1200);
		driver.findElement(By.name("q")).sendKeys("Laptop");
		
		// clicking search button
		driver.findElement(By.className("_2iLD__")).click();
		
		String productRating = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]")).getText();
		
		System.out.println("Rating: "+ productRating);
		
		Assert.assertTrue(productRating.contains("Ratings"));
		
		driver.close();

	}
}