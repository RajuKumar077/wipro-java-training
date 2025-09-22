package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CountyTableName {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get("https://money.rediff.com/gainers");
		Thread.sleep(1200);

	}

	@Test
	public void f() throws InterruptedException {
		// Locate all company names
		List<WebElement> companyNames = driver
				.findElements(By.xpath("//table[contains(., 'Company')]//tbody/tr/td[1]"));

		// print each the company name
		System.out.println("Company Names:");
		for (WebElement companyName : companyNames) {
			System.out.println(companyName.getText());
		}
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(1200);
		driver.close();

	}

}
