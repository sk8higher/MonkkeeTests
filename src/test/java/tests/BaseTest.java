package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.driverfactory.DriverFactory;

public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        driver = DriverFactory.getDriver(browser);
    }

    @AfterTest
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
