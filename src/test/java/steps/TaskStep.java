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

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public void addTask(Task addTask) throws InterruptedException {
        Header header = new Header(driver);
        header.getCreateButton().click();
    //  Thread.sleep(5000);
        AddTaskPage addTaskPage = new AddTaskPage(driver);
        addTaskPage.getSummaryField().sendKeys(addTask.getSummary());
    //    Thread.sleep(5000);
     //   waits.waitForVisibility(addTaskPage.getDescriptionField());
        addTaskPage.getDescriptionField().sendKeys(addTask.getDescription());
    //    Thread.sleep(5000);
      //  waits.waitForVisibility(addTaskPage.getCreateButton());
        addTaskPage.getCreateButton().click();

    //    Thread.sleep(5000);
    }

    public void deleteTask(Task addTask) throws InterruptedException {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        youWorkPage.getViewIssue().click();
        TaskEditingPage taskEditingPage = new TaskEditingPage(driver);
        taskEditingPage.getSettingLink().click();
        taskEditingPage.getDeleteTaskLink().click();
    //    waits.waitForVisibility(taskEditingPage.getDeleteTaskLink1());
        taskEditingPage.getDeleteTaskLink1().click();
        youWorkPage.openPage();
    }


}
