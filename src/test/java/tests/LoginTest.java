package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Log4j2
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Login test", priority = 1)
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
