package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkText {
	@Test
	public void getXpath() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rediff.com/");

		driver.findElement(By.linkText("Create Account")).click();
		System.out.println("Clicked on 'Create Account' using Link Text.");

		driver.findElement(By.partialLinkText("Create")).click();
		System.out.println("Clicked on a link using Partial Link Text.");

		driver.close();

	}

}
