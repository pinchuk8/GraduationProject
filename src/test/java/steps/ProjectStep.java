package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.Header;
import pages.ProjectTypePage;

public class ProjectStep extends BaseStep {
    private Header header;

    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void createProject(Project addProject) throws InterruptedException {
        header = new Header(driver);
        header.getProjectsButton().click();
        header.getCreateProjectButton().click();
        ProjectTypePage projectTypePage = new ProjectTypePage(driver);
        projectTypePage.getBagTrackingButton().click();
        projectTypePage.getTemplateButton().click();
        projectTypePage.getProjectNameField().sendKeys(addProject.getName());
        projectTypePage.getProjectCreateButton().click();
    }
}
