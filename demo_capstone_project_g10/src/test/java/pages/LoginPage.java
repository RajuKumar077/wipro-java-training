package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;
import utils.Base;

public class LoginPage {
    private WebDriver driver; // WebDriver instance for interacting with the browser
    private WebDriverWait wait; // WebDriverWait instance for waits

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
    }

    // Method to validate if the URL is correct after clicking the sign-in button
    public boolean validateURL() {
        driver.findElement(Locators.signin_button).click(); 
        String currURL = driver.getCurrentUrl(); 
        boolean actResult;

        if (currURL.equals("http://zero.webappsecurity.com/login.html")) { 
            actResult = true;
        } else {
            actResult = false;
        }
        return actResult;
    }

    // Method to validate login functionality with given user name and password
    public boolean LoginEntry(String uname, String pwd) {
        driver.findElement(Locators.user_name).sendKeys(uname); 
        driver.findElement(Locators.user_password).sendKeys(pwd); 
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.submit));
        } catch (TimeoutException te) {
            actResult = false; 
        }

        return actResult;
    }

   
    // Method to validate an invalid login attempt by checking the error alert text
    public boolean validateLogin() {
    	driver.findElement(Locators.submit).click();
    	driver.navigate().back();
    	boolean actResult = true;
        try {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Home));
        } catch (TimeoutException e) {
        	actResult = false; 
        }
        return actResult;
    }
    
 // Method to validate login functionality with given user name and password
    public boolean validateLoginFailure() {
        driver.findElement(Locators.submit).click(); 
        boolean actResult = true;
        try {
        	wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    Locators.invalid_alert, "Login and/or password are wrong."));
        } catch (TimeoutException te) {
            actResult = false; 
        }

        return actResult;
    }
    
    //Method for whole login process
    public boolean LoginProcess(String uname, String pwd) {
        driver.findElement(Locators.user_name).sendKeys(uname); 
        driver.findElement(Locators.user_password).sendKeys(pwd); 
        driver.findElement(Locators.submit).click();
    	driver.navigate().back();
        boolean actResult = true;
        try {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Home));
        } catch (TimeoutException te) {
            actResult = false; 
        }

        return actResult;
    }
    
    
    
  
    
    
    
}