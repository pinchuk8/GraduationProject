package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTypePage extends BasePage {
    private static String ENDPOINT = "/jira/your-work";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//div[@class='sc-3la0sj-2 ghEtRS']");
    protected By useBagTracking_button_selector = By.xpath("//span[@aria-label='Bug tracking']");
    protected By useTemplate_button_selector = By.xpath("//button[@class='css-wbe0z8']");
    protected By projectName_field_selector = By.id("project-create.create-form.name-field.input");
    protected By projectKey_field_selector = By.id("project-create.create-form.advanced-dropdown.key-field.input");
    protected By projectCreate_button_selector = By.xpath("//button[@class='css-wbe0z8']");

    public ProjectTypePage(WebDriver driver) {
        super(driver);
    }

    public ProjectTypePage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getBagTrackingButton() {
        return driver.findElement(useBagTracking_button_selector);
    }

    public WebElement getTemplateButton() {
        waits.waitForVisibility(useTemplate_button_selector);
        return driver.findElement(useTemplate_button_selector);
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

}
