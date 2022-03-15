package steps;

import baseEntities.BaseStep;
import models.Task;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.AddTaskWindow;
import pages.Header;
import pages.SearchPage;
import pages.TaskEditingPage;

public class TaskStep extends BaseStep {
    private AddTaskWindow addTaskWindow;
    private SearchPage searchPage;
    private Header header;
    private TaskEditingPage taskEditingPage;

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public void addTask(Task addTask) {
        header = new Header(driver);
        header.getCreateButton().click();
        addTaskWindow = new AddTaskWindow(driver);
        addTaskWindow.getTypeTaskDropDown().click();
        addTaskWindow.taskType();
        addTaskWindow.getSummaryField().sendKeys(addTask.getSummary());
        addTaskWindow.getDescriptionField().sendKeys(addTask.getDescription());
        addTaskWindow.getTypeOfPriorityDropDown().click();
        addTaskWindow.priorityType();
        addTaskWindow.getCreateButton().click();
    }

    public void deleteTask(Task addTask) {
        header = new Header(driver);
        header.getSearchField().click();
        header.getSearchField().sendKeys(addTask.getSummary());
        header.getSearchField().sendKeys(Keys.ENTER);
        searchPage = new SearchPage(driver);
        searchPage.getNessesaryTaskSelector(addTask).click();
        taskEditingPage = new TaskEditingPage(driver);
        taskEditingPage.getSettingLink().click();
        taskEditingPage.getDeleteTaskLink().click();
        taskEditingPage.getDeleteTaskLink1().click();
    }
}
