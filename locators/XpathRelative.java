package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathRelative {
	@Test
	public void textRelativeTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/");
		String UserLogin = driver.findElement(By.xpath("//*[@id=\"sec_nav\"]/h5")).getText();
		System.out.println("Result: " + UserLogin);
		
		Assert.assertTrue(UserLogin.contains("LOGIN"));
		
		Thread.sleep(2000);
		driver.close();

	}
}
