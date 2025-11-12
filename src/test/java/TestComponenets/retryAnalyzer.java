package TestComponenets;

import org.testng.ITestResult;

public class retryAnalyzer implements org.testng.IRetryAnalyzer{

int count = 0;
int maxTry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxTry){
            count++;
            return true;    //will rerun the count untill maxtry
        }
        return false;
    }
}
