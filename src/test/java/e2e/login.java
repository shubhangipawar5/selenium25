package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class login {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("test@rs.com");
        driver.findElement(By.xpath("//input[@id=\"userPassword\"]")).sendKeys("Test@123");
        driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
        // Wait for the new page to load properly
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod =	products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))));
        wait.until((ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart"))));
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
//        for(WebElement el: cartItems){
//            System.out.println(el.getText());
//        }
        boolean cartitem = cartItems.stream()
                .filter(p -> p.getText().equalsIgnoreCase("ZARA COAT 3"))
                .findFirst()
                .isPresent();

        Assert.assertTrue(cartitem,"Cart item is not present");

        //checkout
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        //payment
        Thread.sleep(2000);
        driver.findElement((By.cssSelector("[placeholder='Select Country']"))).sendKeys("Ind");
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results"))));
        List<WebElement> options = driver.findElements((By.cssSelector("[class*='list-group-item']")));
        options.stream().filter(p->p.findElement(By.cssSelector("span")).getText().equals("India")).findFirst().orElse(null).click();
        //submit
        driver.findElement(By.cssSelector(".action__submit")).click();
        //confirm order
        String confirmtext = driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmtext);
        Assert.assertTrue(confirmtext.contains("THANKYOU FOR THE ORDER."),"Confirm text is not present");

//        driver.quit();
    }

}
