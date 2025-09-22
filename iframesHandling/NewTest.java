package iframesHandling;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @Test(priority = -1)
    public void atest() {
        System.out.println("a");
	       Assert.assertEquals("Selenium", "Sele");
        System.out.println("After Assert");
    }

    
    @Test(dataProvider = "dp", priority = 1)  
    public void fd(Integer n, String s) {
        System.out.println("Test Method - DataProvider values: " + n + ", " + s);
    }

    @Test(dataProvider = "dp")
    public void f(Integer n, String s) {
        System.out.println("Test Method - DataProvider values: " + n + ", " + s);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { 1, "a" },
            new Object[] { 2, "b" },
        };
    }
}
