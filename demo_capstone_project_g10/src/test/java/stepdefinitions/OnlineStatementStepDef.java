package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnlineBookingPage;
import pages.OnlineStatementPage;
import utils.Base;

public class OnlineStatementStepDef {
	WebDriver driver = Base.driver;
	OnlineBookingPage onlinebooking;
	
	OnlineStatementPage onlineStatementPage = new OnlineStatementPage(driver);
	String projectDownloadFolder = System.getProperty("user.dir") + "\\download";

	@When("user clicks on online statements")
	public void user_clicks_on_online_statements() {
		boolean result = onlineStatementPage.clickOnlineStatements();
	    Assert.assertTrue(result);
	}

	@When("user selects the account type and selects the year")
	public void user_selects_the_account_type_and_selects_the_year() {
		boolean result = onlineStatementPage.selectAccountType();
		boolean yearResult = onlineStatementPage.selectYear();
		
		Assert.assertTrue(result);
		Assert.assertTrue(yearResult);
	}

	@When("user clicks on statement link")
	public void user_clicks_on_statement_link() {
		boolean result = onlineStatementPage.clickStatementDownloadLink();
		Assert.assertTrue(result);
	}
	
	@Then("user verifies the file is downloaded")
	public void user_verifies_the_file_is_downloaded() {
		boolean result = onlineStatementPage.verifyStatement();
//		boolean result = onlineStatementPage.waitForNewPDFDownload(projectDownloadFolder,20);
		Assert.assertTrue(result);
	}

}
