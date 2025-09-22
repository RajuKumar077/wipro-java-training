package javascriptExecutorScroll;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollAmazonTest {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cpstest.click/en/scroll-test");

        // Initialize JavaScript Executor
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testScroll() throws InterruptedException {
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        // Scroll to Specific section
        WebElement upToOff = driver.findElement(By.xpath("//h2[text()= 'Why do we need a scroll test?']"));
        js.executeScript("arguments[0].scrollIntoView(true);", upToOff);
        Thread.sleep(2000);

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
