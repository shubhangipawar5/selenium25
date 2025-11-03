import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;

public class testngdemo3 {
    @Parameters({"URL", "API"})         //we can fetch multiple parameters
    @Test
    public void url(String urlname, String apiurl){
        System.out.println("Hello testing case for  url : "+urlname);   //reads url value from xml
        System.out.println(apiurl);
    }
    @Test
    public void case_pleasure(){
        System.out.println("Hello testing case for pleasure");
    }

    @Test (dependsOnMethods = "case_pleasure", testName = "verify electric car")   //so here first dependant method is executed then after the current method will execute
    public void case_electric(){   //that is a helper attribute, we can have multiple values for single attributes
        System.out.println("Hello testing case for electric");
    }
  @Test (groups = "sanity")
    public void case_xuv(){
        System.out.println("Hello testing case for xuv sanity");
    }
    @Test (groups = "sanity")
    public void honda(){
        System.out.println("Hello testing case for honda sanity");
    }
    @Test (groups = "sanity")
    public void breza(){
        System.out.println("Hello testing case for breza sanity");
    }
    @Test (groups = "sanity")
    public void swift(){
        System.out.println("Hello testing case for swift sanity");
    }
    @Test (enabled = false)  //this will skip the test case from script to execute
    public void case_activa(){
        System.out.println("Hello testing case for activa");
    }

    //dataparameterisation for the multiple set of data / import it

    @Test(dataProvider = "getData")
    public void login(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
    }

    @DataProvider
    public  Object[][] getData(){
        //create the data
        Object[][] data = new Object[3][2];  //3 rows and 2 columns
        //rows - values of username and passeword
        //column - username, password

        data[0][0] = "shubhangi";
        data[0][1] = "<pass1>";
        data[1][0] = "aayu";
        data[1][1] = "<pass2>";
        data[2][0] = "anu";
        data[2][1] = "<pass3>";
        return data;
    }


}
/*
//TestNG Listeners
Lisetns ur test cases and invoke ur method when something has happened/failed
 */