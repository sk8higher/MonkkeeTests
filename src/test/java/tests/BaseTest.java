package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.driverfactory.DriverFactory;

@Log4j2
public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void beforeTest(String browser) {
        driver = DriverFactory.getDriver(browser);

        log.info("Initialized " + browser);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://my.monkkee.com/#/");

        log.info("Opened the page");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();

            log.info("Exited browser");
        }
    }
}
