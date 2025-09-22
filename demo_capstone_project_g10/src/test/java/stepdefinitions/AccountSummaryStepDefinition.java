package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSummaryPage;
import pages.HomePage;
import utils.Base;

public class AccountSummaryStepDefinition {

	WebDriver driver = Base.driver; // Accessing WebDriver from Base class
	AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver); // Initialize once
	HomePage homepage = new HomePage(driver);

	@When("user clicks on online banking")
	public void user_clicks_on_online_banking() {
		boolean actResult = homepage.OnlineBanking();
		Assert.assertTrue("Online banking validation failed", actResult);
	}

	@When("user clicks on account summary")
	public void user_clicks_on_account_summary() {
		boolean actResult = accountSummaryPage.clickAccountSummaryLink();
		Assert.assertTrue("Account summary validation failed", actResult);
	}

	@Then("user validates account types")
	public void user_validates_account_types() {
		boolean cashAccountsVisible = accountSummaryPage.isCashAccountsVisible();
		boolean investmentAccountsVisible = accountSummaryPage.isInvestmentAccountsVisible();
		boolean creditAccountsVisible = accountSummaryPage.isCreditAccountsVisible();
		boolean loanAccountsVisible = accountSummaryPage.isLoanAccountsVisible();
		Assert.assertTrue("Cash accounts validation failed", cashAccountsVisible);
		Assert.assertTrue("Investment accounts validation failed", investmentAccountsVisible);
		Assert.assertTrue("Credit accounts validation failed", creditAccountsVisible);
		Assert.assertTrue("Loan accounts validation failed", loanAccountsVisible);
	}

}