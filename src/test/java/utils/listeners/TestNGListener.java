package utils.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

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

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();

            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();

                log.info("The number of passed tests for suite '" + suiteName +
                        "' is: " + tc.getPassedTests().getAllResults().size());

                log.info("The number of failed tests for suite '" + suiteName +
                        "' is: " + tc.getFailedTests().getAllResults().size());

                log.info("The number of skipped tests for suite '" + suiteName +
                        "' is: " + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}