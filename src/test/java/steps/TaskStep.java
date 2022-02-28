package steps;

import baseEntities.BaseStep;
import models.Task;
import org.openqa.selenium.WebDriver;
import pages.AddTaskPage;

public class TaskStep extends BaseStep {
    private AddTaskPage addTaskPage;

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public AddTaskPage addTask(Task task) {
       addTaskPage = new AddTaskPage(driver);
       addTaskPage.getTypeTaskDropDown().click();
       addTaskPage.getSummaryField().sendKeys(task.getSummary());
       addTaskPage.getDescriptionField().sendKeys(task.getDescription());
       addTaskPage.getCreateButton().click();
       return addTaskPage;
    }
}
