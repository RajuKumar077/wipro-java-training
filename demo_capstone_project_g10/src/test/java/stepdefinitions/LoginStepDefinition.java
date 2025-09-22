package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectrepository.Locators;
import pages.HomePage;
import pages.LoginPage;
import utils.Base;

public class LoginStepDefinition {
	WebDriver driver = Base.driver; // Accessing WebDriver from Base class

	LoginPage loginPage;
	HomePage homepage;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.validateURL();
		Assert.assertTrue(actResult);
	}

	@When("user enters login credentials {string} and {string} and click sign-in button")
	public void user_enters_login_credentials_and_and_click_sign_in_button(String username, String password) {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.LoginEntry(username, password);
		Assert.assertTrue(actResult);

	}

	@Then("user verifies that the user is redirected to the account summary page")
	public void user_verifies_that_the_user_is_redirected_to_the_account_summary_page() {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.validateLogin();
		Assert.assertTrue(actResult);
	}

	@Then("user validates that error message Login and\\/or password are wrong is displayed")
	public void user_validates_that_error_message_login_and_or_password_are_wrong_is_displayed() {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.validateLoginFailure();
		Assert.assertTrue(actResult);
	}

	@When("user click sign-in button")
	public void user_click_sign_in_button() {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.validateLoginFailure();
		Assert.assertTrue(actResult); 
	}
	
	@When("user enters login credentials {string} and {string} and click sign-in")
	public void user_enters_login_credentials_and_and_click_sign_in(String username, String password) {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.LoginProcess(username, password);
		Assert.assertTrue(actResult);
	   
	}


}
