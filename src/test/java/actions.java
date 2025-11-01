import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import javax.swing.*;

//https://www.selenium.dev/documentation/webdriver/actions_api/
//https://www.selenium.dev/documentation/webdriver/actions_api/mouse/
public class actions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        //so to interact with mouse actions we have a Actions class in selenium

        Actions actions = new Actions(driver);
        driver.findElement((By.xpath("//button[@type=\"submit\"]"))).click();
        WebElement accountList = driver.findElement((By.xpath("//div[@id=\"nav-link-accountList\"]")));
        actions.moveToElement(accountList).build().perform();


        //keyboard actions-https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/
//contextClick() is a method in the Actions class used to simulate a right-click

//        Actions actions = new Actionsns(driver);
//        actions.contextClick(accountList).perform(); // right-clicks the element
//
//
//        actions.doubleClick(accountList).perform(); // double-clicks the element



        driver.findElement((By.xpath("//input[@id=\"twotabsearchtextbox\"]"))).sendKeys("Hello");

        //OR   write in caps letter with shift keys
        actions.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")   //HELLO
                .keyUp(Keys.SHIFT)
                .perform();

        //scroll to-https://www.selenium.dev/documentation/webdriver/actions_api/wheel/

       actions.scrollToElement(driver.findElement(By.xpath("//a[@aria-label=\"Amazon US Home\"]"))).perform();

//        actions.scrollToElement(driver.findElement(By.xpath("//a[@aria-label=\"Amazon US Home\"]"))).perform();
    }
}
