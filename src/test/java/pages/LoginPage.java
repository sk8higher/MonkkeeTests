package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    public WebDriver driver;

    private Alert alert;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            WebElement cancelButton = driver.findElement(By.xpath("//button[@custom-modal-close='login()']//div[1]"));
            cancelButton.click();
        } catch (NoSuchElementException | ElementNotInteractableException exception) {
            //TODO: прикрутить логгер
            // NoSuchElementException появляется если поп апа с донатом нет в Chrome.
            // ElementNotInteractableException появляется по тем же причинам в Firefox.
        }

        return this;
    }
}