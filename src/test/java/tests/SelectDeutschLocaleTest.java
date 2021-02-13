package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import pages.SettingsPage;

public class SelectDeutschLocaleTest extends BaseTest {
    private EntriesPage entriesPage;
    private SettingsPage settingsPage;

    @Test(description = "Try to change locale to Deutsch", groups = {"settingspage"}, priority = 2)
    public void changeLocaleTest() {
        entriesPage = new EntriesPage(eventFiringWebDriver);
        settingsPage = new SettingsPage(eventFiringWebDriver);

        entriesPage.login()
                .goToSettings();

        settingsPage.changeLocaleTo("Deutsch");

        Assert.assertEquals(settingsPage.getAlertText(), "Deine Spracheinstellung wurde erfolgreich geändert");

        settingsPage.changeLocaleTo("English");

        Assert.assertEquals(settingsPage.getAlertText(), "Your language has been changed successfully");
    }
}
