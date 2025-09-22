package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UsingFindElement {
	@Test
	public void f() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rediff.com/");

		// Using findElement() to get the first matching link
		WebElement firstLink = driver.findElement(By.tagName("a"));
		System.out.println("First link text: " + firstLink.getText());

		driver.quit();
	}

}
