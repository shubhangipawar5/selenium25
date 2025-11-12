package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber",      // Path to your feature files
        glue = {"stepdefimplement"},              // ✅ package name, not folder path
        monochrome = true,
        plugin = {"html:target/cucumber.html"},
        tags = "@tag1"
        //report goes under Target folder
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    // Cucumber + TestNG integration
    ////extending to scan our testng code so cucumber can understand the Testng code and inbuild cucumber understands junit code
}
