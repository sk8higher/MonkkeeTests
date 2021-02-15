package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Log4j2
public class LoginPage extends BasePage {
    public WebDriver driver;

    @FindBy(css = "input#login")
    private WebElement usernameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public LoginPage enterUsername() {
        try {
            usernameField.sendKeys(getEMAIL());
            log.info("Entered login username");
        } catch (ElementNotInteractableException exception) {
            log.error("Caught Element Not Interactable");
        }

        return this;
    }

    public LoginPage enterPassword() {
        try {
            passwordField.sendKeys(getPASSWORD());
            log.info("Entered password");
        } catch (ElementNotInteractableException exception) {
            log.error("Caught Element Not Interactable");
        }

        return this;
    }

    public LoginPage login() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
            loginButton.click();
            log.info("Clicked login button");
        } catch (ElementNotInteractableException exception) {
            log.error("Caught Element Not Interactable");
        }

        return this;
    }

    public LoginPage checkDonationAlert() {
        try {
            log.info("Checking for donation alert...");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Cancel']")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelButton);

            cancelButton.click();
        } catch (NoSuchElementException | TimeoutException exception) {
            log.warn("Donation alert hasn't appeared");
        }

        return this;
    }
}