package steps;

import baseEntities.BaseStep;
import models.Task;
import org.openqa.selenium.WebDriver;
import pages.AddTaskPage;
import pages.ChooseProjectPage;
import pages.Header;

public class TaskStep extends BaseStep {
    private AddTaskPage addTaskPage;
    private Header header;

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public void addTask(Task addTask) throws InterruptedException {
        header = new Header(driver);
        header.getCreateTaskButton().click();
        addTaskPage = new AddTaskPage(driver);
        addTaskPage.getTypeTaskDropDown().click();
        addTaskPage.getBugTypeTask().click();
        addTaskPage.getSummaryField().sendKeys(addTask.getSummary());
        Thread.sleep(5000);
        addTaskPage.getDescriptionField().sendKeys(addTask.getDescription());
        addTaskPage.getCreateButton().click();
    }

}
