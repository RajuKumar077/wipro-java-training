package screenShotTest;

import java.awt.Window;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenshotTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void captureScreenshot() throws IOException {
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String folderPath = "C:\\Users\\Administrator\\eclipse-workspace\\SeleniumPrograms\\src\\test\\java\\ScreenShotFolder";
		File destFile = new File(folderPath + "\\screenshot.png");

		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
