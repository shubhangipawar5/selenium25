package e2e;

public class mavencommands {
    //run test scripts with maven command in ci/cd
    //to run test from terminal we first have to get the Maven installed to support maven commands  -> https://maven.apache.org/download.cgi
    //and set he maven homepath in system variables
    //direct trigger tc with command is not possible so we have to get a plugin - maven testng integration plugin -> https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
//Surefire Plugin

//     <suiteXmlFile>testSuites/testng.xml</suiteXmlFile>    <!-- testSuite path --> in the pom.xml

    //so we have to create profiles in pom.xml to create different test suites for run on maven commands and pass that test suit name on terminal
    // command - shubhangi.pawar@MAC-509FQ2T selenium25 % mvn test -P login
    //so here login is the id of profile and P is for passing profile from pom.xml


    //Let's set Global values from maven command in properties file

    //let's pass set browser value from maven command

    //shubhangi.pawar@MAC-509FQ2T selenium25 % mvn test -D browser=Firefox
    //D is for passing parameters from maven command  - D stands for maven parameter
}
