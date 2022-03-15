package pages;

import baseEntities.BasePage;
import models.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
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

    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='search-title']");




    public WebElement getNessesaryTaskSelector(Task task){
       /// waits.waitForVisibility(By.xpath(a.replace("replace",task.getSummary().toString())));
        return driver.findElement(By.xpath("//a[text()='replace']".replace("replace",task.getSummary())));
    }

}
