package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseProjectPage extends BasePage {
    private static String ENDPOINT = "/jira/projects";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//div[@class='css-1pa8dxh']");


    public ChooseProjectPage(WebDriver driver) {
        super(driver);
    }

    public ChooseProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
}
