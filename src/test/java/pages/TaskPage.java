package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPage extends BasePage {

    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Issues']");

    protected By searchFieldSelector = By.name("search");
    protected By projectFindDropDownSelector = By.xpath("//*[@data-testid = 'jql-builder-basic.ui.jql-editor.picker.filter-button.project']");
    protected String projectFindChekBoxSelector = "//*[text() = 'replace']";
    protected By typeTaskDropDownSelector = By.xpath("//*[@data-testid = 'jql-builder-basic.ui.jql-editor.picker.filter-button.type']");
    protected By allStandardTypesTaskSelector = By.xpath("//*[. = 'All standard issue types']");
    protected By allSubTaskTypesSelector = By.xpath("//*[. = 'All sub-task issue types']");
    protected By epicTaskSelector = By.xpath("//*[. = 'Epic']");
    protected By bugTaskSelector = By.xpath("//*[. = 'Bug']");
    protected By improvementTaskSelector = By.xpath("//*[. = 'Improvement']");
    protected By newFeatureTaskSelector = By.xpath("//*[. = 'New Feature']");
    protected By subTaskSelector = By.xpath("//*[. = 'Sub-task']");
    protected By statusDropDownSelector = By.xpath("//*[@data-testid = 'jql-builder-basic.ui.jql-editor.picker.filter-button.type']");
    protected By doneStatusSelector = By.xpath("//*[. = 'Done']");
    protected By inProgressStatusSelector = By.xpath("//*[. = 'In Progress']");
    protected By inReviewStatusSelector = By.xpath("//*[. = 'In Review']");
    protected By toBeCompletedStatusSelector = By.xpath("//*[. = 'To Do']");
    protected String taskFindSelector = "//*[text() = 'replace']";

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public TaskPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getSearchField() {
        return driver.findElement(searchFieldSelector);
    }

    public WebElement getProjectFindDropDown() {
        return driver.findElement(projectFindDropDownSelector);
    }

    public WebElement getProjectFindChekBox(String projectName) {
        return driver.findElement(By.xpath(projectFindChekBoxSelector.replace("replace", String.valueOf(projectName))));
    }

    public WebElement getTypeTaskDropDown() {
        return driver.findElement(typeTaskDropDownSelector);
    }

    public WebElement getAllStandardTypesTask() {
        return driver.findElement(allStandardTypesTaskSelector);
    }

    public WebElement getAllSubTaskTypes() {
        return driver.findElement(allSubTaskTypesSelector);
    }

    public WebElement getEpicTask() {
        return driver.findElement(epicTaskSelector);
    }

    public WebElement getBugTask() {
        return driver.findElement(bugTaskSelector);
    }

    public WebElement getImprovementTask() {
        return driver.findElement(improvementTaskSelector);
    }

    public WebElement getNewFeatureTask() {
        return driver.findElement(newFeatureTaskSelector);
    }

    public WebElement getSubTask() {
        return driver.findElement(subTaskSelector);
    }

    public WebElement getStatusDropDown() {
        return driver.findElement(statusDropDownSelector);
    }

    public WebElement getDoneStatus() {
        return driver.findElement(doneStatusSelector);
    }

    public WebElement getInWorkStatus() {
        return driver.findElement(inProgressStatusSelector);
    }

    public WebElement getInReviewStatus() {
        return driver.findElement(inReviewStatusSelector);
    }

    public WebElement getToBeCompletedStatus() {
        return driver.findElement(toBeCompletedStatusSelector);
    }

    public WebElement getTaskFind(String taskName) {
        return driver.findElement(By.xpath(taskFindSelector.replace("replace", String.valueOf(taskName))));
    }
}
