package selectDropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectByIndex {
	WebDriver driver;

	@BeforeClass
	public void setup() {

		// Initialize the ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		sleep(1200);

	}

	@Test
	public void testWindowHandling() throws InterruptedException {

		// finding the YearDropdown path
		WebElement YearDropdown = driver.findElement(By.xpath("//select[contains(@name ,'DOB_Year')]"));

		// making the object of select type
		Select year = new Select(YearDropdown);

		// selecting by Index 1 = 2025
		year.selectByIndex(1);

	}

	@AfterClass
	public void tearDown() {
		// Close the main browser window
		// driver.quit();
	}

	private void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}