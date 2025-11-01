import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;


//https://www.selenium.dev/documentation/webdriver/interactions/windows/

//https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/


public class windoManage {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//open a new tab


        // Click to open a new tab
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        //Timing issue — new tab isn’t ready yet. Add a short wait:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
// Store parent window ID
        String parentId = driver.getWindowHandle(); //counts all tab id open by selenium and returns the set of ids

// Get all window IDs
        Set<String> allWinIds = driver.getWindowHandles();

        for (String winId : allWinIds) {
            if (!winId.equals(parentId)) {
                driver.switchTo().window(winId);
                break; // switch to the child tab and stop looping
            }
        }

// ✅ Now we are inside the child tab
        System.out.println("Switched to child tab: " + driver.getTitle());

// Wait a bit if needed
        Thread.sleep(2000);

// Perform action on the child tab
        WebElement childTabLogo = driver.findElement(By.xpath("(//a[text()='Courses'])[1]"));
        childTabLogo.click();

// Switch back to parent tab (optional)
        driver.switchTo().window(parentId);
        System.out.println("Back to parent tab: " + driver.getTitle());

//        Assert.assertTrue(childTabLogo.isSelected(),"if not visible then Driver not switched to new tab");

        /*

        String parentId = winIds.iterator().next(); //iterates set and gives windows id with help of next method String childId = winIds.iterator().next(); System.out.println(winIds);
         */
    }
}
