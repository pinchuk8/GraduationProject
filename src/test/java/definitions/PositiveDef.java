package definitions;

import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Project;
import models.Task;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import steps.ProjectStep;
import steps.TaskStep;
import utils.Randomization;
import utils.Waits;


public class PositiveDef {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;
    protected Task addTask;
    protected Project project;
    protected User user;


    @Given("open page")
    public void openPage() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());
    }
    @And("create models")
    public void createModels() {
        user = new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();

        project = new Project.Builder()
                .withName(Randomization.getRandomString(5))
                .build();

        addTask = new Task.Builder()
                .withSummary(Randomization.getRandomString(10))
                .withDescription(Randomization.getRandomString(25))
                .build();
    }
    @And("login")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginField().click();
        loginPage.getLoginField().sendKeys(user.getUsername());
        loginPage.getLoginButton().isDisplayed();
        loginPage.getLoginButton().click();
        Thread.sleep(5000);
        loginPage.getPasswordField().sendKeys(user.getPassword());
        loginPage.getLoginButton().click();
    }
    @Then("close browser")
    public void closeBrowser() {
        driver.quit();
    }
    @Given("creating task with invalid summary field")
    public void creatingTaskWithInvalidSummaryField() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        addTaskPage.getSummaryField().sendKeys(Randomization.getRandomString(256));
        addTaskPage.getCreateButton().click();
    }
    @Then("wrong massage is visible")
    public void wrongMassageIsVisible() {
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskPage.getErrorMessageField().isDisplayed());
    }
    @Given("create task and get visible context message")
    public void contextMessage() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }
    @Then("check that there's task")
    public void checkThatThereIsTask() {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getCreateTaskMessage().isDisplayed());
    }
    @Given("creating task")
    public void creatingTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.addTask(addTask);
    }
    @Given("open dialog window and check it's visibility")
    public void dialogWindow() {
        Header header = new Header(driver);
        header.getCreateButton().click();
        AddTaskWindow addTaskPage = new AddTaskWindow(driver);
        Assert.assertTrue(addTaskPage.getSummaryField().isDisplayed());
    }
    @Given("removing task")
    public void removingTask() {
        TaskStep taskStep = new TaskStep(driver);
        taskStep.deleteTask(addTask);
    }
    @Then("check that there's no task")
    public void checkThatThereIsNoTask() {
        YouWorkPage youWorkPage = new YouWorkPage(driver);
        Assert.assertTrue(youWorkPage.getNessesaryTask().getAttribute("innerText") != addTask.getSummary());
    }
    @Given("creating project with wrong keys")
    public void WrongDataTest() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
    }
    @Then("get a key warning message")
    public void getAKeyWarningMessage() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
    }
    @Given("opening page with fields for creating project")
    public void openThePageWithFieldsForCreatingProject() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();
    }
    @And("enter 1 symbol")
    public void enter_1_Symbol() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(Randomization.getRandomString(1));
    }
    @And("enter 2 symbols")
    public void enter_2_Symbol() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(Randomization.getRandomString(2));
    }
    @And("enter 3 symbols")
    public void enterSymbol() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(Randomization.getRandomString(3));
    }
    @And("enter 80 symbols")
    public void enter_80_Symbol() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(Randomization.getRandomString(80));
    }
    @And("enter 81 symbols")
    public void enter_81_Symbol() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(Randomization.getRandomString(1));
    }
    @Then("get a warning message")
    public void getAWarningMessage() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
    }
    @And("clear the field")
    public void clearTheField() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().clear();
    }
    @Then("create button is enabled")
    public void createButtonIsEnabled() {
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isEnabled());
    }
}
