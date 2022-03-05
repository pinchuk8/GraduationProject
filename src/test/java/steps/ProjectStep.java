package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ChooseProjectPage;
import pages.Header;
import pages.ProjectTypePage;
import pages.ProjectTypePage2;
import utils.Randomization;

public class ProjectStep extends BaseStep {
    private Header header;

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void createProject(Project project) {
        Header header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        ProjectTypePage projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(project.getName());
        projectTypePage2.getProjectCreateButton().click();
    }
    public void createProjectWithLimitValue(String a) {
        Header header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        ProjectTypePage projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        projectTypePage2.getProjectNameField().sendKeys(a);
    }
    public void createProjectWithWrongKey(){
        Header header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        ProjectTypePage projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
        ProjectTypePage2 projectTypePage2=new ProjectTypePage2(driver);
        projectTypePage2.getProjectKeyField().sendKeys(Randomization.getRandomString(1));
    }
}
