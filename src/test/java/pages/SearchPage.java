package pages;

import baseEntities.BasePage;
import models.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='search-title']");

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNessesaryTaskSelector(Task task) {
        return driver.findElement(By.xpath("//a[text()='replace']".replace("replace", task.getSummary())));
    }

    public List<WebElement> getNessesaryTaskSelector1(Task task) {
        return driver.findElements(By.xpath("//a[text()='replace']".replace("replace", task.getSummary())));
    }
}
