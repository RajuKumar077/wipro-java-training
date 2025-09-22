package iframesHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesHandlingTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://docs.oracle.com/javase/7/docs/api/");
    }
    
    @Test
    public void testIFrame() {
        
        // Get total number of frames on the page
        int totalFrames = driver.findElements(By.tagName("frame")).size();
        System.out.println("Total Number of Frames: " + totalFrames);

        // Get the current page title
        System.out.println("Page Title: " + driver.getTitle());
        
        // Get the first frame's source attribute
        WebElement firstFrame = driver.findElement(By.tagName("frame"));
        System.out.println("Current Frame Source: " + firstFrame.getDomAttribute("src"));
        
        // Switch to the frame by names
        driver.switchTo().frame("classFrame");

        // Get and print the heading text inside the iframe
        String headingText = driver.findElement(By.xpath("//h1[contains(text(),'Java')]")).getText();
        System.out.println("Heading Text: " + headingText);
        
        // Pause for visibility
        sleep(2000);
  
    }
    
    @AfterMethod
    public void tearDown() {
        // Wait before closing the browser
        sleep(2000);
        driver.quit();
    }

    // Utility method for sleep
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
