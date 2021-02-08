package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.driverfactory.DriverFactory;
import utils.listeners.WebDriverListener;

@Log4j2
public class BaseTest {
    public WebDriver driver;
    public EventFiringWebDriver eventFiringWebDriver;

    @BeforeClass
    @Parameters("browser")
    public void beforeTest(String browser) {
        driver = DriverFactory.getDriver(browser);
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());

        log.info("Initialized " + browser);
    }

    @BeforeMethod
    public void beforeMethod() {
        eventFiringWebDriver.get("https://my.monkkee.com/#/");

        log.info("Opened the page");
    }

    @AfterClass
    public void teardown() {
        if (eventFiringWebDriver != null) {
            eventFiringWebDriver.quit();

            log.info("Exited browser");
        }
    }
}
