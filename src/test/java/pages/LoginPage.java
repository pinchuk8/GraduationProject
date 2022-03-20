package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//input[@name= 'username']");

    protected By loginFieldSelector = By.xpath("//input[@name= 'username']");
    protected By passwordFieldSelector = By.xpath("//input[@name= 'password']");
    protected By loginButtonSelector = By.xpath("//button[@class= 'css-siava9']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(ReadProperties.getLogin_Url());
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getLoginField() {return waits.waitForVisibility(loginFieldSelector);}

    public WebElement getPasswordField() {
        return waits.waitForVisibility(passwordFieldSelector);
    }

    public WebElement getLoginButton() {
        return waits.waitForVisibility(loginButtonSelector);
    }
}
