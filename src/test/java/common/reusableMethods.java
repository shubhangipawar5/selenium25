package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class reusableMethods {
    protected WebDriver driver;
    protected final WebDriverWait wait;

    public reusableMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }




    public void waitForElementToAppear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void waitForElementToDisAppear(WebElement locator){
        wait.until(ExpectedConditions.invisibilityOf( locator));
    }

}
