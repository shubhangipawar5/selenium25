import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Basic {

    public static void main(String args[]) throws InterruptedException {
// exception//       System.setProperty("webdriver.chrome.driver", "C:\\Users\\YourUsername\\Downloads\\chromedriver.exe");
// now as we have dependency for chrome driver added in pom file No need to add path here
        //webdriver.geecko.driver  for the firefox driver
        //webdriver.edge.driver  for the ms edge driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();    // to maximize the window
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");   //this has inbuilt wait of 5 seconds no need to wait till the page loads
//       // driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); // this has no inbuilt wait so it will not wait till the page loads we have to explicitly wait if needed also if we have to navigate internally to another page we can use this method  ex- driver.navigate().to("facebook.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //findelements will return you the list

//        List<WebElement> options = driver.findElements(By.cssSelector("input[type='checkbox']")); // this will return all the checkboxes in the page
//          options[0].click(); // this will click on the first checkbox
//        driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).click(); // this will click on the first checkbox

        driver.findElement(By.partialLinkText("Material")).click();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.close();   //closes the current window of browser
        driver.quit();    // closes all the windows of browser

    }






}


// adding implicit wait of 10 secs
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/*
To verify if an element is available on a web page, we can take the help of the isDisplayed() method. If the element is available, isDisplayed() would return true, else false.
To verify if an element is selected on a web page, we can take the help of the isSelected() method. If the element is selected, isSelected() would return true, else false.
To verify if an element is enabled on a web page, we can take the help of the isEnabled() method. If the element is enabled, isEnabled() would return true, else false.
To get the tag name of an element, we can take the help of the getTagName() method.
To get the x, and y coordinates of an element, we can take the help of the getRect() method.
To get the background-color, or color of an element, we can take the help of the getCssValue() method.
To fetch runtime value of the element associated with DOM we can take the help of the getAttribute() method and pass value as a parameter to that method.
ex. ddriver.findElement(By.id("email")).getAttribute("value"); // this will return the value of the email field
To get the text of an element, we can take the help of the getText() method.
/--all web elements commands-----///
https://www.toolsqa.com/selenium-webdriver/webelement-commands/
 */

//---------switch to window-----//
//https://www.tutorialspoint.com/selenium/selenium_webdriver_browser_commands.htm

// To switch to a new window, we can use the switchTo().window() method and pass the window handle as a parameter.
//ex. driver.switchTo().window(windowHandle); // where windowHandle is the handle of the new window we want to switch to.


