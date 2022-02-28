package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static String LOGIN_URL = "https://id.atlassian.com/login?application=jira&continue=https%3A%2F%2Ftmsproject.atlassian.net&prompt=login";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//input[@name= 'username']");//By.xpath("//div[@class='sc-htpNat gcUlsV']//*[@viewBox='0 0 69 32']");
    protected By login_field_selector = By.xpath("//input[@name= 'username']");
    protected By password_field_selector = By.xpath("//input[@name= 'password']");
    protected By login_button_selector = By.xpath("//button[@class= 'css-siava9']");


    @Override
    protected void openPage() {
        driver.get((LOGIN_URL));
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getLoginField() {
        return driver.findElement(login_field_selector);
    }

    public WebElement getPasswordField() {
        waits.waitForVisibility(password_field_selector);
        return driver.findElement(password_field_selector);
    }

    public WebElement getLoginButton() {
        return driver.findElement(login_button_selector);
    }
}
