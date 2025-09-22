package pages;

import java.time.Duration;
import utils.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;

public class AddNewPayeePage {
	WebDriver driver;
	private WebDriverWait wait;

	public AddNewPayeePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public boolean clickAddNewPayee() {
		try {
			driver.findElement(Locators.Add_New_Payee_Tab).click();
			return true; // Return true if the click is successful
		} catch (Exception e) {
			return false; // Return false if an error occurs
		}
	}

	public boolean enterPayeeDetails(String name, String address, String account) {
	    try {
	        driver.findElement(Locators.New_Payee_Name).sendKeys(name);
	        driver.findElement(Locators.New_Payee_Address).sendKeys(address);
	        driver.findElement(Locators.New_Payee_Account).sendKeys(account);
	        driver.findElement(Locators.Add_New_Payee_Button).click();
	        return true; // Return true if actions succeed
	    } catch (Exception e) {
	        return false; // Return false if an error occurs
	    }
	}

	public boolean verifyPayeeAdded(String payeeName) {
	    try {
	        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.New_Payee_Confirmation));
	        // Extract text and validate message
	        String expectedMessage = "The new payee " + payeeName + " was successfully created.";
	        return confirmationMessage.getText().trim().equals(expectedMessage);
	    } catch (Exception e) {
	        return false;
	    }
	}

    // Verify success message
    public boolean verifySuccessMessage(String payeeName) {
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.New_Payee_Confirmation));
        return alert.getText().contains("The new payee " + payeeName + " was successfully created.");
    }


}
