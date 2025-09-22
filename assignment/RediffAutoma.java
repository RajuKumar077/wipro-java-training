package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RediffAutoma {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(1200);

		// Filling name
		driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys("Raju Kumar");
		Thread.sleep(1200);

		// filling Mail
		driver.findElement(By.xpath("//input[contains(@name, 'login')]")).sendKeys("rajukumardalimss12");
		Thread.sleep(1200);

		// filling Password
		driver.findElement(By.xpath("//input[contains(@id, 'newpasswd')]")).sendKeys("12342");
		Thread.sleep(1200);

		// filling Retype - Password
		driver.findElement(By.xpath("//input[contains(@id, 'newpasswd1')]")).sendKeys("12342");
		Thread.sleep(1200);

		// filling Alternate Mail
		driver.findElement(By.xpath("//input[contains(@name, 'altemail')]")).sendKeys("rajuwipro46@gmail.com");
		Thread.sleep(1200);

		// filling Mobile Number
		driver.findElement(By.xpath("//input[contains(@name, 'mobno')]")).sendKeys("9661760718");
		Thread.sleep(1200);

		// filling Day DropDown
		WebElement dayDropdown = driver.findElement(By.xpath("//select[contains(@name, 'DOB_Day')]"));

		// Create a Select object for the dropdown
		Select selectDay = new Select(dayDropdown);

		// Select the day by visible text 16
		selectDay.selectByVisibleText("16");

		// filling Month DropDown
		WebElement MonthDropdown = driver.findElement(By.xpath("//select[contains(@name, 'DOB_Month')]"));

		// Create a Select object for the dropdown
		Select selectMonth = new Select(MonthDropdown);

		// Select the Month by Index 3
		selectMonth.selectByIndex(3);

		// filling Year DropDown
		WebElement YearDropdown = driver.findElement(By.xpath("//select[contains(@name, 'DOB_Year')]"));

		// Create a Select object for the dropdown
		Select selectYear = new Select(YearDropdown);

		// Select the Year by Value
		selectYear.selectByValue("2001");

		// Locate the radio button using its name and value, then click it
		driver.findElement(By.xpath("//input[contains(@name,'gender') and @value='m']")).click();
		Thread.sleep(1200);

		// filling Country DropDown
		WebElement Country = driver.findElement(By.xpath("//select[contains(@name, 'country')]"));

		// Create a Select object for the dropdown
		Select selectCountry = new Select(Country);

		// Select the Country by index = 0 (INDIA)
		selectCountry.selectByIndex(0);

		// filling Country DropDown
		WebElement City = driver.findElement(By.xpath("//select[contains(@name, 'city')]"));

		// Create a Select object for the dropdown
		Select selectCity = new Select(City);

		// Select the City by Value
		selectCity.selectByValue("Varanasi");

		driver.findElement(By.className("captcha")).sendKeys("HAHAHAH...");
		Thread.sleep(12000);

	}

	@Test
	public void f() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
