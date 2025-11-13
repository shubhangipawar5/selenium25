import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/software-engineering/assertion-in-selenium-webdriver-using-testng/
//https://www.browserstack.com/guide/verify-and-assert-in-selenium
//https://testgrid.io/blog/assert-vs-verify-in-selenium/
//AutoIT - https://toolsqa.com/selenium-webdriver/autoit-selenium-webdriver/
public class aeertionDemo {
   public static void main(String[] args) throws InterruptedException {
       //validate attributes
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.makemytrip.com/flights/");
//       Thread.sleep(5000);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class=\"modalMain tcnFooter\"]")));
       driver.findElement(By.xpath("//section[@class=\"modalMain tcnFooter\"]/span")).click();  //closing the dialogbox.

       wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//label[@for=\"fromCity\"]"))));
      // boolean radioStatus = driver.findElement((By.xpath("//li[@data-cy=\"oneWayTrip\"]"))).isSelected();  //is selected sometimes not works in selenium so we can get the attribute and check
        /*  if(radioStatus){

           System.out.println("radio button is selected");
       }
       else {
           driver.findElement((By.xpath("//li[@data-cy=\"oneWayTrip\"]"))).click();
       } */
       //other way
       String attrbt = driver.findElement((By.xpath("(//span[contains(@class, 'tabsCircle')])[1]/ancestor::li"))).getDomAttribute("class");   //again getAttribute is deperecated recently so we are using getDomAttribute.
       System.out.println("status of radio button is: " + attrbt);
      // Assert.assertTrue(true, "Custom failure message");

       boolean isSelected = attrbt != null && attrbt.contains("selected");

// Assertion with custom failure message
       //OR
       Assert.assertTrue(isSelected, "Radio button is not active. Actual class attribute: " + attrbt);   //message will be printed on failure

//OR
       // Assert that the class attribute contains "active"
       Assert.assertTrue(attrbt.contains("selected"), "Expected 'selected' in class attribute, but got: " + attrbt);

       //now click on 2nd radio button
       if(attrbt.contains("selected")){
           WebElement secondRadio = driver.findElement(By.xpath("//ul[contains(@class, \"latoRegular\")]/li[2]"));
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondRadio);
           Thread.sleep(500); // Give it a moment (optional but helpful)

           secondRadio.click();

       }


       //soft assert
       SoftAssert a = new SoftAssert();
//       a.assertEquals(actual,expected);
//execution does not stop- it will store all failures and if u want to assert all and fail script can do  with - a.assertall() at the end of the script
//       drivever.close();
    }
}
