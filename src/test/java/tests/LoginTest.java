package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public static void beforeTest() {
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
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        loginPage = new LoginPage(driver);

        loginPage.enterUsername()
                 .enterPassword()
                 .login();

        wait.until(ExpectedConditions.urlMatches("https://my.monkkee.com/#/entries")); // explicit waiting for page to load

        Assert.assertEquals(driver.getCurrentUrl(), "https://my.monkkee.com/#/entries");
    }

    @AfterTest
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
