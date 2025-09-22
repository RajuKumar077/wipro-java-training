package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.Base;

public class Hooks extends Base {

	@BeforeAll()
	public static void setUpReports() {

	}

	@AfterAll()
	public static void afterAll() {

	}

	@Before()
	public void before() {

		driver = launchBrowser(); // Ensure driver is initialized here
	}

	@After()
	public void after() {
		sleep(4000);
		if (driver != null) {
			driver.quit();
		}
	}
}
