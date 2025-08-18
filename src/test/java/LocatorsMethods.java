import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorsMethods {

    public static void main(String[] args) throws InterruptedException {

         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize(); // to maximize the window
         driver.get("https://courses.rahulshettyacademy.com/");
         Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login')]"))
//        //ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Login"))
        );
        loginLink.click();

                Thread.sleep(2000);


        driver.findElement(By.xpath("//a[contains(text(),\"log in with a password\")]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("shubhangi5693@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        driver.findElement(By.name("commit")).click();  // by name attribute
        Thread.sleep(2000);
        String eltxt = driver.findElement(By.xpath("(//h3)[1]")).getText();
        Assert.assertEquals(eltxt, "My library");
        driver.findElement(By.linkText("Browse products")).click();

        driver.quit();


//        driver.findElement(By.className(""));
//        (//h3)[1]/parent::div   can be used for parent
//        ul[@data-orientation="horizontal"]/li        child of ul is li
//        (//ul[@data-orientation="horizontal"]/li)[1]/following-sibling::li      - to get the all sibling of firslt li
//        driver.findElement(By.cssSelector(""));
//
//        driver.findElement(By.tagName(""));


         

    }
}
