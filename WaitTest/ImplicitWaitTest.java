package WaitTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitTest {
	  WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	     
	        driver = new ChromeDriver();
	        driver.get("https://www.advantageonlineshopping.com/#/");
	        driver.manage().window().maximize();
	        
	        // Setting Implicit Wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test
	    public void testImplicitWait() {
	        // Locate and get text of the element
	        WebElement speakerElement = driver.findElement(By.id("speakersTxt"));
	        String speakerText = speakerElement.getText();
	        System.out.println("Output is: " + speakerText);
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Quit the driver after the test
	        driver.quit();
	    }
	}
