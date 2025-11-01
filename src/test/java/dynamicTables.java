import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v136.audits.model.SRIMessageSignatureError;

import java.util.List;
import java.util.stream.Collectors;


//https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/

public class dynamicTables {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /*

        List< WebElement > tdData = driver.findElements(By.xpath("(//table[@id=\"product\"])[1]//tr[2]/td"));
        for(WebElement el: tdData){
            System.out.println(el.getText());
        }

        //dynamic index use with for loop
        for(int i=1; i<=tdData.size(); i++){
            WebElement dynamicElText =driver.findElement(By.xpath("(//table[@id='product'])[1]//tr[2]/td[" + i + "]"));

            System.out.println(dynamicElText.getText());
        }

     */

        //JAVA streams by java 8 , optimized code for webtables  //so instead of looping as above we can optimize the code here
        List< WebElement > tdData = driver.findElements(By.xpath("(//table[@id=\"product\"])[1]//tr[2]/td"));

        List<String> tdlsitText = tdData.stream().map(s->s.getText()).collect(Collectors.toList());
        System.out.println(tdlsitText);
        List<WebElement> table2City = driver.findElements(By.xpath("(//table[@id='product'])[2]//tr/td[3]"));

        List<String> amounts = table2City.stream()
                .filter(s -> s.getText().contains("Chennai"))  //if city is chennai collect the amount then take a folowing sibling of table
                .map(s->s.findElement(By.xpath("./following-sibling::td[1]")).getText()).collect(Collectors.toList());



        System.out.println(amounts);
        driver.quit();




    }


}
