package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class GoToHomepageTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Go to homepage from footer", priority = 3)
    public void goToHomepageTest() {
        loginPage = new LoginPage(eventFiringWebDriver);

        loginPage.goToHomepage()
                .switchToAnotherTab();

        Assert.assertTrue(loginPage.isHomepageParagraphVisible());
    }
}