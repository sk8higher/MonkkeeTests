package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class GoToFaqPageTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Go to FAQ page from footer", priority = 3)
    public void goToFaqPageTest() {
        loginPage = new LoginPage(eventFiringWebDriver);

        loginPage.goToFaqPage()
                .switchToAnotherTab();

        Assert.assertTrue(loginPage.isFaqParagraphVisible());
    }
}