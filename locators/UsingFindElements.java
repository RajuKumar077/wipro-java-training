package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UsingFindElements {
	@Test
	public void f() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(
				"https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=6903580437108738942&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9151202&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1/");

		// Using findElements() to get all matching links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println("Total number of links: " + allLinks.size());

		// Using ForEach
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
		}

		// Closing the browser
		driver.quit();
	}
}
