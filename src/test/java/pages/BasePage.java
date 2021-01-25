package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import utils.propertyreader.GetProperties;

import java.util.Properties;

@Getter
public class BasePage {
    public WebDriver driver;
    public Wait<WebDriver> wait;

    protected Properties prop = GetProperties.readFile();

    private final String EMAIL = prop.getProperty("email");
    private final String PASSWORD = prop.getProperty("password");
    private final int WAITER_TIME = Integer.parseInt(prop.getProperty("waiterTime"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
