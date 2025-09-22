package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CustomerInfoPage;
import pages.LogOffPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderStepDef {
	WebDriver driver = Hooks.driver; // Ensure Hooks.driver is initialized
	ExtentTest test = Hooks.test;

	LoginPage loginPage;
	ProductListPage productListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	CustomerInfoPage customerInfoPage;
	LogOffPage logOffPage ;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage(driver, test);
		boolean actResult = loginPage.validateURL();
		Assert.assertTrue("Login page URL validation failed", actResult);
	}

	@When("user enters username {string} and password {string} and click login button")
	public void user_enters_username_and_password_and_click_login_button(String userName, String password) {
		boolean actResult = loginPage.validateLogin(userName, password);
		Assert.assertTrue("Login failed", actResult);
	}

	@When("user selects the product")
	public void user_selects_the_product() {
		productListPage = new ProductListPage(driver, test);
		boolean actResult = productListPage.selectProduct();
		Assert.assertTrue("Product selection failed", actResult);
	}

	@When("user clicks add to cart button")
	public void user_clicks_add_to_cart_button() {
		cartPage = new CartPage(driver, test);
		boolean actResult = cartPage.addToCart();
		Assert.assertTrue(actResult);
	}

	@When("user clicks cart button")
	public void user_clicks_cart_button() {
		checkoutPage = new CheckoutPage(driver, test);
		boolean actResult = checkoutPage.goToCart();
		Assert.assertTrue(actResult);

	}

	@When("user clicks checkout button")
	public void user_clicks_checkout_button() {
		checkoutPage = new CheckoutPage(driver, test); 
		boolean actResultSecond = checkoutPage.clickCheckout();
		Assert.assertTrue(actResultSecond);
	}


  @When("user enter user information {string}, {string}, and {string} and click continue button")
public void user_enter_user_information_and_click_continue_button(String firstName, String lastName, String postalCode) {
    customerInfoPage = new CustomerInfoPage(driver, test);
    boolean actResult = customerInfoPage.fillingData(firstName, lastName, postalCode);
    Assert.assertTrue("User info entry failed", actResult);
}


	@Then("user verifies product information and click Finish button")
	public void user_verifies_product_information_and_click_finish_button() {
		customerInfoPage = new CustomerInfoPage(driver, test);
		boolean actResult = customerInfoPage.nextcontinue();
		Assert.assertTrue(actResult);
	}

	@Then("user verifies checkout complete message")
	public void user_verifies_checkout_complete_message() {
		logOffPage = new LogOffPage(driver, test);
		boolean actResult = logOffPage.logoffSite();
		Assert.assertTrue(actResult);
	}

	@Then("user logout")
	public void user_logout() {
		logOffPage = new LogOffPage(driver, test);
		boolean actResult = logOffPage.logOffConfirm();
		Assert.assertTrue(actResult);
	}
}
