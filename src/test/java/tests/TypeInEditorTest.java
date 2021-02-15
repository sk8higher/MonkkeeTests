package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditorPage;
import pages.EntriesPage;

@Log4j2
public class TypeInEditorTest extends BaseTest {
    private EntriesPage entriesPage;
    private EditorPage editorPage;
    private final String text = "Hello World";

    @Test(description = "Type in editor", groups = {"editorpage"}, priority = 2)
    public void typeInEditorTest() {
        entriesPage = new EntriesPage(eventFiringWebDriver);
        editorPage = new EditorPage(eventFiringWebDriver);

        entriesPage.login()
                .createEntry();

        editorPage.typeInText(text);

        Assert.assertEquals(editorPage.getTextFromEditor(), text);
    }
}
