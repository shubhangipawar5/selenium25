import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class frames {
    public static void main(String args[]) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //take a screenshot of an element -
        // https://www.selenium.dev/documentation/webdriver/interactions/windows/
        //https://www.toolsqa.com/selenium-webdriver/screenshot-in-selenium/
        WebElement element = driver.findElement(By.xpath("//img[@class=\"logoClass\"]"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));

        //Handle frames

        //https://www.selenium.dev/documentation/webdriver/interactions/frames/
        //https://www.toolsqa.com/selenium-webdriver/handling-iframes-using-selenium-webdriver/

        // we can switch to iframe with - index, name, by element

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id=\"courses-iframe\"]"));
        driver.switchTo().frame(iframe1);
//        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"social-icon-one\"]")).isSelected(),"otherwise iframe not switched");

        //leave frame
        driver.switchTo().defaultContent();




        driver.quit();
    }
}
