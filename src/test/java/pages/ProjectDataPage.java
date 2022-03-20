package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDataPage extends BasePage {
    private static String ENDPOINT = "/jira/your-work";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//span[@class='css-19r5em7']");

    protected By projectNameFieldSelector = By.id("project-create.create-form.name-field.input");
    protected By projectKeyFieldSelector = By.id("project-create.create-form.advanced-dropdown.key-field.input");
    protected By projectCreateButtonSelector = By.xpath("//button[@class='css-goggrm']");
    protected By warningMessengerSelector = By.xpath("//div[@class='sc-1hvvono-1 gUyipw']");
    protected By keyWarningMessengerSelector = By.xpath("//div[contains(text(),'Project')]");

    public ProjectDataPage(WebDriver driver) {
        super(driver);
    }

    public ProjectDataPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getProjectNameField() {
        waits.waitForVisibility(projectNameFieldSelector);
        return driver.findElement(projectNameFieldSelector);
    }

    public WebElement getProjectKeyField() {
        waits.waitForVisibility(projectKeyFieldSelector);
        return driver.findElement(projectKeyFieldSelector);
    }

    public Button getProjectCreateButton() {
        return new Button(driver,projectCreateButtonSelector);
    }

    public WebElement getWarningMessenger() {
        waits.waitForVisibility(warningMessengerSelector);
        return driver.findElement(warningMessengerSelector);
    }

    public WebElement getKeyWarningMessenger() {
        waits.waitForVisibility(keyWarningMessengerSelector);
        return driver.findElement(keyWarningMessengerSelector);
    }

    public int getWarningMessengerSize() {
        waits.waitForVisibility(warningMessengerSelector);
        int a = driver.findElements(warningMessengerSelector).size();
        return a;
    }
}
