package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

@Log4j2
public class DeleteAllEntriesTest extends BaseTest {
    private EntriesPage entriesPage;

    @Test(description = "Delete all entries", groups = {"entrypage"}, priority = 2)
    public void deleteAllEntriesTest() {
        entriesPage = new EntriesPage(driver);

        entriesPage.login()
                .deleteAllEntries();

        Assert.assertTrue(entriesPage.isThereNoEntries());
    }
}