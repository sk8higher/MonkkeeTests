package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetProperties;

import java.util.Properties;

public class LoginPage {
    public WebDriver driver;
    private Properties prop = GetProperties.readFile();
    private Wait<WebDriver> wait;
    private final String EMAIL = prop.getProperty("email");
    private final String PASSWORD = prop.getProperty("password");

    @FindBy(id = "login")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='main']/div/div[2]/div[1]/div/div/form/div[4]/div/button/div")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
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