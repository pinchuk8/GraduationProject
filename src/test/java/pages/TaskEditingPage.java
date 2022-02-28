package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskEditingPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Description']");

    protected By attachLinkSelector = By.xpath("//*[@aria-label = 'Attach']");
    protected By createSubtaskLinkSelector = By.xpath("//*[@aria-label = 'Create subtask']");
    protected By addSmthLinkSelector = By.xpath("//*[@aria-label = 'Link issue']");
    protected By addApplicationLinkSelector = By.xpath("//*[@aria-label = 'Add app']");
    protected By descriptionFieldSelector = By.xpath("//*[@class = 'a1u0y8-0 eXYHSAэ]");
    protected By environmentFieldSelector = By.xpath("//*[@class = 'a1u0y8-0 eXYHSA']");
    protected By commentSaveButtonSelector = By.xpath("//*[@data-testid = 'comment-save-button']");
    protected By commentCancelButtonSelector = By.className("css-p02cbl");
    protected By settingLinkSelector = By.xpath("//*[@aria-label = 'Actions']");
    protected By deleteTaskLinkSelector = By.xpath("//*[@class = 'ItemParts__Content-sc-14xek3m-5 jRBaLt' and  . = 'Delete']");
    protected By deleteButtonSelector = By.xpath("//*[@data-testid = 'common.components.confirmation-modal.confirm-button']");
    protected By cancelButtonSelector = By.xpath("//*[@data-testid = 'common.components.confirmation-modal.cancel-button']");

    public TaskEditingPage(WebDriver driver) {
        super(driver);
    }

    public TaskEditingPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return false;
    }

    public WebElement getAttachLink() {
        return driver.findElement(attachLinkSelector);
    }

    public WebElement getCreateSubtaskLink() {
        return driver.findElement(createSubtaskLinkSelector);
    }

    public WebElement getAddSmthLink() {
        return driver.findElement(addSmthLinkSelector);
    }

    public WebElement getAddApplicationLink() {
        return driver.findElement(addApplicationLinkSelector);
    }

    public WebElement getDescriptionField() {
        return driver.findElement(descriptionFieldSelector);
    }

    public WebElement getEnvironmentField() {
        return driver.findElement(environmentFieldSelector);
    }

    public WebElement getCommentSaveButton() {
        return driver.findElement(commentSaveButtonSelector);
    }

    public WebElement getCommentCancelButton() {
        return driver.findElement(commentCancelButtonSelector);
    }

    public WebElement getSettingLink() {
        return driver.findElement(settingLinkSelector);
    }

    public WebElement getDeleteTaskLink() {
        return driver.findElement(deleteTaskLinkSelector);
    }

    public WebElement getDeleteButton() {
        return driver.findElement(deleteButtonSelector);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButtonSelector);
    }
}
