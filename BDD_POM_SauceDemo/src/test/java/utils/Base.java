package utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    public static WebDriver driver; // Made static so it can be accessed in Hooks

    public static WebDriver launchBrowser() {
        // Read properties from the configuration file
        Properties prop = PropertyReader.readProperty();
        // Get the browser name from the properties file
        String browser = prop.getProperty("Browser");

        // If the browser property is not set, throw an exception
        if (browser == null) {
            throw new RuntimeException("Browser property is not set in config file.");
        }

        // Initialize WebDriver based on the browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Enter only either chrome, firefox, or edge");
        }

        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the URL specified in the properties file
        driver.get(prop.getProperty("URL"));
        return driver;
    }

    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }
}
