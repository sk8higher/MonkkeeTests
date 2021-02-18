package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SendPasswordReminderTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Go to sent password hint page and try to send a email", priority = 3)
    public void sendPassHintTest() {
        loginPage = new LoginPage(eventFiringWebDriver);

        loginPage.goToPasswordRemindPage();

        Assert.assertTrue(loginPage.isLoginHintSent());
    }
}
