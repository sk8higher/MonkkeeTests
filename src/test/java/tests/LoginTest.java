package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox", "--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://my.monkkee.com/#/");
    }

    @Test(description = "Login test")
    public void loginTest() {
        loginPage = new LoginPage(driver);

        loginPage.enterUsername()
                 .enterPassword()
                 .login();

        Assert.assertEquals(driver.getCurrentUrl(), "https://my.monkkee.com/#/entries");
    }

    @AfterTest
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
