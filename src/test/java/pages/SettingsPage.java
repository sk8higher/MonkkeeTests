package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class SettingsPage extends BasePage {
    public WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[text()='OK']")
    private WebElement okButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public SettingsPage changeLocaleTo(String locale) {
        wait = new WebDriverWait(driver, getWAITER_TIME());
        Select selectLocale = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("selectLocale"))));
        selectLocale.selectByVisibleText(locale);
        log.info("Trying to change locale to " + locale);
        okButton.click();
        log.info("Clicked OK button");
        return this;
    }

    public String getAlertText() {
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        log.info("The alert text is : " + successAlert.getText());
        return successAlert.getText();
    }

    public boolean isLocaleChangedToDeutsch() {
        String alertText = getAlertText();
        String neededAlertText = "Deine Spracheinstellung wurde erfolgreich geändert";

        return alertText.equals(neededAlertText);
    }

    public boolean isLocaleChangedToEnglish() {
        String alertText = getAlertText();
        String neededAlertText = "Your language has been changed successfully";

        return alertText.equals(neededAlertText);
    }
}
