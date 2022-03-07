package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTypePage2 extends BasePage {
    private static String ENDPOINT = "/jira/your-work";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//span[@class='css-19r5em7']");
    protected By projectName_field_selector = By.id("project-create.create-form.name-field.input");
    protected By projectKey_field_selector = By.id("project-create.create-form.advanced-dropdown.key-field.input");
    protected By projectCreate_button_selector = By.xpath("//button[@class='css-wbe0z8']");
    protected By warning_messenger_selector = By.xpath("//div[@class='sc-1hvvono-1 gUyipw']");
    protected By key_warning_messenger_selector = By.xpath("//div[contains(text(),'Project')]");


    public ProjectTypePage2(WebDriver driver) {
        super(driver);
    }

    public ProjectTypePage2(WebDriver driver, boolean openPageByUrl) {
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
        return driver.findElement(projectName_field_selector);
    }

    public WebElement getProjectKeyField() {
        return driver.findElement(projectKey_field_selector);
    }

    public WebElement getProjectCreateButton() {
        waits.waitForVisibility(projectCreate_button_selector);
        return driver.findElement(projectCreate_button_selector);
    }

    public WebElement getWarningMessenger() {
        waits.waitForVisibility(warning_messenger_selector);
        return driver.findElement(warning_messenger_selector);
    }
    public WebElement getKeyWarningMessenger() {
        waits.waitForVisibility(key_warning_messenger_selector);
        return driver.findElement(key_warning_messenger_selector);
    }

    public int getWarningMessengerSize() {
        waits.waitForVisibility(warning_messenger_selector);
        int a = driver.findElements(warning_messenger_selector).size();
        return a;
    }
}
