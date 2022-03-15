package steps;

import baseEntities.BaseStep;
import models.Task;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TaskStep extends BaseStep {
    private AddTaskWindow addTaskPage;
    private Header header;

    public TaskStep(WebDriver driver) {
        super(driver);
    }

    public void addTask(Task addTask)  {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        addTaskPage.getSummaryField().sendKeys(addTask.getSummary());
        addTaskPage.getDescriptionField().sendKeys(addTask.getDescription());
        addTaskPage.getCreateButton().click();
    }

    public void deleteTask(Task addTask){
        Header header = new Header(driver);
        header.getSearchField().click();
        header.getSearchField().sendKeys(addTask.getSummary());
        header.getSearchField().sendKeys(Keys.ENTER);
        SearchPage searchPage=new SearchPage(driver);
        searchPage.getNessesaryTaskSelector(addTask).click();
        TaskEditingPage taskEditingPage = new TaskEditingPage(driver);
        taskEditingPage.getSettingLink().click();
        taskEditingPage.getDeleteTaskLink().click();
        taskEditingPage.getDeleteTaskLink1().click();
    }


}
