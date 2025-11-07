package e2e;

import TestComponenets.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjects.landingaPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class e2eTestngtest extends BaseTest {

    public e2eTestngtest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {

        WebDriverManager.chromedriver().setup();
        initializeDriver();   // ✅ initializes class-level driver
        launchApp();          // ✅ driver now exists
    }
    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
    @Test(dataProvider = "getJsonData")
    public void sampleTest(HashMap<String, String> input) throws IOException {
        landingaPage land = new landingaPage(driver);

        String username = input.get("email");
        String password = input.get("password");

        land.login(username, password);

        System.out.println("Title: " + driver.getTitle());
        getScreenShot();
    }

    @DataProvider(name = "getJsonData")
    public Object[][] getJsonData() throws IOException {
        List<HashMap<String, String>> dataList = getLoginData();
        Object[][] data = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }

        return data;

    }


//    @DataProvider
//    public Object [][] getJsonData() throws IOException {
//        //we can send data with HashMap also
//        List<HashMap<String, String>> data = getLoginData();
//        return new Object[][] {{data.get(0), data.get(1)}};
//
//    }


}