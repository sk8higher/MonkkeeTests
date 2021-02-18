package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class GoToSupportPageTest extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "Go to Support page from footer", priority = 3)
    public void goToSupportTest() {
        loginPage = new LoginPage(eventFiringWebDriver);

        loginPage.goToSupportPage()
                .switchToAnotherTab();

        Assert.assertTrue(loginPage.isSupportParagraphVisible());
    }
}
