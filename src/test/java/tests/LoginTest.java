package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://my.monkkee.com/#/");
    }

    @Test(description = "Login test")
    public void loginTest() {
        loginPage = new LoginPage(driver);

        loginPage.enterUsername()
                .enterPassword()
                .login()
                .checkDonationAlert();

        Assert.assertEquals(driver.getCurrentUrl(), "https://my.monkkee.com/#/entries");
    }
}
