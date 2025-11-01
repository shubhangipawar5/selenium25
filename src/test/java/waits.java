import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.internal.invokers.ExpectedExceptionsHolder;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
// There are two types of waits in Selenium: implicit wait and explicit wait.
// Implicit wait is set for the entire duration of the WebDriver session,applicable globally to all elements,
// while explicit wait is applied only for specific conditions.
//Thread.sleep() is a static wait and is not recommended for production code as it can lead to flaky tests.
//fluent wait is a type of explicit wait that allows you to wait for a certain condition to occur before proceeding.



//https://www.tutorialspoint.com/selenium/selenium_webdriver_explicit_and_implicit_wait.htm
//https://www.toolsqa.com/selenium-webdriver/selenium-wait-commands-implicit-explicit-and-fluent-wait

public class waits {
    public static void main(String[] args) throws InterruptedException {
        // Set up the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // Navigate to the URL

        // Implicit wait // Since it is condition-less, it is applied to all the web elements on the web page when we write driver.findelement()
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10)); // Set implicit wait of 10 seconds
//OR
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait of 10 seconds using Duration class
        // Example of explicit wait (not implemented here, but can be added as needed)
//OR
     //   [we write implicite wait before any element
        //   this wait commands to selenium to wait for a given amount of time before throwing an "No element found" exception
        //   if we have given 2 min. time then if element finds in 3o sec. then it will continue execution and will not wait for the leftover time]

        //OR
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait of 10 seconds using TimeUnit
        Thread.sleep(2000); // Static wait for demonstration purposes
        System.out.println(driver.getTitle()); // Print the title of the page
        System.out.println(driver.getCurrentUrl()); // Print the current URL


        //explicit wait example
        //[this also tell selenium to wait on certion condition before throwing  exception
        //   if we have given 2 min. time then if condition met in 3o sec. then it will continue execution and will not wait for the leftover time]
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Create an explicit wait with a timeout of 10 seconds
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId"))); // Wait until the element is visible
//        element.click(); // Click on the element once it is visible

        //what is fluent wait
        //Fluent wait is a type of explicit wait that allows you to wait for a certain condition to occur before proceeding.
        //ex. if you have given time of 2 min. and frequesncy after ever 5sec. it will check for condition after every 5 sec, in 2 mins.
        // It is more flexible than explicit wait as it allows you to specify the polling interval and
        // the maximum wait time. Fluent wait can be used to handle dynamic elements that may not be immediately available.
        // It allows you to wait for a certain condition to occur before proceeding, with a polling
        // interval to check for the condition at regular intervals until the maximum wait time is reached.
        // can be used for dynamic web elements that may not be immediately available.

        // Example of Fluent Wait (not implemented here, but can be added as needed)
        //FluentWait<WebDriver> wait = new FluentWait<>(driver)

//       Wait wt = new FluentWait(driver)
//                .withTimeout(20, TimeUnit.SECONDS)
//                .pollingEvery(5, TimeUnit.SECONDS) //for every 5 seconds it will moitor the expected behaviour
//                .ignoring(ElementNotInteractableException.class);
//
//        wt.until(ExpectedConditions.titleIs("Tutorialspoint"));

        //example is payment confirmation page which keeps on loading for confirmation message withhh some icon.
        driver.quit(); // Close the browser
    }
}
/*
Types of Selenium Waits
#Implicit Wait in Selenium
implicitlyWait()
pageLoadTimeout()
setScriptTimeout()
#Explicit Wait in Selenium
WebDriverWait
FluentWait
 */