package BasicProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver ;

public class RedBus {

	public static void main(String[] args) {
		WebDriver  driver = new ChromeDriver() ; 
		driver.manage().window().maximize(); //maximize the window size 

		driver.get("https://www.redbus.com/");
		String expectedResult = "Book Bus Tickets Online with redBus!";
		String ActualResult = driver.getTitle();

		if(expectedResult.equals(ActualResult)) {
			System.out.println("Passed");
		}else 
			System.out.println("Failed");

		driver.close();

	}

}
