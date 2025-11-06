package e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.cartpage;
import pageobjects.landingaPage;
import pageobjects.productaddtocart;

import java.time.Duration;
import java.util.List;
public class addtocartPO {
    public static void main(String[] args) throws InterruptedException {
        String prodName = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        landingaPage landpage = new landingaPage(driver);    //object for PO

        landpage.navigateToLoginPage();
        Thread.sleep(2000);
       //login
/*
        landpage.login("test@rs.com","Test@123"); //this is normal PO script
        productaddtocart products = new productaddtocart(driver);
        List<WebElement> prodlist = products.getProducts();
//        we can see page factoey script below
//to avaoid creating multiple Page objects we are returning the PO pages in the previous methods
/ex- landing page-rturns-productpag -returns-cartpage als we can chain methods from same PO

*/


        productaddtocart productPO = landpage.login("test@rs.com","Test@123");  // here we imported product class to chanin the PO which is returned from the login method from login PO

       //explicite wait and navigates to product page
        List<WebElement> prodlist = productPO.getProducts();
        cartpage cart = productPO.getProdAndAddtocart(prodlist,prodName);   //prodcutpage PO is already by default created on calling login method
//methods chaining from same PO
        cart.waitForToast()
            .clickOnCart()
            .verifyItemincartIsVisible(prodName)
            .fillAdressForm()
            .checkoutAndconfirmOrder();







        driver.quit();

    }
}
