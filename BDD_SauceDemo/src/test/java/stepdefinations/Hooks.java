package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.When;

import java.time.Duration;

public class Hooks {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll()
    public static void beforeAll() {
        System.out.println("Before first Scenario and only once");
    }

    @AfterAll()
    public static void afterAll() {
        System.out.println("After last Scenario and only once");
    }

    @Before()
    public void before() {
        System.out.println("Before Scenario");

        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After()
    public void after() throws InterruptedException {
        System.out.println("After Scenario");
        Thread.sleep(3000);

        // Avoid NullPointerException
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is already null, skipping quit.");
        }
    }

    @BeforeStep()
    public void beforeStep() {
        System.out.println("Before each step");
    }

    @AfterStep()
    public void afterStep() {
        System.out.println("After each step");
    }

    @When("the user enters username and password and login button")
    public void the_user_enters_and_and_login_button() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
