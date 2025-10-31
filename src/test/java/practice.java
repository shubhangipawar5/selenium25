import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

public class practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement seleEl = driver.findElement(By.id("dropdown-class-example"));
        Select stdd = new Select(seleEl);
        stdd.selectByIndex(1);
        Thread.sleep(5000);
        String selop = stdd.getFirstSelectedOption().getText();
        System.out.println(
                "selected first option is :" + selop
        );
        stdd.selectByVisibleText("Option2");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id=\"dropdown-class-example\"]/option"));
        for(WebElement opel: options){
            String text = opel.getText();

            if(text.equals("Option3")){
                System.out.println("Found Option3");
                opel.click();
                Assert.assertTrue(opel.isSelected());   // op - Found Option3
            }
        }
    }
}
