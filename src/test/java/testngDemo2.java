import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testngDemo2 {
    WebDriver driver;
    @BeforeMethod
    public void prerequisite() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit(); // ends the entire browser session and driver process
            } finally {
                driver = null;
            }
        }
    }
    @Test
    public void case_pleasure(){
        System.out.println("Hello testing case for pleasure");

    }
    @Test
    public void case_electric(){
        System.out.println("Hello testing case for electric");

    }

    @Test
    public void case_xuv(){
        System.out.println("Hello testing case for xuv");
    }

    @Test
    public void case_activa(){
        System.out.println("Hello testing case for activa");

    }

    @Test
    public void red_car(){
        System.out.println("Hello testing case for car");

    }

    @Test
    public void new_car(){
        System.out.println("Hello testing case for car");

    }

    @Test
    public void old_car(){
        System.out.println("Hello testing case for car");

    }

    @Test
    public void recent_car(){
        System.out.println("Hello testing case for car");

    }

    @Test
    public void fav_car(){
        System.out.println("Hello testing case for car");

    }

    @Test
    public void case_car(){
        System.out.println("Hello testing case for car");

    }



}
