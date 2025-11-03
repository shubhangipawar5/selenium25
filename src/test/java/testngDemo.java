
//https://testng.org/#_testng_documentation

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
//in testng default test execution order is alphbetic order
public class testngDemo {
    WebDriver driver;
    //we need to write main method here while working with TestNg
    @BeforeSuite   //to setup global environments
    public void setUp() {
        System.out.println("Before suite");
    }
    @AfterSuite
    public void tearDownSuite() {
        System.out.println("After suite");
    }
    @BeforeMethod
    public void prerequisite() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit(); // ends the entire browser session and driver process
            } finally {
                driver = null;
            }
        }
    }


    @Test
    public void case_one(){
        System.out.println("Hello testing case 1");

    }
    @BeforeTest      //this will set priority to this test case , befora all test cases in que this test case will trigger
    public void case_two(){
        System.out.println("i will execute first");   //
        /*
        @BeforeTest

Runs before any <test> tag in your TestNG XML.

Executed once per <test> (not per class or method).

Typically used for setup that applies to a group of classes in that <test> block.
         */

    }

    @AfterTest    //Runs after all test methods in a <test> tag are finished.
    public void case_three(){
        System.out.println("i will execute last"); //to delete the coockies
    }

    @Test
    public void case_four(){
        System.out.println("Hello testing case 4");

    }

    @Test
    public void case_five(){
        System.out.println("Hello testing case 5");

    }



}

/*

🧩 What is a TestNG Suite XML file?

A TestNG suite file (usually named testng.xml) is an XML configuration file that tells TestNG:

Which tests to run

How to run them (order, groups, parameters, etc.)

On which classes or packages

Whether to run tests in parallel

It gives you full control over your test execution, beyond just right-clicking and running one class.

🎯 Why We Create a TestNG XML Suite
1. To Run Multiple Test Classes Together

Instead of running each test manually, you can define them all in one XML file.

<suite name="MyTestSuite">
    <test name="AllTests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.SignUpTest"/>
            <class name="tests.DashboardTest"/>
        </classes>
    </test>
</suite>


➡️ Run the whole suite at once, and TestNG will execute all classes.

2. To Control Test Execution Order

You can define which classes or tests should run first or last.

<classes>
    <class name="tests.LoginTest"/>
    <class name="tests.ProfileTest"/>
</classes>


TestNG runs them in this order.

3. To Group Tests

You can group related tests (e.g., smoke, regression, sanity) and choose which groups to run.

<suite name="GroupedTests">
    <test name="SmokeTests">
        <groups>
            <run>
                <include name="smoke"/>
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.PaymentTest"/>
        </classes>
    </test>
</suite>


In your test classes:

@Test(groups = "smoke")
public void verifyLogin() { ... }

4. To Pass Parameters

You can send parameters (like browser type, URL, etc.) to your tests from XML.

<suite name="ParamSuite">
    <test name="BrowserTest">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.BaseTest"/>
        </classes>
    </test>
</suite>

@Test
@Parameters("browser")
public void launchBrowser(String browser) {
    System.out.println("Browser: " + browser);
}

5. To Run Tests in Parallel

You can configure parallel execution easily.

<suite name="ParallelTests" parallel="classes" thread-count="2">
    <test name="ParallelRun">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.DashboardTest"/>
        </classes>
    </test>
</suite>


➡️ TestNG will run these classes simultaneously in two threads.
//generate xml file
Right-click your project → New → File

Name it: testng.xml

Paste xml template:

//we can have multiple xml files ina asingle project
MyTestNGProject/
│
├── src/
│   └── test/java/tests/
│       ├── LoginTest.java
│       ├── SignupTest.java
│       ├── PaymentTest.java
│       └── ProfileTest.java
│
├── testng-smoke.xml
├── testng-regression.xml
└── testng-master.xml


// pririotise ur test cases
we can give class name in xml files

//include exclude test cases from class


// we can merge all xml file in single master s uites
<suite name="MasterSuite" parallel="false">
    <suite-files>
        <suite-file path="testng-smoke.xml"/>
        <suite-file path="testng-regression.xml"/>
    </suite-files>
</suite>
 */

/*
TestNG annotations are special markers (metadata) in TestNG that you put before methods to define how and when those methods should be executed in your tests. They control the test execution flow, setup, teardown, grouping, dependencies, and more.

Let’s go through them carefully.

1️⃣ Basic TestNG Annotations
Annotation	When It Runs	Description
@Test	During test execution	Marks a method as a test case. You can define priority, groups, expected exceptions, and timeouts.
@BeforeSuite	Before all tests in the suite	Runs once before all tests in the <suite> XML. Useful for global setup (e.g., database, reports).
@AfterSuite	After all tests in the suite	Runs once after all tests. Useful for global cleanup.
@BeforeTest	Before each <test> in XML	Runs before a <test> tag in TestNG XML. Can set up things like test-specific configurations.
@AfterTest	After each <test> in XML	Runs after a <test> tag completes.
@BeforeClass	Before the first method in a class	Runs once per class. Useful for initializing WebDriver or resources specific to a class.
@AfterClass	After all methods in a class	Runs once per class. Used to release resources.
@BeforeMethod	Before each test method	Runs before every @Test method in the class. Good for resetting state before each test.
@AfterMethod	After each test method	Runs after every @Test method. Good for cleanup (e.g., closing browser tabs).
2️⃣ Other Useful Annotations
Annotation	Description
@BeforeGroups	Runs before any methods belonging to a specified group.
@AfterGroups	Runs after all methods belonging to a specified group.
@Parameters	Passes parameters from XML into your test methods.
@DataProvider	Provides data for parameterized tests (runs same test with multiple data sets).
@Factory	Generates multiple test class instances programmatically.
@Listeners	Used to attach listener classes (like for logging, reporting, or test events).
 */