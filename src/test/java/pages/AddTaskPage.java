package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTaskPage extends BasePage {
    private static String ENDPOINT = "/jira/projects";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@class = 'css-1aseh1t e1rcei0k1']");

    protected By summaryFieldSelector = By.xpath("//input[@name= 'summary']");
    protected By ErrorMessageSelector = By.xpath("//div[@id='summary-field-error']");
    protected By descriptionFieldSelector =By.xpath("//*[@id = 'description-field-label']/../div//input/../following-sibling::div");
    protected By createButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.create-button']");

    protected By downLoadButtonSelector1 = By.xpath("//span[text()='browse']");
    protected By downLoadButtonSelector = By.xpath("//div[@id='attachment-dropzone-container']");

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public AddTaskPage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getSummaryField()  {
        waits.waitForVisibility(summaryFieldSelector);
        return driver.findElement(summaryFieldSelector);
        }
    public WebElement getErrorMessageField() {
         return waits.waitForVisibility(ErrorMessageSelector);}
    public WebElement getDescriptionField() {
        return waits.waitForVisibility(descriptionFieldSelector);            }
    public WebElement getCreateButton() {/*WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButtonSelector));
        return driver.findElement(summaryFieldSelector);*/
        waits.waitForVisibility(createButtonSelector);
        return driver.findElement(createButtonSelector);}
    public WebElement getDownloadFileButton(){
        waits.waitForVisibility(downLoadButtonSelector);
        return driver.findElement(downLoadButtonSelector);
    }
    public WebElement getDownloadFileButton1(){
        waits.waitForVisibility(downLoadButtonSelector1);
        return driver.findElement(downLoadButtonSelector1);
    }


    protected By typeTaskDropDownSelector = By.xpath("//*[text() = 'Issue type']/following-sibling::div");
    protected By epicTypeTaskSelector = By.xpath("//*[. = 'Epic']");
    protected By bugTypeTaskSelector = By.xpath("//*[. = 'Bug']");
    protected By improvementTypeTaskSelector = By.xpath("//*[. = 'Improvement']");
    protected By newFeatureTypeTaskSelector = By.xpath("//*[. = 'New Feature']");
    protected By taskTypeTaskSelector = By.xpath("//*[. = 'Task']");
    protected By typeOfPriorityDropDownSelector = By.xpath("//*[@id = 'priority-field-label']/..");
    protected By highestPrioritySelector = By.xpath("//*[. = 'Highest']");
    protected By highPrioritySelector = By.xpath("//*[. = 'High']");
    protected By mediumPrioritySelector = By.xpath("//*[. = 'Medium']");
    protected By lowPrioritySelector = By.xpath("//*[. = 'Low']");
    protected By lowestPrioritySelector = By.xpath("//*[. = 'Lowest']");
    protected By cancelButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.cancel-button']");

    public WebElement getTypeTaskDropDown() {return driver.findElement(typeTaskDropDownSelector);    }

    public WebElement getEpicTypeTask() { return driver.findElement(epicTypeTaskSelector);    }
    public WebElement getBugTypeTask() { return driver.findElement(bugTypeTaskSelector);    }
    public WebElement getImprovementTypeTask() { return driver.findElement(improvementTypeTaskSelector);    }
    public WebElement getNewFeatureTypeTask() { return driver.findElement(newFeatureTypeTaskSelector);    }
    public WebElement getTaskTypeTask() { return driver.findElement(taskTypeTaskSelector);    }

    public void epicTypeTask() {
        getEpicTypeTask().click();
    }

    public void bugTypeTask() {
        getBugTypeTask().click();
    }

    public void improvementTypeTask() {
        getImprovementTypeTask().click();
    }

    public void newFeatureTypeTask() {
        getNewFeatureTypeTask().click();
    }

    public void taskTypeTask() {
        getTaskTypeTask().click();
    }


    public WebElement getTypeOfPriorityDropDown() {return driver.findElement(typeOfPriorityDropDownSelector);    }
    public WebElement getHighestPriority() {return driver.findElement(highestPrioritySelector);    }
    public WebElement getHighPriority() {return driver.findElement(highPrioritySelector);    }
    public WebElement getMediumPriority() {return driver.findElement(mediumPrioritySelector);    }
    public WebElement getLowPriority() {return driver.findElement(lowPrioritySelector);    }
    public WebElement getLowestPriority() {return driver.findElement(lowestPrioritySelector);    }
    public WebElement getCancelButton() {return driver.findElement(cancelButtonSelector);    }


    public void scrollToElement () throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver)
                // .executeScript("arguments[0].scrollIntoView(true);",getDownloadFileButton().sendKeys("C:\Users\Ольга Пинчук\Desktop\DGKsFOrTvVM (1).jpg)");
            .executeScript("arguments[0].scrollIntoView(true);",getDownloadFileButton1());
        //Thread.sleep(10000);
        // getDownloadFileButton().sendKeys("C:\\Users\\Desktop\\picture.png");
      //  getDownloadFileButton().sendKeys("\u202AC:\\Users\\user\\Desktop\\picture2.jpg");
        //getDownloadFileButton().sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg");
        //getDownloadFileButton().click();

       // JavascriptExecutor js2 = (JavascriptExecutor) driver;
       // js2.executeScript("getDownloadFileButton.sendKeys('C:\\Users\\user\\Desktop\\picture2.jpg');", getDownloadFileButton());
        //js2.executeScript("getDownloadFileButton().value='C:\\Users\\user\\Desktop\\picture2.jpg';");
        /*Actions actions=new Actions(driver);
        actions
                .moveToElement(getDownloadFileButton()).sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg")
               // .sendKeys(getDownloadFileButton(),"C:\\Users\\user\\Desktop\\picture2.jpg")
                                .perform();*/
        //actions.moveToElement(getDownloadFileButton()).sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg").build().perform();
        //actions.keyDown(getDownloadFileButton(),"C:\\Users\\user\\Desktop\\picture2.jpg");
        //Thread.sleep(100000);

       // getDownloadFileButton().sendKeys("C:\\Users\\Рабочий стол\\picture.png");
        //Thread.sleep(10000);
       /* getDownloadFileButton().sendKeys("C:\\Users\\Desktop\\picture.png");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("путь к файлу");
        driver.findElement(By.cssSelector("Кнопка старта загрузки")).click();
        wait.until(ExpectedConditions.invisibilityOf(loader));*/

    }
}
