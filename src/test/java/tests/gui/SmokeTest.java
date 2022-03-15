package tests.gui;

import baseEntities.BaseTest;
import data.data.provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.ProjectStep;
import steps.TaskStep;
import utils.Randomization;
import utils.Retry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SmokeTest extends BaseTest {
    //ГРАНИЧНЫЕ ЗНАЧЕНИЯ
    @Test(dataProvider = "dataForLimitValues", dataProviderClass = provider.StaticProvider.class, retryAnalyzer = Retry.class)
    public void LimitValueTest(String a) {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithLimitValue(a);
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        if (a.length() == 1 | a.length() == 81) {
            Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
        } else {
            Assert.assertTrue(projectTypePage2.getProjectCreateButton().isEnabled());
        }
    }

    @Test//ЗАГРУЗКА ФАЙЛА
    public void UploadFileTest() throws InterruptedException, FileNotFoundException {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
        Thread.sleep(10000);

        addTaskWindow.getImportIssues().click();
        DownLoadPage downLoadPage = new DownLoadPage(driver);
        //downLoadPage.getDownloadButton().sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg");
         //downLoadPage.getDownloadButton().sendKeys("C:\\Users\\user\\IdeaProjects\\GraduationProject\\src\\test\\resources\\picture.png");
         //downLoadPage.getDownloadButton().sendKeys("src\\\\test\\\\resources\\\\smile.png");
        // downLoadPage.getDownloadButton().sendKeys("src/test/resources/picture.png");
        File file = new File("src\\test\\resources\\picture.png");
        //File file = new File("resources\\picture.png");
        //InputStream input = getClass().getResourceAsStream("picture.png");
        //InputStream input = new FileInputStream(new File("src\\test\\resources\\picture.png"));
         //downLoadPage.getDownloadButton().sendKeys((CharSequence) file);
        // downLoadPage.getDownloadButton().sendKeys("src\\test\\resources\\picture.png");
         downLoadPage.getDownloadButton().sendKeys(file.getAbsolutePath());
        //downLoadPage.getDownloadButton().sendKeys(file.пуе);
        Thread.sleep(10000);
        waits.waitForClickable(downLoadPage.getNextButton());

    }

    @Test(retryAnalyzer = Retry.class)//СОЗДАНИЕ ЗАДАЧИ
    public void createTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//ВСПЛЫВАЮЩЕЕ СООБЩЕНИЕ
    public void contextMessage() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)//ДИАЛОГОВОЕ ОКНО
    public void dialogWindow() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskPage.getSummaryField().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class, dependsOnMethods = "createTask")//УДАЛЕНИЕ ЗАДАЧИ
    public void DeleteTask() throws InterruptedException {
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

    /*@Test//ВОСПРОИЗВЕДЕНИЕ ДЕФФЕКТА
    public void DefectTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }*/
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

