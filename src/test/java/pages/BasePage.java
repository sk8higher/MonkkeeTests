package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import utils.propertyreader.GetProperties;

import java.util.ArrayList;
import java.util.Properties;

@Log4j2
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

    public BasePage switchToAnotherTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Switched to another tab");
        return this;
    }
}
