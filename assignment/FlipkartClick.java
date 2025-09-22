package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartClick {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Flipkart's homepage
        driver.get("https://www.flipkart.com/");
        
    }

    @Test
    public void testMouseClick() {
        // Locate the Electronics link
        WebElement electronicsLink = driver.findElement(By.xpath("//img[@alt='Electronics']"));

        // Perform mouse click using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsLink).click().perform();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

