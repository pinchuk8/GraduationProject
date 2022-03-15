package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownLoadPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//input[@name='csvFile']");

    protected By downloadButtonSelector = By.xpath("//input[@name='csvFile']");
    protected By nextButtonSelector = By.xpath("//button[@id='nextButton']");

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

    public WebElement getDownloadButton() {
        waits.waitForVisibility(downloadButtonSelector);
        return driver.findElement(downloadButtonSelector);
    }

    public WebElement getNextButton() {
        waits.waitForVisibility(nextButtonSelector);
        return driver.findElement(nextButtonSelector);
    }
}
