package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

@Log4j2
public class EditorPage extends BasePage {
    public WebDriver driver;

    @FindBy(id = "editable")
    private WebElement editor;

    @FindBy(id = "back-to-overview")
    private WebElement returnToHomePageButton;

    public EditorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public EditorPage typeInText(String text) {
        editor.sendKeys(text);
        log.info("Typed '" + text + "' in editor");
        return this;
    }

    public String getTextFromEditor() {
        log.info("The text is '" + editor.getText() + "'");
        return editor.getText();
    }

    public EditorPage returnToHomePage() {
        returnToHomePageButton.click();
        log.info("Clicked return to homepage button");
        return this;
    }
}