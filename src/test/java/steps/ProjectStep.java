package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProjectTypePage;
import pages.ProjectTypePage2;
import utils.Randomization;

public class ProjectStep extends BaseStep {

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void createProject() {
        Header header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        ProjectTypePage projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
    }

    public void createProjectWithLimitValue(String a) {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(a);
    }

    public void createProjectWithWrongKey() {
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.createProject();
        ProjectTypePage2 projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectKeyField().sendKeys(Randomization.getRandomString(1));
    }
}
