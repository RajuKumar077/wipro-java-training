package DataProviderTest;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlipkartDataProvideHardCode {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	@Test(dataProvider = "getData")
	public void testSearch(String prodName, int nthProduct) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle login popup if displayed
		try {
			WebElement closeButton = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'✕')]")));
			closeButton.click();
			System.out.println("Login popup closed.");
		} catch (Exception e) {
			System.out.println("Login popup was not displayed.");
		}

		// Enter product name in search box
		driver.findElement(By.name("q")).sendKeys(prodName);

		// Click on search button
		driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();

		// Get search results info
		String showResult = driver.findElement(By.xpath("//span[contains(text(),'1 – 24')]")).getText();
		String productName;

		if (showResult.contains("1 – 24")) {
			System.out.println("Products are displayed as List");
			// if it is List View
			productName = driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[" + nthProduct + "]")).getText();
		} else {
			System.out.println("Products are displayed as Grid");
			// if it is Grid View
			productName = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[" + nthProduct + "]")).getText();
		}

		System.out.println(nthProduct + "th product of " + prodName + " is: " + productName);
		driver.navigate().back();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "laptop", 3 }, { "mobile", 5 } };
	}

	@AfterClass
	public void tearDown() {
		sleep(4000);
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
