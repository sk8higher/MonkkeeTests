package utils.listeners;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Log4j2
public class WebDriverListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.debug("Trying to find element using '" + by + "'");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.debug("Found an element using '" + by + "'");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("Trying to navigate to '" + url + "'");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("Navigated to '" + url + "'");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        log.error("Got '" + throwable.getMessage() + "'");
    }
}