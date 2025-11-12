package resources;

import com.aventstack.extentreports.AbstractProcessor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExternalReportNG {

    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report");
        reporter.config().setDocumentTitle("Rahul's Academy Reports");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA", "Test Results");

        return extent;
    }

}
