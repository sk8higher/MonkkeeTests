package utils.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.propertyreader.GetProperties;

import java.util.Properties;

@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {
    protected Properties prop = GetProperties.readFile();

    private int retryCount = 0;

    private final int maxRetryCount = Integer.parseInt(prop.getProperty("maxRetryCount"));

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