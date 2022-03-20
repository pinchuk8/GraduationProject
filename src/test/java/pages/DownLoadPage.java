package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownLoadPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//input[@name='csvFile']");

    protected By downloadButtonSelector = By.xpath("//input[@name='csvFile']");
    protected By nextButtonSelector = By.xpath("//*[@id='nextButton']");

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public DownLoadPage(WebDriver driver) {
        super(driver);
    }

    public Button getDownloadButton() {
        return new Button(driver,downloadButtonSelector);
    }

    public Button getNextButton() {
        return new Button(driver, nextButtonSelector);
    }
}
