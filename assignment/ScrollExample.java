package assignment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class ScrollExample {

    public static void main(String[] args) {
       
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window and set timeout
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the demo page for infinite scrolling
        driver.get("https://infinite-scroll.com/demo/full-page/");

        // Perform the scroll operations
        try {
            performScroll(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the actions
            driver.quit();
        }
    }

    public static void performScroll(WebDriver driver) throws InterruptedException {
        // Initialize JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Sleep before scrolling
        System.out.println("Before scrolling...");
        Thread.sleep(2000);

        // Scroll Down in steps
        for (int i = 0; i < 3; i++) {
            js.executeScript("window.scrollBy(0, 1000);"); // Scroll down by 1000 pixels
            Thread.sleep(2000); // Wait for 2 seconds
        }

        // Scroll Up in steps
        for (int i = 0; i < 3; i++) {
            js.executeScript("window.scrollBy(0, -1000);"); // Scroll up by 1000 pixels
            Thread.sleep(2000); // Wait for 2 seconds
        }

        // Alternative: Scroll to the bottom of the page
        Thread.sleep(2000); // Before scrolling to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(3000); // After scrolling to bottom

        // Alternative: Scroll to the top of the page
        Thread.sleep(2000); // Before scrolling to top
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(3000); // After scrolling to top

        // Sleep after scrolling
        System.out.println("After scrolling...");
        Thread.sleep(2000);
    }
}
