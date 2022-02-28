package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//span[@aria-label='Appswitcher Icon']");
    protected By projects_button_selector = By.xpath("//div[@class='css-d6vpf6']/preceding::div[@class='css-d6vpf6']");
    protected By createTask_button_selector = By.id("createGlobalItem");
    protected By createProject_button_selector = By.xpath("//button[@class='css-s37vvz']");
    protected By showProject_button_selector = By.xpath("//a[@href='/jira/projects']");

    public Header(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {

    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
    public WebElement getProjectsButton(){
        return driver.findElement(projects_button_selector);
    }
    public WebElement getCreateTaskButton(){
        return driver.findElement(createTask_button_selector);
    }
    public WebElement getCreateProjectButton(){
        return driver.findElement(createProject_button_selector);
    }
    public WebElement getShowProjectButton(){
        return driver.findElement(showProject_button_selector);
    }


}
