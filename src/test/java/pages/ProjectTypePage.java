package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTypePage extends BasePage {
    private static String ENDPOINT = "/jira/your-work";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//div[@class='sc-3la0sj-2 ghEtRS']");

    protected By useBagTrackingButtonSelector = By.xpath("//span[@aria-label='Bug tracking']");
    protected By useTemplateButtonSelector = By.xpath("//button[@class='css-goggrm']");

    public ProjectTypePage(WebDriver driver) {
        super(driver);
    }

    public ProjectTypePage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getBagTrackingButton() {
        return driver.findElement(useBagTrackingButtonSelector);
    }

    public WebElement getTemplateButton() {
        waits.waitForVisibility(useTemplateButtonSelector);
        return driver.findElement(useTemplateButtonSelector);
    }
}
