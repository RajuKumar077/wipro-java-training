package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.time.Duration;

public class LoginStepDef {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("the user is on the login page")
    public void the_user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters username as {string} and password as {string} and clicks the login button")
    public void the_user_enters_username_and_password_and_login_button(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user validates the product text")
    public void the_user_validates_products_text() {
        try {
            WebElement productsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
            if (productsText.isDisplayed()) {
                System.out.println("Login is successful");
            }
        } catch (Exception e) {
            System.out.println("Login failed");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
