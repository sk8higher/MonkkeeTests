package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

@Log4j2
public class EditorPage extends BasePage {
    public WebDriver driver;

    @FindBy(id = "editable")
    private WebElement editor;

    @FindBy(xpath = "//a[@title='Change entry date/time']//span[1]")
    private WebElement changeDateAndTimeButton;

    @FindBy(xpath = "//input[contains(@class,'form-control date')]")
    private WebElement dateInputField;

    @FindBy(xpath = "//input[contains(@class,'form-control time')]")
    private WebElement timeInputField;

    @FindBy(xpath = "//div[@ng-hide='editDate']//time[1]")
    private WebElement dateAndTime;

    public EditorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, getWAITER_TIME()), this);
        this.driver = driver;
    }

    public EditorPage typeInText(String text) {
        editor.sendKeys(text);
        log.info("Typed '" + text + "' in editor");
        return this;
    }

    public String getTextFromEditor() {
        log.info("The text is '" + editor.getText() + "'");
        return editor.getText();
    }

    public EditorPage changeDate() {
        changeDateAndTimeButton.click();
        log.info("Clicked change time/date button");
        dateInputField.click();
        dateInputField.sendKeys("10/02/2007");
//        ((JavascriptExecutor) driver).executeScript("$('input#date').datepicker('setDate', '10/02/2007')");
        log.info("Tried to change date");
        driver.findElement(By.linkText("Close")).click();
        log.info("Changed the date");
        return this;
    }

    public EditorPage changeTime() {
        timeInputField.sendKeys("00:08 pm");
        log.info("Tried to change time");
        return this;
    }

    public EditorPage clickOkButtonToSetTheDate() {
        WebElement okButton = driver.findElement(By.xpath("//div[text()='OK']"));
        okButton.click();
        log.info("Clicked OK button");
        return this;
    }

    public String getDateAndTime() {
        log.info("Getting text..");
        return dateAndTime.getText();
    }
}