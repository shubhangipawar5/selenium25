package TestComponenets;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExternalReportNG;

import java.io.IOException;


public class testngListeners extends BaseTest implements ITestListener {
    //implements Itest lisners/

//    interface provideby Testng - gives some methods you can implement
//before running any Testnge test controle will first execute this listners


    ExtentReports extent = ExternalReportNG.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();   //saving thread safe which does not overides the test

    public testngListeners() throws IOException {
    }


    @Override
    public void onTestStart(ITestResult result) {   //here tghis result parameter holds the evry info about that test , so from that rsult parameter we can get the test name below
        ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);  //keeps unique thread id of executing test for error alidation test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS,result.getMethod().getMethodName()+ ": test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        //so screenshot code we can write here
        test.log(Status.FAIL, result.getMethod().getMethodName() + ": test Failed");
        extentTest.get().fail(result.getThrowable());
        String sspath;
        try {
            sspath = getScreenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(sspath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        test.log(Status.SKIP,result.getMethod().getMethodName()+ ": test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
