package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTaskPage;
import steps.LoginStep;
import steps.ProjectStep;
import steps.TaskStep;

public class SmokeTest extends BaseTest {


    @Test
    public void test() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject(project);

        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);

        AddTaskPage addTaskPage = new AddTaskPage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(addTaskPage.getCreatedTaskMessage().isDisplayed());

//        driver.navigate().refresh();
    }
}
