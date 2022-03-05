package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import models.Project;
import models.Task;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.LoginStep;
import steps.ProjectStep;
import utils.Listener;
import utils.Randomization;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void LogIn(){
        LoginStep loginStep=new LoginStep(driver);
        loginStep.login();
    }

   /*@BeforeTest
    public void setUpData() {
       Project project=new Project.Builder()
               .withName(Randomization.getRandomString(5))
               .build();
       User user=new User.Builder()
               .withUsername(ReadProperties.getUsername())
               .withPassword(ReadProperties.getPassword())
               .build();
   }*/


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

