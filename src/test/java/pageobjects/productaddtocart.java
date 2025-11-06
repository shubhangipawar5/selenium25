package pageobjects;

import common.reusableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productaddtocart extends reusableMethods {
    WebDriver driver;

    public productaddtocart(WebDriver driver) {
        super(driver);     //this is a class constructor , so the driver value is set at the time of creating object of class
        this.driver = driver;
        PageFactory.initElements(this.driver,this);  //uses to intialise the driver
    }

    //page factory

    @FindBy(css = ".mb-3")
   List <WebElement> products;
    By productsBy = By.cssSelector(".mb-3");









    //Action Methods

    public List<WebElement> getProducts(){

        waitForElementToAppear(productsBy);  //productsby because we have passed Find BY locator to parent method "waitForElementToAppear" //or we can say we are casting the the type
        //we have not created PO object because we have inheritaed class and this methos we can acces from our inherited parent class
        return products;
    }

    public cartpage getProdAndAddtocart(List<WebElement> products, String prodName){
        WebElement prod =	products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        return new cartpage(driver);
    }

}
