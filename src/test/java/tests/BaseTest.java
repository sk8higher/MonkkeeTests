package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.driverfactory.DriverFactory;

@Log4j2
public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        driver = DriverFactory.getDriver(browser);

        log.info("Initialized " + browser);
    }

    @AfterTest
    public void teardown() {
        if(driver != null) {
            driver.quit();

            log.info("Exited browser");
        }
    }
}
