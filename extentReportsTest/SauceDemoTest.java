package extentReportsTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SauceDemoTest {
	WebDriver driver;
	WebDriverWait wait;
	static ExtentReports extent;
	static ExtentTest test;

	@BeforeSuite
	public void setupExtentReport() {
		String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void sauceDemoLoginTest() {
		test = extent.createTest("SauceDemo Login Test");

		try {
			driver.get("https://www.saucedemo.com/");
			test.pass("Navigated to SauceDemo");

			// Perform Login
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce1");
			driver.findElement(By.id("login-button")).click();
			test.pass("Login Successful");

			// Validate "Products" Page
			By productsText = By.xpath("//span[text()='Products']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(productsText));
			test.pass("Successfully navigated to Products Page");

			// Assert login was successful
			Assert.assertTrue(driver.findElement(productsText).isDisplayed(), "Products page not found!");

		} catch (Exception e) {
			String screenshotPath = captureScreenshot("TestFailure");
			test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Assert.fail("Test case failed!");
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		extent.flush();
	}

	// Capture Screenshot with Timestamp
	public String captureScreenshot(String screenshotName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String folderPath = "C:\\Users\\Administrator\\eclipse-workspace\\SeleniumPrograms\\src\\test\\java\\ScreenShotFolder";
		String path = folderPath + "\\" + screenshotName + "_" + timestamp + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			new File(folderPath).mkdirs();
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
