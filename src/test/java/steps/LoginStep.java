package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }
    public void login(){
        User user=new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getLoginField().click();

        loginPage.getLoginField().sendKeys(user.getUsername());

        loginPage.getLoginButton().isDisplayed();
        loginPage.getLoginButton().click();
        loginPage.getPasswordField().sendKeys(user.getPassword());
        loginPage.getLoginButton().click();

    }
}
