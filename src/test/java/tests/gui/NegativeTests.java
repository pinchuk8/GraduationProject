package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectTypePage2;
import steps.ProjectStep;

public class NegativeTests extends BaseTest {
    @Test
    public void WrongDataTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getKeyWarningMessenger().isDisplayed());
    }
    @Test
    public void DefectTest(){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithWrongKey();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        Assert.assertTrue(projectTypePage2.getProjectCreateButton().isDisplayed());
    }


}
