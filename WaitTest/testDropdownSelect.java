package WaitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testDropdownSelect {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
	}

	@Test
	public void testExplicitWait() throws InterruptedException {

		// Select Date
		Select date = new Select(driver.findElement(By.id("day")));
		date.selectByIndex(4); // (Index starts from 0)
		Thread.sleep(2000);

		// Select Month by Value
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("7"); // ( value="7" is July)
		Thread.sleep(2000);

		// Select Month by Visible Text
		month.selectByVisibleText("Nov"); // Selects November
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
