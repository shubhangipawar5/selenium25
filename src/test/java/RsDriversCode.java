

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;





public class RsDriversCode {





//Invoking Browser

//Chrome - ChromeDriver exten->Methods close get

//Firefox- FirefoxDriver ->methods close get

// WebDriver  close  get

//WebDriver methods + class methods


// Chrome

        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--remote-allow-origins=*");

//        System.setProperty("webdriver.chrome.driver","C:/Users/YourUsername/Downloads/chromedriver.exe");   this is deprecated from version 4.6 of sel. which is now managed by seleniummanager in pom.xml file so no need to set the path here anymore.

//    ChromeDriver driver = new ChromeDriver();
// we can use this as well but it is not recommended because it is not an interface and it uses chromedrivers method which might not be understandable to other drivers like firefox or edge so we implement the WebDriver interface instead.
        // so webdriver all method only be accessible across all browser instances.
        WebDriver driver = new ChromeDriver(options);




//Firefox

    //        System.setProperty("webdriver.gecko.driver","C:/Users/YourUsername/Downloads/chromedriver.exe");

        WebDriver driver1 = new FirefoxDriver();



//Microsoft Edge

//        System.setProperty("webdriver.edge.driver","C:/Users/YourUsername/Downloads/chromedriver.exe");

        WebDriver driver2 = new EdgeDriver();






//        driver.get("https://rahulshettyacademy.com");
//
//        System.out.println(driver.getTitle());
//
//        System.out.println(driver.getCurrentUrl());
//
//        driver.close();

//driver.quit();




















}
/*
With options

If you write:

ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
options.addArguments("--incognito");

driver = new ChromeDriver(options);


→ Chrome will:

Start maximized

Open in Incognito mode

Follow any other instructions you gave it

/******** without options it opens the chrom normal mode
 */