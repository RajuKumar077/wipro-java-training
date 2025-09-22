package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

public class LoginDataTableStepDef {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} and {string} and login button")
    public void the_user_enters_and_and_login_button(String userName, String password) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user validates products text")
    public void the_user_validates_products_text() throws InterruptedException {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
            System.out.println("Login is successful");
        } catch (TimeoutException te) {
            System.out.println("Login failed: Products page not found.");
        }
    }

    @Then("the user logsout")
    public void the_user_logsout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
