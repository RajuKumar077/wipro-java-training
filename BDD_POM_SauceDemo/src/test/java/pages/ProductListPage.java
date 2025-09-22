package pages;

import java.time.Duration; // Correct import for Duration

import org.openqa.selenium.TimeoutException; // Correct import for TimeoutException
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class ProductListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    public ProductListPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Corrected Duration import
        this.test = test;
    }

    public boolean selectProduct() {
        driver.findElement(Locators.firstProduct).click();
        boolean actResult = true;

        try {
            // Explicit wait for "Back to Products" button to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.backToProduct));
            Reporter.generateReport(driver, test, Status.PASS, "Selecting the product was successful");
        } catch (TimeoutException te) { // Corrected TimeoutException import
            actResult = false;
            Reporter.generateReport(driver, test, Status.FAIL, "Selecting the product failed");
        }

        return actResult;
    }
}
