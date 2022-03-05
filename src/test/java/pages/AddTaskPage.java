package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaskPage extends BasePage {
    private static String ENDPOINT = "/jira/projects";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@class = 'css-1aseh1t e1rcei0k1']");

    protected By summaryFieldSelector = By.xpath("//input[@name= 'summary']");
    protected By descriptionFieldSelector =By.xpath("//*[@id = 'description-field-label']/../div//input/../following-sibling::div");
    protected By typeTaskDropDownSelector = By.xpath("//*[text() = 'Issue type']/following-sibling::div");
    protected By epicTypeTaskSelector = By.xpath("//*[. = 'Epic']");
    protected By bugTypeTaskSelector = By.xpath("//*[. = 'Bug']");
    protected By improvementTypeTaskSelector = By.xpath("//*[. = 'Improvement']");
    protected By newFeatureTypeTaskSelector = By.xpath("//*[. = 'New Feature']");
    protected By taskTypeTaskSelector = By.xpath("//*[. = 'Task']");
    protected By typeOfPriorityDropDownSelector = By.xpath("//*[@id = 'priority-field-label']/..");
    protected By highestPrioritySelector = By.xpath("//*[. = 'Highest']");
    protected By highPrioritySelector = By.xpath("//*[. = 'High']");
    protected By mediumPrioritySelector = By.xpath("//*[. = 'Medium']");
    protected By lowPrioritySelector = By.xpath("//*[. = 'Low']");
    protected By lowestPrioritySelector = By.xpath("//*[. = 'Lowest']");
    protected By createButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.create-button']");
    protected By cancelButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.cancel-button']");
    protected By createdTaskMessageSelector = By.xpath("//*[@aria-label = 'Success']");

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public AddTaskPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    public AddTaskPage() {
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getSummaryField() {
         return waits.waitForVisibility(summaryFieldSelector);}
    public WebElement getDescriptionField() {
        return waits.waitForVisibility(descriptionFieldSelector);            }
    public WebElement getTypeTaskDropDown() {return driver.findElement(typeTaskDropDownSelector);    }
    public WebElement getEpicTypeTask() {return driver.findElement(epicTypeTaskSelector);    }
    public WebElement getBugTypeTask() {return driver.findElement(bugTypeTaskSelector);    }
    public WebElement getImprovementTypeTask() {return driver.findElement(improvementTypeTaskSelector);    }
    public WebElement getNewFeatureTypeTask() {return driver.findElement(newFeatureTypeTaskSelector);    }
    public WebElement getTaskTypeTask() {return driver.findElement(taskTypeTaskSelector);    }
    public WebElement getTypeOfPriorityDropDown() {return driver.findElement(typeOfPriorityDropDownSelector);    }
    public WebElement getHighestPriority() {return driver.findElement(highestPrioritySelector);    }
    public WebElement getHighPriority() {return driver.findElement(highPrioritySelector);    }
    public WebElement getMediumPriority() {return driver.findElement(mediumPrioritySelector);    }
    public WebElement getLowPriority() {return driver.findElement(lowPrioritySelector);    }
    public WebElement getLowestPriority() {return driver.findElement(lowestPrioritySelector);    }
    public WebElement getCreateButton() {return waits.waitForVisibility(createButtonSelector);    }
    public WebElement getCancelButton() {return driver.findElement(cancelButtonSelector);    }
    public WebElement getCreatedTaskMessage() {return waits.waitForVisibility(createdTaskMessageSelector);    }
}
