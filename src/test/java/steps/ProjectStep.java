package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ChooseProjectPage;
import pages.Header;
import pages.ProjectTypePage;
import utils.Randomization;

public class ProjectStep extends BaseStep {
    public Project project=new Project.Builder()
            .withName(Randomization.getRandomString(5))
            .build();

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
        projectTypePage.getProjectNameField().sendKeys(project.getName());
        projectTypePage.getProjectCreateButton().click();
    }
}
