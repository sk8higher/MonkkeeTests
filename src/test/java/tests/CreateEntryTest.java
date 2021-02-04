package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

@Log4j2
public class CreateEntryTest extends BaseTest {
    private EntriesPage entriesPage;

    @Test(description = "Create an entry", groups = {"entrypage"}, priority = 1)
    public void createEntryTest() {
        entriesPage = new EntriesPage(driver);

        entriesPage.login()
                .createEntry();

        Assert.assertTrue(entriesPage.isReturnButtonDisplayed());
    }
}
