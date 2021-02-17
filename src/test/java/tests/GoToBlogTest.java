package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class GoToBlogTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Go to Blog from footer", priority = 3)
    public void goToBlogTest() {
        loginPage = new LoginPage(eventFiringWebDriver);

        loginPage.goToBlogPage()
                .switchToAnotherTab();

        Assert.assertTrue(loginPage.isBlogParagraphVisible());
    }
}