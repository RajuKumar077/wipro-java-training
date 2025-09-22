package WaitTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

public class ClassImpTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testExplicitWait() throws InterruptedException {
    	
    	
    	 // Enter username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);

        // Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        // Click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(5000);

        // Validate the login result
        WebElement pageTitle = driver.findElement(By.className("title"));
      //  String actResult = pageTitle.getText();
       // Assert.assertEquals(actResult, "Products");

        // Close the browser
        driver.quit();
    	
    	
    	
        
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000); // Optional wait before closing
        driver.quit();
    }
}



