package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  
        glue = "stepDefinition", // Match your package name correctly
        plugin = {
                "pretty",
                "html:reports/HTMLReports.html", // HTML report
                "json:reports/json_report.json", // JSON report
                "junit:reports/junit_report.xml" // JUnit XML report
        }
)
public class TestRunner {
}
