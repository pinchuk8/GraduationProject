package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaskPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.className("css-1aseh1t e1rcei0k1");

    protected By summaryFieldSelector = By.id("summary-field");
    protected By descriptionFieldSelector =By.className("a1u0y8-0 eXYHSA");
    protected By typeTaskDropDownSelector = By.xpath("//*[@id = 'type-picker-uid7-label']/..//div");
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

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return false;
    }

    public WebElement getSummaryField() {return driver.findElement(summaryFieldSelector);    }
    public WebElement getDescriptionField() {return driver.findElement(descriptionFieldSelector);    }
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
    public WebElement getCreateButton() {return driver.findElement(createButtonSelector);    }
    public WebElement getCancelButton() {return driver.findElement(cancelButtonSelector);    }
    public WebElement getCreatedTaskMessage() {return driver.findElement(createdTaskMessageSelector);    }
}
