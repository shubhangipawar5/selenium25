import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderUi {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String month = "May";
        String yearNumber = "2021";
        String dayNumber = "15";
        Thread.sleep(2000);
        //click on calender icon
        driver.findElement(By.xpath("//button[@class=\"react-date-picker__calendar-button react-date-picker__button\"]")).click();
        //select calender navigation
        driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__label\"]")).click();
        selectYear(driver,yearNumber);
        selectMonth(driver,month);
        selectDate(driver,dayNumber);
        System.out.println(driver.findElement(By.xpath("//div[@class=\"react-date-picker__inputGroup\"]")).getText());
    }
//Methods are out of main class
    public static void selectYear(WebDriver driver, String targetYear) {
        while (true) {
            String yearNum = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span")).getText();

            int year = Integer.parseInt(yearNum);
            int tarYear = Integer.parseInt(targetYear);
            // ✅ Stop when the target year is visible
            if (year == tarYear) {
                System.out.println("Reached target Year: " + tarYear);
                break;
            }
            WebElement NEXT_BUTTON = driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__arrow react-calendar__navigation__next-button\"]"));
            WebElement PREV_BUTTON = driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__arrow react-calendar__navigation__prev-button\"]"));

            if (year < tarYear) {
                NEXT_BUTTON.click();


            } else {
                PREV_BUTTON.click();

            }
            // Wait briefly for UI update
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public static void selectMonth(WebDriver driver, String ariaLabelmonth) {

// Locate element dynamically
        WebElement monthElement = driver.findElement(
                By.xpath("//abbr[contains(@aria-label,'" + ariaLabelmonth + "')]")
        );

// Click it
        monthElement.click();
        System.out.println("Reached target Month: " + ariaLabelmonth);
    }

    public static void selectDate(WebDriver driver, String expectedDate) {
        driver.findElement((By.xpath("//abbr[text()='"+expectedDate+"']"))).click();
        System.out.println("Reached target Date: " + expectedDate);
    }

}