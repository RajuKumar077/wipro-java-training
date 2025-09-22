package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public Boolean fillingData(String firstName, String lastName, String postalCode) {
        boolean actResult = true;
        try {
            System.out.println("Waiting for First Name field...");
            WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstName));
            firstNameElement.clear();
            firstNameElement.sendKeys(firstName);
            System.out.println("Entered First Name: " + firstName);

            System.out.println("Waiting for Last Name field...");
            WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.lastName));
            lastNameElement.clear();
            lastNameElement.sendKeys(lastName);
            System.out.println("Entered Last Name: " + lastName);

            System.out.println("Waiting for Postal Code field...");
            WebElement postalCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.postalCode));
            postalCodeElement.clear();
            postalCodeElement.sendKeys(postalCode);
            System.out.println("Entered Postal Code: " + postalCode);

            Reporter.generateReport(driver, test, Status.PASS, "Customer info entered successfully");

        } catch (TimeoutException te) {
            Reporter.generateReport(driver, test, Status.FAIL, "Customer info form failed to load");
            actResult = false;
        }
        return actResult;
    }


    // ✅ Moving to next page by clicking the Continue button
    public boolean nextcontinue() {
        driver.findElement(Locators.continuebutton).click();
        boolean actResult = true;
        try {
            // Wait until the Finish button appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.finish));
            Reporter.generateReport(driver, test, Status.PASS, "Clicked on finish page successfully");
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, test, Status.FAIL, "Finish page click failed");
        }
        return actResult ;
    }
}
