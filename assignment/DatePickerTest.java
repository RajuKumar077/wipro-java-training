package assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver (Ensure ChromeDriver path is set correctly)
        
        WebDriver driver = new ChromeDriver();

        // Open MakeMyTrip website
        driver.get("https://www.makemytrip.com");
        Thread.sleep(5000); // Wait for the page to load

        // Close login popup if present
        try {
            WebElement closePopup = driver.findElement(By.cssSelector(".popup_close"));
            closePopup.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("No popup found");
        }

        // Click on the departure date field
        WebElement datePicker = driver.findElement(By.xpath("//label[@for='departure']"));
        datePicker.click();
        Thread.sleep(2000);

        // Select a specific date (Example: 10th March 2025)
        WebElement specificDate = driver.findElement(By.xpath("//div[@aria-label='Mon Mar 10 2025']"));
        specificDate.click();
        Thread.sleep(2000);

        driver.quit(); // Close the browser
    }
}
