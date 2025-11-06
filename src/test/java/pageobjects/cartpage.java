package pageobjects;

import common.reusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class cartpage extends reusableMethods {
    public cartpage(WebDriver driver) {
        super(driver);     //this is a class constructor , so the driver value is set at the time of creating object of class
        this.driver = driver;
        PageFactory.initElements(driver,this);  //uses to intialise the driver
    }

   @FindBy(css=".cart")
   By tostby = By.cssSelector(".cart");

   @FindBy(css=".ng-animating")
   WebElement toastDisAppear;


    @FindBy(css="[routerlink*='cart']")
    WebElement carticon;

    @FindBy(css=".cartSection h3")
    List<WebElement> cartItems;

    @FindBy(xpath  ="//button[text()='Checkout']")
    WebElement checkoutbtn;

    @FindBy(css="[placeholder='Select Country']")
    WebElement countryselect;

    @FindBy(css=".ta-results")
    By countrySlectRes = By.cssSelector(".ta-results");

    @FindBy(css="[class*='list-group-item']")
    By countryselectresultitems = By.cssSelector("[class*='list-group-item']");

    @FindBy(css="span")
    WebElement countryselectresultitemspan;

    @FindBy(css=".action__submit")
    WebElement adressSubmit;

    @FindBy(css=".hero-primary")
    WebElement confirmtextElmnt;









    //Action Methods
    public cartpage waitForToast() throws InterruptedException {
        Thread.sleep(1000);
//        waitForElementToAppear(tostby);
        waitForElementToDisAppear(toastDisAppear);
        return  this;
    }

    public cartpage clickOnCart() throws InterruptedException {
        Thread.sleep(1000);
        carticon.click();
        return  this;
    }

   public boolean cartItemIsPresentorNot(String itemname){
      waitForElementToAppear(tostby);
      boolean cartitemPresent = cartItems.stream().filter(p->p.getText().equalsIgnoreCase(itemname)).findFirst().isPresent();
      return cartitemPresent;
   }

   public cartpage verifyItemincartIsVisible(String itemname){
        boolean cartitempresentStatus = cartItemIsPresentorNot(itemname);
        Assert.assertTrue(cartitempresentStatus,"Cart item is not present");
        return this;
   }

   public cartpage fillAdressForm() throws InterruptedException {
        checkoutbtn.click();
       //payment
       Thread.sleep(2000);
       countryselect.sendKeys("Ind");
//       waitForElementToAppear(countrySlectRes);

       By labelSpan = By.cssSelector("span");

       driver.findElements((By) countryselectresultitems)
               .stream()
               .filter(option -> option.findElement(labelSpan)
                       .getText()
                       .equalsIgnoreCase("India"))
               .findFirst()
               .orElseThrow()
               .click();

       return this;
   }

   public cartpage checkoutAndconfirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        adressSubmit.click();
        Thread.sleep(1000);
        String confirmtext = confirmtextElmnt.getText();
        System.out.println(confirmtext);
       Assert.assertTrue(confirmtext.contains("THANKYOU FOR THE ORDER."),"Confirm text is not present");
        return this;

   }

}



