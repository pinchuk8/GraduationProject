package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(User user)  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginField().click();
        loginPage.getLoginField().sendKeys(user.getUsername());
        loginPage.getLoginButton().isDisplayed();
        loginPage.getLoginButton().click();
        loginPage.getPasswordField().isDisplayed();
        loginPage.getPasswordField().sendKeys(user.getPassword());
        loginPage.getLoginButton().click();
    }
}
