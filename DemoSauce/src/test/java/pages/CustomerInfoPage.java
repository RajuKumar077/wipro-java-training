package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Base;
import utils.Reporter;

public class CustomerInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    public CustomerInfoPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        this.test = test;
    }

    // ✅ Corrected function: Takes parameters and uses WebDriverWait instead of sleep
    public void fillingData(String firstName, String lastName, String postalCode) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstName)).sendKeys(firstName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.lastName)).sendKeys(lastName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.postalCode)).sendKeys(postalCode);
            Reporter.generateReport(driver, test, Status.PASS, "Customer info entered successfully");
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, test, Status.FAIL, "Customer info form failed to load");
        }
    }

    // ✅ Moving to next page by clicking the Continue button
    public void nextcontinue() {
        driver.findElement(Locators.continuebutton).click();

        try {
            // Wait until the Finish button appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.finish));
            Reporter.generateReport(driver, test, Status.PASS, "Clicked on finish page successfully");
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, test, Status.FAIL, "Finish page click failed");
        }
    }
}
