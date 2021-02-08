package utils.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestNGListener implements ITestListener, IReporter {
    @Override
    public void onTestStart(ITestResult result) {
        log.info("The test " + result.getName() + " had started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("The test " + result.getName() + " ended successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("The test " + result.getName() + " had failed");
    }
}