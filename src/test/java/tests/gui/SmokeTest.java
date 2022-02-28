package tests.gui;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.Header;
import steps.LoginStep;
import steps.ProjectStep;

public class SmokeTest extends BaseTest {
    @Test
    public void test ()  {
        LoginStep loginStep=new LoginStep(driver);
        loginStep.login();
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProject();
    }

}
