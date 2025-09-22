package stepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.Base;

public class Hooks extends Base {

    static ExtentSparkReporter spark;
    static ExtentReports extReports;
    public static ExtentTest test;

    @BeforeAll()
    public static void setUpReports() {
        spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }

    @AfterAll()
    public static void afterAll() {
        extReports.flush();
    }

    @Before()
    public void before() {
        test = extReports.createTest("Place Order");
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
