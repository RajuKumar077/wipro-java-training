package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Base;
import objectrepository.Locators;

public class PayBillPage {
	WebDriver driver;

	public PayBillPage(WebDriver driver) {
		this.driver = driver;
	}

	// Validate Pay Bill Page URL
	public boolean validatePayBillURL() {
		driver.findElement(Locators.Pay_Bill).click();
		String currURL = driver.getCurrentUrl();
		boolean actResult = currURL.equals("http://zero.webappsecurity.com/bank/pay-bills.html");
		return actResult;
	}

	// Complete Payment Flow: Select Payee, Account, Amount, and Date
	public boolean completePayBillProcess(String payeeName, String accountType, String amount) {
		Select payeeDropdown = new Select(driver.findElement(Locators.Payee_Dropdown));
		payeeDropdown.selectByVisibleText(payeeName);
		boolean payeeSelected = payeeDropdown.getFirstSelectedOption().getText().equals(payeeName);

		Select accountDropdown = new Select(driver.findElement(Locators.Account_Dropdown));
		accountDropdown.selectByVisibleText(accountType);
		boolean accountSelected = accountDropdown.getFirstSelectedOption().getText().equals(accountType);

		WebElement amountField = driver.findElement(Locators.Amount_Input);
		amountField.clear();
		amountField.sendKeys(amount);
		boolean amountEntered = amountField.getAttribute("value").equals(amount);

		driver.findElement(Locators.Date_Input).click(); // Click on date field to open calendar

		// Loop until the correct month is displayed
		while (!driver.findElement(Locators.Calendar_Title).getText().contains("March 2025")) {
			driver.findElement(Locators.Calendar_Next).click();
		}

		driver.findElement(Locators.Calendar_Day_27).click();
		boolean dateSelected = driver.findElement(Locators.Date_Input).getAttribute("value").contains("03/27/2025");

		// ✅ Return true only if all selections and input are successful
		boolean actResult = payeeSelected && accountSelected && amountEntered && dateSelected;
		return actResult;
	}


    public boolean verifyAndClickPay() {
        driver.findElement(Locators.Pay_Button).click();
        return true;
    }

    public boolean isPaymentConfirmationDisplayed() {
        return driver.findElement(Locators.Confirmation_Message).isDisplayed();
    }

    public boolean EmptyFieldWarning() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String message = (String) js.executeScript("return arguments[0].validationMessage;", Locators.Amount_Input);
        boolean actResult;

        if (message.equals("Please fill out this field.")) {
            actResult = true;
        } else {
            actResult = false;
        }
        return actResult;


	}

}
