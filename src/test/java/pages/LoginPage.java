package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//input[@name= 'username']");
    protected By login_field_selector = By.xpath("//input[@name= 'username']");
    protected By password_field_selector = By.xpath("//input[@name= 'password']");
    protected By login_button_selector = By.xpath("//button[@class= 'css-siava9']");


    @Override
    protected void openPage() {
        driver.get(ReadProperties.getLogin_Url());
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getLoginField() {
        return driver.findElement(login_field_selector);
    }
    public WebElement getPasswordField() {
        return waits.waitForVisibility(password_field_selector);}
    public WebElement getLoginButton() {return waits.waitForVisibility(login_button_selector);}
}
