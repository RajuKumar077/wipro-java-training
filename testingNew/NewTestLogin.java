package testingNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTestLogin  {
  @Test
  public void testLogin() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		
		String actResult = driver.findElement(By.className("title")).getText();
		
		Assert.assertEquals(actResult, "Products");
		
		
		
	    Thread.sleep(2000);
		driver.close();
  }
  
	
}
