package parallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest {

	@Test
	public void launchChrome() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		sleep(1000);
		driver.close();
	}

	@Test
	public void launchFirefox() {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		sleep(1000);
		driver.close();
	}

	@Test
	public void launchEdge() {

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		sleep(1000);
		driver.close();
	}

	private void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
