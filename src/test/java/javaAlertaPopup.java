import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class javaAlertaPopup {
    //there is a mechanism in selenium to handle alert popups because they are not part of the DOM
    //we can use switchTo().alert() method to switch to the alert popup and then
    //we can use accept() method to accept the alert popup or dismiss() method to dismiss the alert popup
    //we can also use getText() method to get the text of the alert popup
    //we can also use sendKeys() method to send keys to the alert popup if it is a prompt popup
     //https://www.tutorialspoint.com/selenium/selenium_webdriver_alerts_and_popups.htm
    //https://www.toolsqa.com/selenium-webdriver/alerts-in-selenium/
//https://www.selenium.dev/documentation/webdriver/interactions/
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Handling Alert Popup
        driver.findElement(By.id("alertbtn")).click(); // this will open the alert popup
        Thread.sleep(2000);

        // Switch to alert and accept it
        driver.switchTo().alert().accept(); // this will accept the alert popup

        // Handling Confirm Popup
        driver.findElement(By.id("confirmbtn")).click(); // this will open the confirm popup
        Thread.sleep(2000);

        // Switch to alert and dismiss it
        driver.switchTo().alert().dismiss(); // this will dismiss the confirm popup

        // Handling Prompt Popup
        driver.findElement(By.id("promtbtn")).click(); // this will open the prompt popup
        Thread.sleep(2000);

        // Switch to alert, send keys and accept it
        driver.switchTo().alert().sendKeys("Test Input");
        driver.switchTo().alert().accept(); // this will accept the prompt popup with input

        driver.quit();
    }

}
