package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskEditingPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Description']");

    protected By settingLinkSelector = By.xpath("//*[@aria-label = 'Actions']");
    protected By deleteTaskLinkSelector1 = By.xpath("//*[text()='Delete']");
    protected By deleteTaskLinkSelector = By.xpath("//*[contains(text(), 'Delete')]");

    public TaskEditingPage(WebDriver driver) {
        super(driver);
    }

    public TaskEditingPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getSettingLink() {
        return driver.findElement(settingLinkSelector);
    }

    public WebElement getDeleteTaskLink() {
        waits.waitForVisibility(deleteTaskLinkSelector);
        return driver.findElement(deleteTaskLinkSelector);
    }

    public WebElement getDeleteTaskLink1() {
        waits.waitForVisibility(deleteTaskLinkSelector1);
        return driver.findElement(deleteTaskLinkSelector1);
    }
}
