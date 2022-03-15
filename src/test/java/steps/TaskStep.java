package steps;

import baseEntities.BaseStep;
import models.Task;
import org.openqa.selenium.WebDriver;
import pages.AddTaskPage;
import pages.Header;
import pages.TaskEditingPage;
import pages.YouWorkPage;

public class TaskStep extends BaseStep {
    private AddTaskPage addTaskPage;
    private Header header;
    private YouWorkPage youWorkPage;
    private TaskEditingPage taskEditingPage;

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public void addTask(Task addTask) throws InterruptedException {
        header = new Header(driver);
        header.getCreateButton().click();
        addTaskPage = new AddTaskPage(driver);
        addTaskPage.getTypeTaskDropDown().click();
        addTaskPage.taskType();
        addTaskPage.getSummaryField().sendKeys(addTask.getSummary());
        addTaskPage.getDescriptionField().sendKeys(addTask.getDescription());
        addTaskPage.getTypeOfPriorityDropDown().click();
        addTaskPage.priorityType();
        addTaskPage.getCreateButton().click();
    }

    public void deleteTask(Task addTask) throws InterruptedException {
        youWorkPage = new YouWorkPage(driver);
        youWorkPage.getViewIssue().click();
        taskEditingPage = new TaskEditingPage(driver);
        taskEditingPage.getSettingLink().click();
        taskEditingPage.getDeleteTaskLink().click();
        taskEditingPage.getDeleteTaskLink1().click();
        youWorkPage.openPage();
    }
}
