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

    @FindBy(id = "login")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public LoginPage enterUsername() {
        usernameField.sendKeys(getEMAIL());

        log.info("Entered login username");

        return this;
    }

    public LoginPage enterPassword() {
        passwordField.sendKeys(getPASSWORD());

        log.info("Entered password");

        return this;
    }

    public LoginPage login() {
        loginButton.click();

        log.info("Clicked login button");

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