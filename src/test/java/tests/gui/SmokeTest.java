package tests.gui;

import baseEntities.BaseTest;
import data.data.provider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChooseProjectPage;
import pages.Header;
import pages.ProjectTypePage2;
import steps.ProjectStep;

public class SmokeTest extends BaseTest {

    @Test (dataProvider = "dataForLimitValues", dataProviderClass = provider.StaticProvider.class)
    public void LimitValueTest(String a){
        ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProjectWithLimitValue(a);
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        if (a.length()==1 | a.length()==81){
            Assert.assertTrue(projectTypePage2.getWarningMessenger().isDisplayed());
        }else {
            Assert.assertEquals(projectTypePage2.getWarningMessengerSize(),1);
            projectTypePage2.getProjectCreateButton().click();
        }
    }
    @Test
    public void UploadFileTest() throws InterruptedException {
        /*ProjectStep projectStep=new ProjectStep(driver);
        projectStep.createProject();
        Header header = new Header(driver);
        header.getProjectsButton().click();
        header.getShowProjectButton().click();
        ChooseProjectPage chooseProjectPage=new ChooseProjectPage(driver);*/
        Header header = new Header(driver);
        header.getCreateButton().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;





    }
}
