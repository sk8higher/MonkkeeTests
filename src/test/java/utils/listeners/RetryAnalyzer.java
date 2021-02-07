package utils.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;

    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            retryCount++;
            log.warn("Retrying Test method : " + result.getName() + " for " + retryCount + " times. ");
            return true;
        }
        return false;
    }
}