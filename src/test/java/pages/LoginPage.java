package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        return this;
    }

    public LoginPage enterPassword() {
        passwordField.sendKeys(getPASSWORD());
        return this;
    }

    public LoginPage login() {
        loginButton.click();
        return this;
    }

    public LoginPage checkDonationAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Cancel']")));

            WebElement cancelButton = driver.findElement(By.xpath("//div[text()='Cancel']"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelButton);

            cancelButton.click();
        } catch (NoSuchElementException exception) {
            //TODO: прикрутить логгер, chrome
        } catch (TimeoutException exception) {
            //TODO: лог, firefox
        }

        return this;
    }
}