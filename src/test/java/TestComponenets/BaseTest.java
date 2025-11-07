package TestComponenets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.landingaPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;




public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    public BaseTest() throws IOException {
        prop = new Properties();  //to load Global config

        // Load global data properties
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//test//java//resources//globalData.properties");

        prop.load(fis);
    }

    public WebDriver initializeDriver() throws IOException {

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); // ✅ assigns to class-level variable
        }
        // Add other browsers if needed

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public landingaPage launchApp() {
        if (driver == null) {
            throw new IllegalStateException("Driver is null. Did you call initializeDriver() first?");
        }
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        return new landingaPage(driver);
    }

    public List<HashMap<String, String>> getLoginData() throws IOException {
        // Read JSON file as String
        String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir") + "/src/test/java/resources/data.json"),   // pass a path as parameter so utility will be created
                StandardCharsets.UTF_8
        );

        // Deserialize JSON to List<HashMap<String, String>>
        ObjectMapper objectMap = new ObjectMapper();
        List<HashMap<String, String>> data = objectMap.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                }
        );

        return data;
    }


    public void getScreenShot() throws IOException {
      TakesScreenshot ss = (TakesScreenshot)driver;
      File source = ss.getScreenshotAs(OutputType.FILE);
      File myfile = new File(System.getProperty("user.dir")+"/Screenshots/screenshot"+System.currentTimeMillis()+".png");
       FileUtils.copyFile(source,myfile);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
