package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

@Log4j2
public class DeleteAllEntriesTest extends BaseTest {
    private EntriesPage entriesPage;

    /*
     * Из-за того что этот тест запускается в нескольких браузерах
     * может оказаться так, что записи были уже удалены.
     * И тогда кнопка удаления не будет работать.
     * Поэтому перед удалением создается пустая запись.
     */

    @Test(description = "Delete all entries", groups = {"entrypage"}, priority = 1)
    public void deleteAllEntriesTest() {
        entriesPage = new EntriesPage(driver);

        entriesPage.login()
                .createEntry()
                .returnToHomePage()
                .deleteAllEntries();

        Assert.assertTrue(entriesPage.isThereNoEntries());
    }
}