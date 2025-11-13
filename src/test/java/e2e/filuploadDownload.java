package e2e;

import TestComponenets.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class filuploadDownload extends BaseTest {


    public filuploadDownload() throws IOException {
    }
    @BeforeMethod
    public void setup() throws IOException {
        initializeDriver();

    }
    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        Thread.sleep(2000);
//Download file
        driver.findElement((By.cssSelector("#downloadButton"))).click();



//File upload
        File file = new File("/Users/shubhangi.pawar/Downloads/download.xlsx");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(d -> file.exists());
//          driver.findElement((By.cssSelector("input[type='file']"))).click();
        driver.findElement((By.cssSelector("input[type='file']"))).sendKeys(file.getAbsolutePath());

        //validate upload popup
        WebElement toast  = driver.findElement(By.cssSelector(".Toastify"));
        Assert.assertTrue(toast.isDisplayed(),"Toast is not displayed");

    }

}
