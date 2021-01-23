package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public WebDriver driver;

    @FindBy(id = "login")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type = 'submit']")
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
        getWait().until(ExpectedConditions.urlMatches("https://my.monkkee.com/#/entries"));
        return this;
    }
}