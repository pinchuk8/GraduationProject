package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProjectTypePage;
import pages.ProjectDataPage;
import utils.Randomization;

public class ProjectStep extends BaseStep {
    private Header header;
    private ProjectTypePage projectTypePage;
    private ProjectDataPage projectDataPage;

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
        projectDataPage = new ProjectDataPage(driver);
        projectDataPage.getProjectNameField().sendKeys(a);
    }

    public void createProjectWithWrongKey() {
        projectDataPage = new ProjectDataPage(driver);
        projectDataPage.getProjectKeyField().sendKeys(Randomization.getRandomString(1));
    }
}
