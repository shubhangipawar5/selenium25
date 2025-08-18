import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//https://www.tutorialspoint.com/selenium/selenium_drop_down.htm
//https://www.toolsqa.com/selenium-webdriver/dropdown-in-selenium/
//
public class dropDownAndCheckboxes {

    public static void main(String[] args) throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://rahulshettyacademy.com/AutomationPractice/");


      //Handling Static Drop Down  // any DD with select tag is static drop down with fixed actions
        // we can use select class to handle static drop down
        //first we have to find the element using By.id or By.name or By.xpath or By.cssSelector and then pass to the select class constructor

        WebElement staticDD1 = driver.findElement(By.id("dropdown-class-example"));

        Select staticDropDown = new Select(staticDD1); //dropdown class is used to handle static drop down
        //selecting by index
        staticDropDown.selectByIndex(1); // this will select the second option in the drop down (index starts from 0)
        Thread.sleep(2000);
        // to check if it is selected or not
        WebElement option1 = staticDropDown.getFirstSelectedOption(); // this will return the text of the first selected option returns single web element
        //if DD is multi selector then we can use getAllSelectedOptions() to get all the selected options which return list of web elements
        System.out.println("Selected option by index: " + option1.getText());

        //select by visible text
        staticDropDown.selectByVisibleText("Option2");

        //select by value, value attribut of element
        staticDropDown.selectByValue("option3");

        //get list of options in the drop down
      staticDropDown.getOptions(); // this will return all the options in the drop down as list of web elements

       // isMultiple()
       // Returns a boolean value, yields a true value if the dropdown allows selection of multiple items.

        // deselect all if multioption DD
        staticDropDown.deselectAll(); // this will deselect all the options in the drop down, but it will not work for static drop down as it is not multi select drop down, it will throw exception

        //deselect
        staticDropDown.deselectByIndex(1); // this will deselect the second option in the drop down
        staticDropDown.deselectByVisibleText("Option2"); // this will deselect the option2 in the drop down
        staticDropDown.deselectByValue("option3"); // this will deselect the option3 in the drop down

//----------------------------------------------//
        //Dynamic Drop Down  // use this site - https://www.makemytrip.com/
        //Dynamic drop down is the one which is not having select tag, it is just a list of options which can be selected by clicking on them
        //we can use click method to select the option from dynamic drop down

        //first we have to click on the drop down to open it, then we can find the element using By.xpath or By.cssSelector and then click on it
            WebElement dynamicDD = driver.findElement(By.id("fromCity"));

            List<WebElement> options = driver.findElements(By.xpath("//ul//li//p[contains(@class,\"blackText\")]")); // this will return all the options in the dynamic drop down as list of web elements
            for (WebElement element : options) {
                System.out.println("Option in dynamic drop down: " + element.getText());
                if (element.getText().equalsIgnoreCase("Delhi")) { // we can use equals , equalcase ignore the case of the text
                    element.click(); // this will click on the option which has text Delhi
                    break; // we can break the loop after finding the option we want to select
                }
            }

//------------------------------------------------Checkbox-----And Radio-----//

        //we can use click method to select the checkbox, and isSelected() method to check if the checkbox is selected or not
        WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
            driver.findElement(By.xpath("radiobutton[value='radio2']")).click(); // this will click on the radio button with value radio2
            checkbox1.click();
            checkbox1.isSelected();

            //isenabled() method to check if the checkbox is enabled or not
        if(checkbox1.isDisplayed() == true){
            System.out.println("Checkbox is displayed and selected: " + checkbox1.isSelected());
        }



















      driver.close();
      driver.quit();
    }
}
