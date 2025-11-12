package stepdefimplement;

import TestComponenets.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.landingaPage;

import java.io.IOException;

public class stepdefimplementations extends BaseTest {
    public stepdefimplementations() throws IOException {
    }
    @Given("initialise the driver")
    public void initialise_the_driver() throws IOException {
           initializeDriver();
   }
    landingaPage land = new landingaPage(driver);
   @Given("Navigate to application")
    public void navigate_to_application() throws IOException {
        land = launchApp();
    }

   @When("^user enters login credentials with (.+) and (.+)")
    public void user_enters_login_credentials_with_and(String username, String password) {
       land.login(username,password);
    }

    @Then("validate login successful")
    public void validate_login_successful() {
        String title =  driver.getTitle();
        System.out.println("Title is: " + title);
        assert title.contains("Let's Shop");
    }

}

/* with help of "tidy gherkins"plugin its chrome plugin we can generate step definations easily
#To run the feature file we need Testrunner - creata 1 class file
@Given("^user logs in with \"(.*)\" and \"(.*)\"$"). //for dynamic data coming from feature file
public void user_logs_in_with_credentials(String username, String password) {
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);
}

#otherwise for the direct string it would be like below
@When("^user enters login credentials with (string) and (string)")
 */