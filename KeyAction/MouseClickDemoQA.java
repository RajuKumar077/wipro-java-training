package KeyAction;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseClickDemoQA {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu#");
    }

    @Test
    public void navigateToSubSubItem2() {

        // Locate elements
        WebElement menuItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        WebElement subsubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        WebElement subsubItem2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));

        // Scroll to Menu Item 2
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", menuItem2);

        // Navigate using Actions class
        new Actions(driver)
                .moveToElement(menuItem2)
                .pause(Duration.ofSeconds(1))
                .moveToElement(subsubList)
                .pause(Duration.ofSeconds(1))
                .moveToElement(subsubItem2)
                .click()
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
