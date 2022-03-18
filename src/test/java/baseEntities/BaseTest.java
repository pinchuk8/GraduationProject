package baseEntities;

import core.BrowsersService;
import core.DataBaseService;
import core.ReadProperties;
import dbEntries.TaskTable;
import models.Project;
import models.Task;
import models.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.LoginStep;
import utils.Listener;
import utils.Randomization;
import utils.Waits;

import java.sql.ResultSet;
import java.sql.SQLException;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;
    protected Task addTask;
    protected Project project;
    protected User user;
    protected DataBaseService dataBaseService;

    @BeforeTest
    public void setUpConnection() {
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }

    @BeforeTest(dependsOnMethods = "setUpConnection")
    public void setUpData() {
        Logger logger = Logger.getLogger(BaseTest.class);
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

        user = new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();

        project = new Project.Builder()
                .withName(Randomization.getRandomString(5))
                .build();
    }

    @BeforeMethod(dependsOnMethods = "setUp")
    public void Login() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(user);
    }

    @BeforeMethod
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void closePage() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

