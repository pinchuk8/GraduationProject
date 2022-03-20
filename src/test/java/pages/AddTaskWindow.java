package pages;

import baseEntities.BasePage;
import elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class AddTaskWindow extends BasePage {
    private static String ENDPOINT = "/jira/projects";

    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@id = 'issue-create.ui.modal.modal-body']");

    protected By summaryFieldSelector = By.xpath("//input[@name= 'summary']");
    protected By ErrorMessageSelector = By.xpath("//div[@id='summary-field-error']");
    protected By descriptionFieldSelector = By.xpath("//*[@id = 'description-field-label']/../div//input/../following-sibling::div");
    protected By createButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.create-button']");
    protected By import_issues_selector = By.xpath("//span[text()='Import issues']");
    protected By typeTaskDropDownSelector = By.xpath("//*[text() = 'Issue type']/following-sibling::div");
    protected By epicTypeTaskSelector = By.xpath("//*[. = 'Epic']");
    protected By bugTypeTaskSelector = By.xpath("//*[. = 'Bug']");
    protected By improvementTypeTaskSelector = By.xpath("//*[. = 'Improvement']");
    protected By newFeatureTypeTaskSelector = By.xpath("//*[. = 'New Feature']");
    protected By taskTypeTaskSelector = By.xpath("//*[. = 'Task']");
    protected By typeOfPriorityDropDownSelector = By.xpath("//*[@id = 'priority-field-label']/../div/div/span/..");
    protected By highestPrioritySelector = By.xpath("//*[. = 'Highest']");
    protected By highPrioritySelector = By.xpath("//*[. = 'High']");
    protected By mediumPrioritySelector = By.xpath("//*[. = 'Medium']");
    protected By lowPrioritySelector = By.xpath("//*[. = 'Low']");
    protected By lowestPrioritySelector = By.xpath("//*[. = 'Lowest']");
    protected By cancelButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.cancel-button']");

    public AddTaskWindow(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getImportIssues() {
        waits.waitForClickable(import_issues_selector);
        return driver.findElement(import_issues_selector);
    }

    public WebElement getSummaryField() {
        waits.waitForVisibility(summaryFieldSelector);
        return driver.findElement(summaryFieldSelector);
    }

    public WebElement getErrorMessageField() {
        waits.waitForVisibility(ErrorMessageSelector);
        return driver.findElement(ErrorMessageSelector);
    }

    public WebElement getDescriptionField() {
        waits.waitForVisibility(descriptionFieldSelector);
        return driver.findElement(descriptionFieldSelector);
    }

    public WebElement getCreateButton() {
        waits.waitForVisibility(createButtonSelector);
        return driver.findElement(createButtonSelector);
    }

    public DropDown getTypeTaskDropDown() {
        return new DropDown(driver, typeTaskDropDownSelector);
    }

    public WebElement getEpicTypeTask() {
        return driver.findElement(epicTypeTaskSelector);
    }

    public WebElement getBugTypeTask() {
        return driver.findElement(bugTypeTaskSelector);
    }

    public WebElement getImprovementTypeTask() {
        return driver.findElement(improvementTypeTaskSelector);
    }

    public WebElement getNewFeatureTypeTask() {
        return driver.findElement(newFeatureTypeTaskSelector);
    }

    public WebElement getTaskTypeTask() {
        waits.waitForVisibility(taskTypeTaskSelector);
        return driver.findElement(taskTypeTaskSelector);
    }

    public DropDown getTypeOfPriorityDropDown() {
        return new DropDown(driver, typeOfPriorityDropDownSelector);
    }

    public WebElement getHighestPriority() {
        waits.waitForVisibility(highestPrioritySelector);
        return driver.findElement(highestPrioritySelector);
    }

    public WebElement getHighPriority() {
        waits.waitForVisibility(highPrioritySelector);
        return driver.findElement(highPrioritySelector);
    }

    public WebElement getMediumPriority() {
        waits.waitForVisibility(mediumPrioritySelector);
        return driver.findElement(mediumPrioritySelector);
    }

    public WebElement getLowPriority() {
        waits.waitForVisibility(lowPrioritySelector);
        return driver.findElement(lowPrioritySelector);
    }

    public WebElement getLowestPriority() {
        waits.waitForVisibility(lowestPrioritySelector);
        return driver.findElement(lowestPrioritySelector);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButtonSelector);
    }

    public void taskType() {
        Random rnd = new Random();
        int a = rnd.nextInt(4);
        switch (a) {
            case 0:
                getTaskTypeTask().click();
                break;
            case 1:
                getBugTypeTask().click();
                break;
            case 2:
                getImprovementTypeTask().click();
                break;
            case 3:
                getNewFeatureTypeTask().click();
                break;
            default:
                System.out.println("Invalid task type");
        }
    }

    public void priorityType() {
        Random rnd = new Random();
        int a = rnd.nextInt(5);
        switch (a) {
            case 0:
                getHighestPriority().click();
                break;
            case 1:
                getHighPriority().click();
                break;
            case 2:
                getMediumPriority().click();
                break;
            case 3:
                getLowPriority().click();
                break;
            case 4:
                getLowestPriority().click();
                break;
            default:
                System.out.println("Invalid priority type");
        }
    }
}

