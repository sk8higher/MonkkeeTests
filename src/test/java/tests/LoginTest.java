package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

@Log4j2
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://my.monkkee.com/#/");

        log.info("Opened the page");
    }

    @Test(description = "Login test", priority = 0)
    public void loginTest() {
        loginPage = new LoginPage(driver);

        loginPage.enterUsername()
                .enterPassword()
                .login()
                .checkDonationAlert();

        log.info("Tried to log in");

        Assert.assertEquals(driver.getCurrentUrl(), "https://my.monkkee.com/#/entries");
    }
}
