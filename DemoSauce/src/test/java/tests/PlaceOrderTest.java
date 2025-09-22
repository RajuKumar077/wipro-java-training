package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CustomerInfoPage;
import pages.LogOffPage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.Base;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlaceOrderTest extends Base {

	ExtentSparkReporter spark;
	ExtentReports extReports;
	ExtentTest test;

	@BeforeClass
	public void setUpReports() {
		spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@AfterClass
	public void writeReport() {
		extReports.flush();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}

	// Define the Data Provider
	@DataProvider(name = "customerData")
	public Object[][] getCustomerData() {
		return new Object[][] { { "standard_user", "secret_sauce", "Raju", "Kumar", "841426" },

		};
	}

	// Modify the test to accept data from the provider
	@Test(dataProvider = "customerData")
	public void testPlaceOrder(String username, String password, String firstName, String lastName, String postalCode) {

		// Create test case in Extent Report
		test = extReports.createTest("Place Order for " + firstName + " " + lastName);

		// Login Step
		LoginPage loginPage = new LoginPage(driver, test);
		loginPage.validateLogin(username, password);

		// Select product
		ProductListPage prodListPage = new ProductListPage(driver, test);
		prodListPage.selectProduct();

		// Add to cart
		CartPage cartProd = new CartPage(driver, test);
		cartProd.addToCart();

		// Checkout
		CheckoutPage checkOut = new CheckoutPage(driver, test);
		checkOut.goToCart();
		checkOut.clickCheckout();

		// Customer Info Page (Passing data from Data Provider)
		CustomerInfoPage customerInfoPage = new CustomerInfoPage(driver, test);
		customerInfoPage.fillingData(firstName, lastName, postalCode);
		customerInfoPage.nextcontinue();

		// Log-off page
		LogOffPage logoff = new LogOffPage(driver, test);
		logoff.logoffSite();
		logoff.logOffConfirm();
	}

	@AfterMethod
	public void tearDown() {
		Base.sleep(4000);
		driver.quit();
	}
}
