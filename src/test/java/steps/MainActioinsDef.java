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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.Randomization;
import utils.Waits;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainActioinsDef {
    private WebDriver driver;
    private Waits waits;
    private DataBaseService dataBaseService;
    private Task addTask;

    private static final Logger logger = LogManager.getLogger(MainActioinsDef.class);

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
                .withUsername(System.getProperty("USERNAME"))
                .withPassword(System.getProperty("PASSWORD"))
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

        logger.info("create the task");

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

        logger.info("task is displayed");
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

        logger.info("task is not displayed");
    }

    @Step
    @Then("get visible context message")
    public void getVisibleContextMessage() {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());

        logger.info("get visible context message");
    }

    @Step
    @Then("check  dialog window visibility")
    public void checkDialogWindowVisibility() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskPage.getSummaryField().isDisplayed());

        logger.info("check  dialog window visibility");
    }

    @Step
    @When("put different {string} in the name field")
    public void putDifferentValueInTheNameField(String projectName) {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithLimitValue(projectName);

        logger.info("put different value in the name field");
    }

    @Step
    @Then("value is {int}")
    public void valueIs(int size) {
        ProjectDataPage projectDataPage = new ProjectDataPage(driver);
        if (size <= 1 || size >= 81) {
            Assert.assertTrue(projectDataPage.getWarningMessenger().isDisplayed());
            logger.info("invalid value");
        } else {
            Assert.assertTrue(projectDataPage.getProjectCreateButton().isDisplayed());
            logger.info("appropriate value");
        }
    }

    @Step
    @When("open task window")
    public void openTaskWindow() {
        Header header = new Header(driver);
        header.getCreateButton().click();

        logger.info("open task window");
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

        logger.info("uploading file and check that the file is loaded");
    }

    @Step
    @When("put wrong key")
    public void putWrongKey() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();

        logger.info("put wrong key");
    }

    @Step
    @Then("wrong data message is displayed")
    public void wrongDataMessageIsDisplayed() {
        ProjectDataPage projectDataPage = new ProjectDataPage(driver);
        Assert.assertTrue(projectDataPage.getKeyWarningMessenger().isDisplayed());

        logger.info("wrong data message is displayed");
    }

    @Step
    @Then("defect is displayed")
    public void defectIsDisplayed() {
        ProjectDataPage projectDataPage = new ProjectDataPage(driver);
        Assert.assertTrue(projectDataPage.getProjectCreateButton().isDisplayed());

        logger.info("defect is displayed");
    }

    @Step
    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        waits.waitForVisibility(addTaskPage.getSummaryField());
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());

        logger.info("error message is displayed");
    }
}
