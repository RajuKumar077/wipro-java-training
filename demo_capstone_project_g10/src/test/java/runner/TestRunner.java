package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/login.feature", // Path to your feature files
    glue = "stepdefinitions", // Package where step definitions are located
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Generates reports
    monochrome = true // Makes console output readable
)
public class TestRunner {
}

