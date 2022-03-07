package tests.gui;

import baseEntities.BaseTest;
import data.data.provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTaskPage;
import pages.Header;
import pages.ProjectTypePage2;
import pages.YouWorkPage;
import steps.ProjectStep;
import steps.TaskStep;
import utils.Randomization;

public class SmokeTest extends BaseTest {
    //ГРАНИЧНЫЕ ЗНАЧЕНИЯ
    @Test(dataProvider = "dataForLimitValues", dataProviderClass = provider.StaticProvider.class)
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

    /*@Test//ЗАГРУЗКА ФАЙЛА
    public void UploadFileTest() throws InterruptedException {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskPage addTaskPage = new AddTaskPage(driver);
        Thread.sleep(10000);
        addTaskPage.scrollToElement();
        //addTaskPage.getDownloadFileButton().click();
        //addTaskPage.getDownloadFileButton().sendKeys();
        // Thread.sleep(5000);
    }*/

    @Test//СОЗДАНИЕ ЗАДАЧИ
    public void createTask() throws InterruptedException {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test//ВСПЛЫВАЮЩЕЕ СООБЩЕНИЕ
    public void contextMessage() throws InterruptedException {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Test//ДИАЛОГОВОЕ ОКНО
    public void dialogWindow() throws InterruptedException {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskPage addTaskPage = new AddTaskPage(driver);
        Assert.assertTrue(addTaskPage.getSummaryField().isDisplayed());
    }


    @Test//УДАЛЕНИЕ ЗАДАЧИ
    public void DeleteTask() throws InterruptedException {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        taskStep.deleteTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getNessesaryProject().getAttribute("innerText") != addTask.getSummary());
    }
    @Test//НЕКОРРЕКТНЫЕ ДАННЫЕ
    public void WrongDataTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
    }
    /*@Test//ВОСПРОИЗВЕДЕНИЕ ДЕФФЕКТА
    public void DefectTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }*/
    @Test//ПРЕВЫШАЮЩИЙ ДОПУСТИМЫЕ
    public void DataExceedingTheAllowable() throws InterruptedException {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskPage addTaskPage=new AddTaskPage(driver);
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());
    }
}

