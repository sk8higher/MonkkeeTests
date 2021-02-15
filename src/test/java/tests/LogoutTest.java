package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import pages.LoginPage;

@Log4j2
public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private EntriesPage entriesPage;

    @Test(description = "Try to logout", groups = {"entrypage"}, priority = 1)
    public void logoutTest() {
        loginPage = new LoginPage(eventFiringWebDriver);
        entriesPage = new EntriesPage(eventFiringWebDriver);

        loginPage.enterUsername()
                .enterPassword()
                .login()
                .checkDonationAlert();

        log.info("Tried to log in");

        Assert.assertEquals(eventFiringWebDriver.getCurrentUrl(), "https://my.monkkee.com/#/entries");

        entriesPage.logout();

        Assert.assertEquals(eventFiringWebDriver.getCurrentUrl(), "https://my.monkkee.com/#/");
    }
}