package steps;

import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import models.Task;
import models.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.Randomization;
import utils.Waits;

import java.io.ByteArrayInputStream;
import java.io.File;

public class PositiveTestDef {
    private WebDriver driver;
    private Waits waits;

    private Task addTask;

    @Step
    @Given("browser is started")
    public void browserIsStarted() {
        driver = new BrowsersService().getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());
    }

    @Step
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot on fail", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
//        try{
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            if (scenario.isFailed()) {
//                scenario.log("this is mt failure message");
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", screenshotName);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Step
    @When("user logged in")
    public void userLoggedIn() {
        User user = new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(user);
    }

    @Step
    @And("create project")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();
    }

    @Step
    @And("create the task")
    public void createdTask() {
        addTask = new Task.Builder()
                .withSummary(Randomization.getRandomString(10))
                .withDescription(Randomization.getRandomString(25))
                .build();
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
    }

    @Step
    @Then("task is displayed")
    public void taskDisplayed() {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Step
    @When("delete the task")
    public void deleteTheTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.deleteTask(addTask);
    }

    @Step
    @Then("task is not displayed")
    public void taskIsNotDisplayed() {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.getNessesaryTaskSelector1(addTask).size(), 0);
    }

    @Step
    @Then("get visible context message")
    public void getVisibleContextMessage() {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }

    @Step
    @Then("check  dialog window visibility")
    public void checkDialogWindowVisibility() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskPage.getSummaryField().isDisplayed());
    }

    @Step
    @When("put different {string} in the name field")
    public void putDifferentValueInTheNameField(String projectName) {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithLimitValue(projectName);
    }

    @Step
    @Then("value is {int}")
    public void valueIs(int size) {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        if (size <= 1 || size >= 81) {
            Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
        } else {
            Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
        }
    }

    @Step
    @When("open task window")
    public void openTaskWindow() {
        Header header = new Header(driver);
        header.getCreateButton().click();
    }

    @Step
    @Then("uploading file and check that the file is loaded")
    public void uploadingFileAndCheckThatTheFileIsLoaded() {
        AddTaskWindow addTaskWindow = new AddTaskWindow(driver);
        waits.waitForClickable(addTaskWindow.getImportIssues());
        addTaskWindow.getImportIssues().click();
        DownLoadPage downLoadPage = new DownLoadPage(driver);
        File file = new File("src\\test\\resources\\picture.png");
        downLoadPage.getDownloadButton().sendKeys(file.getAbsolutePath());
        Assert.assertTrue(downLoadPage.getNextButton().isDisplayed());
    }

    @Step
    @When("put wrong key")
    public void putWrongKey() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
    }

    @Step
    @Then("wrong data message is displayed")
    public void wrongDataMessageIsDisplayed() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
    }

    @Step
    @Then("defect is displayed")
    public void defectIsDisplayed() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }

    @Step
    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        waits.waitForVisibility(addTaskPage.getSummaryField());
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());
    }
}
