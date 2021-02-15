package tests;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.EditorPage;
import pages.EntriesPage;

@Log4j2
public class CheckEntryContentFromHomepageTest extends BaseTest {
    private EntriesPage entriesPage;
    private EditorPage editorPage;
    private final String text = "Hello World";

    @Test(description = "Type in an entry, return to homepage and check it's content", groups = {"editorpage"}, priority = 1)
    public void checkContentTest() {
        entriesPage = new EntriesPage(eventFiringWebDriver);
        editorPage = new EditorPage(eventFiringWebDriver);

        entriesPage.login()
                .createEntry();

        log.info("Logged in and created an entry");

        editorPage.typeInText(text);

        editorPage.returnToHomePage();

        Assert.assertTrue(entriesPage.isEntryExist());
    }
}