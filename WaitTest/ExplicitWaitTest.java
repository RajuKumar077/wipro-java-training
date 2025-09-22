package WaitTest;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class ExplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/");
    }

    @Test
    public void testExplicitWait() throws InterruptedException {
        // Explicit Wait for the element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement speakerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speakersTxt")));
        String speakerText = speakerElement.getText();
        System.out.println("Output is: " + speakerText);
        
        // Waiting for other elements (Optional)
        // Example for tablets and mice:
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabletsTxt")));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("miceTxt")));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000); // Optional wait before closing
        driver.quit();
    }
}



