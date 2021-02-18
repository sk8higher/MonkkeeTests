package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

@Log4j2
public class LoginPage extends BasePage {
    public WebDriver driver;

    @FindBy(css = "input#login")
    private WebElement usernameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "(//a[@class='footer-link'])[2]")
    private WebElement supportButton;

    @FindBy(xpath = "//a[@href='/account/password_reminder']")
    private WebElement sendPasswordReminderButton;

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

    public LoginPage goToSupportPage() {
        supportButton.click();
        log.info("Clicked Support button");
        return this;
    }

    public LoginPage switchToAnotherTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Switched to another tab");
        return this;
    }

    public boolean isSupportParagraphVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()[normalize-space()='Support']]")));
        log.info("Found a Support paragraph");
      
    public LoginPage goToPasswordRemindPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String randomEmail = "hello@world.com";

        sendPasswordReminderButton.click();
        log.info("Clicked remind password button");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Email']"))));
        emailField.sendKeys(randomEmail);
        log.info("Typed in email field");

        WebElement okButton = driver.findElement(By.xpath("//input[@type='submit']"));
        okButton.click();
        log.info("Clicked OK button");
        return this;
    }

    public boolean isLoginHintSent() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement paragraph = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Password hint sent']"))));
        return paragraph.isDisplayed();
    }
}