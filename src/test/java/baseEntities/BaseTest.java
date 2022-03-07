package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import enums.TypesOfTask;
import models.Project;
import models.Task;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.LoginStep;
import utils.Listener;
import utils.Randomization;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;
    protected Task addTask;
    protected Project project;
    protected User user;
    protected Task updateTask;

    @BeforeTest
    public void setUpData() {

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
   @BeforeMethod (dependsOnMethods = "setUp")
    public void Login(){
        LoginStep loginStep=new LoginStep(driver);
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
}

