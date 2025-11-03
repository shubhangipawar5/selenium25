import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsexecute {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
//execute js script to scroll browser webpage in selenium as borwsers are js bases code now a days
        //when we are running selenium headless mode we need js executor to scro;;


        JavascriptExecutor js = (JavascriptExecutor) driver;

// Scroll the window of the page
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

// Scroll the table on the page
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");


    }
}
