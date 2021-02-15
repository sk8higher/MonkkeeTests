package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class EntriesPage extends BasePage {
    public WebDriver driver;

    @FindBy(id = "create-entry")
    private WebElement createEntryButton;

    @FindBy(id = "delete-entries")
    private WebElement deleteEntryButton;

    @FindBy(xpath = "//input[@title='Select all']")
    private WebElement selectAllEntriesCheckbox;

    @FindBy(xpath = "//a[@href='#/settings/locale']//i")
    private WebElement goToSettingsButton;

    public EntriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public EntriesPage login() {
        if (!driver.getCurrentUrl().equals("https://my.monkkee.com/#/entries")) {
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterUsername()
                    .enterPassword()
                    .login()
                    .checkDonationAlert();

            log.info("Tried to login");
        }

        return this;
    }

    public EntriesPage createEntry() {
        createEntryButton.click();
        log.info("Clicked create entry button");
        return this;
    }

    public EntriesPage deleteAllEntries() {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectAllEntriesCheckbox).click().perform();
        log.info("Selected all entries");

        deleteEntryButton.click();
        driver.switchTo().alert().accept();
        log.info("Deleted all entries");
        return this;
    }

    public EntriesPage goToSettings() {
        goToSettingsButton.click();
        log.info("Go to setting button clicked");
        return this;
    }

    public boolean isEntryExist() {
        boolean exist = false;

        try {
            WebElement entry = driver.findElement(By.xpath("//div[text()='Hello World']"));
            exist = true;
        } catch (NoSuchElementException exception) {
            log.info("There is no entry with this text");
        }

        return exist;
    }

    public boolean isReturnButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        log.info("Waiting for new entry page to load");
        WebElement returnButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-overview")));
        return returnButton.isDisplayed();
    }

    public boolean isThereNoEntries() {
        WebElement paragraph = driver.findElement(By.xpath("//div[text()='No entries found']"));
        log.info("Finding the 'No entries found paragraph'");
        return paragraph.isEnabled();
    }
}