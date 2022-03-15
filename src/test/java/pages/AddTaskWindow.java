package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaskWindow extends BasePage {
    private static String ENDPOINT = "/jira/projects";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@class = 'css-1aseh1t e1rcei0k1']");

    protected By summaryFieldSelector = By.xpath("//input[@name= 'summary']");
    protected By ErrorMessageSelector = By.xpath("//div[@id='summary-field-error']");
    protected By descriptionFieldSelector = By.xpath("//*[@id = 'description-field-label']/../div//input/../following-sibling::div");
    protected By createButtonSelector = By.xpath("//*[@data-testid = 'issue-create.ui.modal.footer.create-button']");
    protected By import_issues_selector = By.xpath("//span[text()='Import issues']");

    public AddTaskWindow(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
    public WebElement getImportIssues() {
        waits.waitForVisibility(import_issues_selector);
        return driver.findElement(import_issues_selector);}

    public WebElement getSummaryField() {
        waits.waitForVisibility(summaryFieldSelector);
        return driver.findElement(summaryFieldSelector);
    }

    public WebElement getErrorMessageField() {
        waits.waitForVisibility(ErrorMessageSelector);
        return driver.findElement(ErrorMessageSelector);
    }

    public WebElement getDescriptionField() {
        waits.waitForVisibility(descriptionFieldSelector);
        return driver.findElement(descriptionFieldSelector);
    }

    public WebElement getCreateButton() {
        waits.waitForVisibility(createButtonSelector);
        return driver.findElement(createButtonSelector);
    }
}

//    protected By downLoadButtonSelector1 = By.xpath("//span[text()='browse']");
//    protected By downLoadButtonSelector = By.xpath("//div[@id='attachment-dropzone-container']");
//    protected By downLoadButtonSelector2 = By.xpath("//span[@class='sc-1apavjx-3 ioOEtG']");
//    protected By downLoadButtonSelector3 = By.xpath("//*[@id='attachment-dropzone-container']/span/button");
//
//    public WebElement getDownloadFileButton(){
//        waits.waitForVisibility(downLoadButtonSelector);
//        return driver.findElement(downLoadButtonSelector);
//    }
//    public WebElement getDownloadFileButton1(){
//        waits.waitForVisibility(downLoadButtonSelector1);
//        return driver.findElement(downLoadButtonSelector1);
//    }
//    public WebElement getDownloadFileButton2(){
//        waits.waitForVisibility(downLoadButtonSelector2);
//        return driver.findElement(downLoadButtonSelector2);
//    }
//    public WebElement getDownloadFileButton3(){
//        waits.waitForVisibility(downLoadButtonSelector3);
//        return driver.findElement(downLoadButtonSelector3);
//    }




   /* public void scrollToElement () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getDownloadFileButton1());
        waits.waitForClickable(getDownloadFileButton1());
       // getDownloadFileButton1().sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg");
        //getDownloadFileButton2().click();
        Thread.sleep(5000);
        getDownloadFileButton3().sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg");
        Thread.sleep(10000);
        Actions actions=new Actions(driver);
        actions
                .moveToElement(getDownloadFileButton1()).sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg")
                // .sendKeys(getDownloadFileButton(),"C:\\Users\\user\\Desktop\\picture2.jpg")
                .perform();
        //actions.moveToElement(getDownloadFileButton()).sendKeys("C:\\Users\\user\\Desktop\\picture2.jpg").build().perform();*/



  /*  JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver)
                // .executeScript("arguments[0].scrollIntoView(true);",getDownloadFileButton().sendKeys("C:\Users\Ольга Пинчук\Desktop\DGKsFOrTvVM (1).jpg)");
            .executeScript("arguments[0].scrollIntoView(true);",getDownloadFileButton1());*/
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

