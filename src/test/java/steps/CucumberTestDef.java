package steps;

import core.BrowsersService;
import core.DataBaseService;
import core.ReadProperties;
import dbEntries.TaskTable;
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
import org.testng.log4testng.Logger;
import pages.*;
import utils.Randomization;
import utils.Waits;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CucumberTestDef {
    private WebDriver driver;
    private Waits waits;
    private DataBaseService dataBaseService;
    private Task addTask;

    public  static Logger logger = Logger.getLogger(CucumberTestDef.class);

    @Step
    @Given("set up connection")
    public void setUpConnection(){
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService = new DataBaseService();
    }

    @Step
    @Given("browser is started")
    public void browserIsStarted() {
        driver = new BrowsersService().getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());

        logger.info("browser is started");
    }

    @Step
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot on fail", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        if (driver != null) {
            driver.quit();
        }
        if (dataBaseService!=null){
            dataBaseService.closeConnection();
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

        logger.info("user logged in");
    }

    @Step
    @And("create project")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();

        logger.info("create project");
    }

    @Step
    @And("create the task")
    public void createdTask() {
        TaskTable descriptionTable = new TaskTable(dataBaseService);

        descriptionTable.dropTable(dataBaseService);
        descriptionTable.createTable(dataBaseService);
        descriptionTable.addTask(dataBaseService, Randomization.getRandomString(5), "task for student");
        ResultSet rs = descriptionTable.getAllTasks(dataBaseService);
        try {
            while (rs.next()) {
                String summary = rs.getString("summary");
                String description = rs.getString("description");
                logger.info("summary: " + summary);
                logger.info("description: " + description);
                addTask = new Task.Builder()
                        .withSummary(summary)
                        .withDescription(description)
                        .build();
            }
        } catch (
                SQLException e) {
            logger.error(e.toString());
        }
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

        logger.info("task deleted");
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
            logger.info("invalid value");
        } else {
            Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
            logger.info("appropriate value");
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
        File file = new File("src\\test\\resources\\data\\picture.png");
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