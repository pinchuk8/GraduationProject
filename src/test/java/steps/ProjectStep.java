package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProjectTypePage;
import pages.ProjectTypePage2;
import utils.Randomization;

public class ProjectStep extends BaseStep {
    private Header header;
    private ProjectTypePage projectTypePage;
    private ProjectTypePage2 projectTypePage2;

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void createProject() {
        header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
    }

    public void createProjectWithLimitValue(String a) {
        projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(a);
    }

    public void createProjectWithWrongKey() {
        projectTypePage2 = new ProjectTypePage2(driver);
        projectTypePage2.getProjectKeyField().sendKeys(Randomization.getRandomString(1));
    }
}
