package pageobjects;

import common.reusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingaPage extends reusableMethods {
   WebDriver driver;


    public landingaPage(WebDriver driver) {  //this is a class constructor , so the driver value is set at the time of creating object of class
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver,this);  //uses to intialise the driver
    }

    //PO syntax
//    WebElement username  = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));

//    WebElement password    =  driver.findElement(By.xpath("//input[@id=\"userPassword\"]"));
//    WebElement signinbtn    =  driver.findElement(By.xpath("//input[@id=\"login\"]"));


    // Page Factory fields (avoid calling findElement at field init time)
    @FindBy(id = "userEmail")
    private WebElement username;

    @FindBy(xpath = "//input[@id='userPassword']")  //here we dont pass driver because we are initilising initielements in pagefctory in above class constructor
     WebElement userPassword;

     @FindBy(xpath = "//input[@id=\"login\"]")
     WebElement loginBtn;



     //Action methods in the same class
    public void navigateToLoginPage(){
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    public productaddtocart login(String email, String password){
        username.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
        System.out.println("Login Successful");
        return new productaddtocart(driver);    //here we are returning the other/next Page Object page where our next screen comes after login and this is a page factory syntax

    }
}

