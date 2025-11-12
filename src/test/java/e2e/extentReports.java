package e2e;

import TestComponenets.BaseTest;
import TestComponenets.retryAnalyzer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class extentReports extends BaseTest

{
    public extentReports() throws IOException {
    }

    @BeforeMethod
    public void setup() throws IOException {

        WebDriverManager.chromedriver().setup();
        initializeDriver();   // ✅ initializes class-level driver
        launchApp();          // ✅ driver now exists
    }

    @Test
    public void test1()
    {
        System.out.println("Test 1");
    }
    @Test(retryAnalyzer = retryAnalyzer.class)  //retries the tests case for flaky cases  //no need to add this group in xml it automatically identifies and retries
    public void test2()
    {
       String title =  driver.getTitle();
        Assert.assertTrue(title.contains("AutPracticeomation ") , "Title is not Automation Practice");
        driver.quit();
    }
}
