package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddNewPayeePage;
import pages.OnlineBookingPage;
import pages.PayBillPage;
import utils.Base;

public class PayBillStepDefinition {
	WebDriver driver = Base.driver; // Accessing WebDriver from Base class
	PayBillPage payBillPage;
	AddNewPayeePage addNewPayeePage;
	OnlineBookingPage onlinebooking;

	@When("user clicks on pay bill")
	public void user_clicks_on_pay_bill() {
		onlinebooking = new OnlineBookingPage(driver);
		boolean actResult = onlinebooking.Paybills();
		Assert.assertTrue(actResult);
	}

	@When("user selects payee and select account and enters the {string} to transfer then selects date")
	public void user_selects_payee_and_select_account_and_enters_the_to_transfer_then_selects_date(String amount) {
		boolean actResult = payBillPage.completePayBillProcess("Apple", "Checking", amount);
		Assert.assertTrue(
				"Payment process failed: Payee selection, account selection, amount entry, or date selection might have an issue.",
				actResult);

	}

	@Then("user verifies the details and click pay")
	public void user_verifies_the_details_and_click_pay() {
		payBillPage = new PayBillPage(driver);
		boolean paymentSuccess = payBillPage.verifyAndClickPay();
		Assert.assertTrue("Payment submission failed or confirmation message not found.", paymentSuccess);
	}

	@Then("user verifies that The payment was successfully submitted is displayed")
	public void user_verifies_that_the_payment_was_successfully_submitted_is_displayed() {
		payBillPage = new PayBillPage(driver);
		boolean confirmationDisplayed = payBillPage.isPaymentConfirmationDisplayed();
		Assert.assertTrue("Payment confirmation message was not displayed.", confirmationDisplayed);
	}

	@When("user clicks on Add New Payee")
	public void user_clicks_on_add_new_payee() {
		addNewPayeePage = new AddNewPayeePage(driver);
		boolean clicked = addNewPayeePage.clickAddNewPayee();
		Assert.assertTrue("Failed to click on Add New Payee.", clicked);
	}

	@When("user enters the {string} and {string} and {string} and clicks add")
	public void user_enters_the_and_and_and_clicks_add(String name, String address, String account) {
		addNewPayeePage = new AddNewPayeePage(driver);
		boolean detailsEntered = addNewPayeePage.enterPayeeDetails(name, address, account);
		Assert.assertTrue("Failed to enter payee details and add payee.", detailsEntered);
	}

	@Then("user verifies that The new payee {string} was successfully created is displayed")
	public void user_verifies_that_the_new_payee_was_successfully_created_is_displayed(String payeeName) {
	     addNewPayeePage = new AddNewPayeePage(driver);
	    boolean isPayeeAdded = addNewPayeePage.verifyPayeeAdded(payeeName);

	    Assert.assertTrue("Payee creation confirmation message not found!", isPayeeAdded);
	}

}
