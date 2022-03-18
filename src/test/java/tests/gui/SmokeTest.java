package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.ProjectStep;
import steps.TaskStep;
import utils.Randomization;
import utils.Retry;
import utils.StaticProvider;

import java.io.File;

public class SmokeTest extends BaseTest {
    //ГРАНИЧНЫЕ ЗНАЧЕНИЯ
//    @Test(dataProvider = "dataForLimitValues", dataProviderClass = StaticProvider.class)
//    public void limitValueTest(String a) {
//        ProjectStep projectStep = new ProjectStep(driver);
//        projectStep.createProject();
//        projectStep.createProjectWithLimitValue(a);
//        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
//        if (a.length() == 1 || a.length() == 81) {
//            Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
//        } else {
//            Assert.assertEquals(projectTypePage2.getWarningMessengerSize(), 1);
//            projectTypePage2.getProjectCreateButton().click();
//        }
//    }

//    @Test(retryAnalyzer = Retry.class)//ЗАГРУЗКА ФАЙЛА
//    public void uploadFileTest() {
//        Header header = new Header(driver);
//        header.getCreateButton().click();
//        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
//        addTaskWindow.getImportIssues().click();
//        DownLoadPage downLoadPage = new DownLoadPage(driver);
//        File file = new File("src\\test\\resources\\picture.png");
//        downLoadPage.getDownloadButton().sendKeys(file.getAbsolutePath());
//        Assert.assertTrue(downLoadPage.getNextButton().isDisplayed());
//    }

//    @Test(retryAnalyzer = Retry.class)//СОЗДАНИЕ ЗАДАЧИ
//    public void createTask() {
//        TaskStep taskStep = new TaskStep(driver);
//        taskStep.addTask(addTask);
//        YouWorkPage youWorkPage = new YouWorkPage(driver);
//        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
//    }

//    @Test(retryAnalyzer = Retry.class)//ВСПЛЫВАЮЩЕЕ СООБЩЕНИЕ
//    public void contextMessage() {
//        TaskStep taskStep = new TaskStep(driver);
//        taskStep.addTask(addTask);
//        YouWorkPage youWorkPage = new YouWorkPage(driver);
//        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
//    }

//    @Test(retryAnalyzer = Retry.class)//ДИАЛОГОВОЕ ОКНО
//    public void dialogWindow() {
//        Header header = new Header(driver);
//        header.getCreateButton().click();
//        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
//        Assert.assertTrue(addTaskWindow.getCreateButton().isDisplayed());
//    }

//    @Test(retryAnalyzer = Retry.class, dependsOnMethods = "createTask")//УДАЛЕНИЕ ЗАДАЧИ
//    public void deleteTask() {
//        TaskStep taskStep = new TaskStep(driver);
//        taskStep.deleteTask(addTask);
//        SearchPage searchPage = new SearchPage(driver);
//        Assert.assertEquals(searchPage.getNessesaryTaskSelector1(addTask).size(), 0);
//    }

//    @Test(retryAnalyzer = Retry.class)//НЕКОРРЕКТНЫЕ ДАННЫЕ
//    public void wrongDataTest() {
//        ProjectStep projectStep = new ProjectStep(driver);
//        projectStep.createProject();
//        projectStep.createProjectWithWrongKey();
//        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
//        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
//    }

        @Test//ВОСПРОИЗВЕДЕНИЕ ДЕФФЕКТА
    public void defectTest() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }

//    @Test(retryAnalyzer = Retry.class)//ПРЕВЫШАЮЩИЙ ДОПУСТИМЫЕ
    public void dataExceedingTheAllowable() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());
    }
}
