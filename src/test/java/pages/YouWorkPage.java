package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouWorkPage extends BasePage {
    private static String ENDPOINT = "/jira/your-work";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//span[text()='Create']");
    protected By createdTaskMessageSelector = By.xpath("//*[contains(text(), 've created')]");
    protected By viewIssueSelector = By.xpath("//*[contains(text(), 'View issue')]");
    protected By nessesaryProjectSelector = By.xpath("//span[@class='seye2t-6 ejpKgl']");

    @Override
    public void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public YouWorkPage(WebDriver driver) {
        super(driver);
    }

    public YouWorkPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    public WebElement getCreateTaskMessage()  {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createdTaskMessageSelector));
        return driver.findElement(createdTaskMessageSelector);
    }

   public WebElement getNessesaryProject() {
        return waits.waitForVisibility(nessesaryProjectSelector);}
    public WebElement getViewIssue() {
        return waits.waitForVisibility(viewIssueSelector);}
}
