package tests.gui;

import baseEntities.BaseTest;
import utils.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.ProjectStep;
import steps.TaskStep;
import utils.Randomization;
import utils.Retry;

import java.io.File;

public class SmokeTest extends BaseTest {
    //ГРАНИЧНЫЕ ЗНАЧЕНИЯ
    @Test(dataProvider = "dataForLimitValues", dataProviderClass = DataProvider.StaticProvider.class)
    public void LimitValueTest(String a) {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithLimitValue(a);
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        if (a.length() == 1 | a.length() == 81) {
            Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
        } else {
            Assert.assertEquals(projectTypePage2.getWarningMessengerSize(), 1);
            projectTypePage2.getProjectCreateButton().click();
        }
    }

    @Test//ЗАГРУЗКА ФАЙЛА
    public void UploadFileTest() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
        addTaskWindow.getImportIssues().click();
        DownLoadPage downLoadPage = new DownLoadPage(driver);
        File file = new File("src\\test\\resources\\picture.png");
        downLoadPage.getDownloadButton().sendKeys(file.getAbsolutePath());
        waits.waitForClickable(downLoadPage.getNextButton());
    }

    @Test//СОЗДАНИЕ ЗАДАЧИ
    public void createTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//ВСПЛЫВАЮЩЕЕ СООБЩЕНИЕ
    public void contextMessage(){
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//ДИАЛОГОВОЕ ОКНО
    public void dialogWindow() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskWindow.getCreateButton().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//УДАЛЕНИЕ ЗАДАЧИ
    public void DeleteTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.deleteTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        youWorkPage.openPage();
        Assert.assertTrue(youWorkPage.getNessesaryTask().getAttribute("innerText") != addTask.getSummary());
    }

    @Test(retryAnalyzer = Retry.class)//НЕКОРРЕКТНЫЕ ДАННЫЕ
    public void WrongDataTest() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
    }

    @Test//ВОСПРОИЗВЕДЕНИЕ ДЕФФЕКТА
    public void DefectTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//ПРЕВЫШАЮЩИЙ ДОПУСТИМЫЕ
    public void DataExceedingTheAllowable() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());
    }
}
