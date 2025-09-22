package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnlineBookingPage;
import pages.TransferfundPage;
import utils.Base;

public class FundTransferStepDef {
	WebDriver driver = Base.driver; // Accessing WebDriver from Base class

	OnlineBookingPage onlinebooking;
	TransferfundPage transferfund;

	@When("user clicks on transfer fund")
	public void user_clicks_on_transfer_fund() {
		onlinebooking = new OnlineBookingPage(driver);
		boolean actResult = onlinebooking.transferfund();
		Assert.assertTrue(actResult);

	}

	@When("selects from-account and to-account and enters the {string} to transfer then clicks continue")
	public void selects_from_account_and_to_account_and_enters_the_to_transfer_then_clicks_continue(String Amount) {
		transferfund = new TransferfundPage(driver);
		boolean actResult = transferfund.TransferFund(Amount);
		Assert.assertTrue(actResult);

	}

	@Then("user verifies the details and click submit")
	public void user_verifies_the_details_and_click_submit() {
		transferfund = new TransferfundPage(driver);
		boolean actResult = transferfund.TranferfundInfo();
		Assert.assertTrue(actResult);
	}

	@Then("user verifies that You successfully submitted your transaction is displayed")
	public void user_verifies_that_you_successfully_submitted_your_transaction_is_displayed() {
		transferfund = new TransferfundPage(driver);
		boolean actResult = transferfund.SuccessMessage();
		Assert.assertTrue(actResult);
	}

	@Then("user verifies that please fill out this field is displayed")
	public void user_verifies_that_please_fill_out_this_field_is_displayed() {
		transferfund = new TransferfundPage(driver);
		boolean actResult = transferfund.TransferFundFail();
		Assert.assertTrue(actResult);
	}

}
