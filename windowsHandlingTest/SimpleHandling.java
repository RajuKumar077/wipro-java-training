package windowsHandlingTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleHandling {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void beforeMethod() {

		driver.manage().window().maximize();

		driver.get("https://demo.automationtesting.in/Windows.html");
		sleep(2000);

	}

	@Test
	public void f() throws InterruptedException {

		System.out.println("Title: " + driver.getTitle());

		// Saving the parent Window
		String currWindow = driver.getWindowHandle();
		System.out.println("Current Window: " + currWindow);

		driver.findElement(By.xpath("//button[contains(text(),'click') ]")).click();

		// Get all windows handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to child window
		for (String Childwindow : allWindows) {
			if (!Childwindow.equals(currWindow)) {
				driver.switchTo().window(Childwindow);

				// Saving the Child Window
				String Childwindow2 = driver.getWindowHandle();
				System.out.println("Child Window: " + Childwindow2);

				System.out.println("Switched to child window: " + driver.getTitle());
				break;
			}

		}
		// now closing the child window
		sleep(3000);
		driver.close();

		driver.switchTo().window(currWindow);
		System.out.println("Back to Parent window: " + driver.getTitle());

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(800);
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