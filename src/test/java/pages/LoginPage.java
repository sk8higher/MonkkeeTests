package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;
    private Wait<WebDriver> wait;
    private final String EMAIL = System.getenv("MONKKEE_EMAIL");
    private final String PASSWORD = System.getenv("MONKKEE_PASSWORD");

    @FindBy(id = "login")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "btn-primary")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage enterUsername() {
        usernameField.sendKeys(EMAIL);
        return this;
    }

    public LoginPage enterPassword() {
        passwordField.sendKeys(PASSWORD);
        return this;
    }

    public LoginPage login() {
        wait = new WebDriverWait(driver, 10, 1000);
        loginButton.click();
        wait.until(ExpectedConditions.urlMatches("https://my.monkkee.com/#/entries"));
        return this;
    }
}