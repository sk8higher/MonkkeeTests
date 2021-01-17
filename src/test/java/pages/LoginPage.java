package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
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
        System.out.println(EMAIL);
        usernameField.sendKeys(EMAIL);
        return this;
    }

    public LoginPage enterPassword() {
        passwordField.sendKeys(PASSWORD);
        return this;
    }

    public LoginPage login() {
        loginButton.click();
        return this;
    }
}