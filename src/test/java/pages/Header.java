package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//span[@aria-label='Appswitcher Icon']");

    protected By createButtonSelector = By.xpath("//span[text()='Create']");
    protected By projectsButtonSelector = By.xpath("//div[@class='css-d6vpf6']/preceding::div[@class='css-d6vpf6']");
    protected By createProjectButtonSelector = By.xpath("//button[@class='css-f6nuwn']");
    protected By searchFieldSelector = By.xpath("//input[@data-test-id='search-dialog-input']");

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

    public WebElement getProjectsButton() {
        waits.waitForVisibility(projectsButtonSelector);
        return driver.findElement(projectsButtonSelector);
    }

    public WebElement getCreateProjectButton() {
        waits.waitForVisibility(createProjectButtonSelector);
        return driver.findElement(createProjectButtonSelector);
    }

    public WebElement getCreateButton() {
        waits.waitForVisibility(createButtonSelector);
        return driver.findElement(createButtonSelector);
    }

    public WebElement getSearchField() {
        waits.waitForVisibility(searchFieldSelector);
        return driver.findElement(searchFieldSelector);
    }

}
