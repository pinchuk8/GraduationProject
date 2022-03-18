package utils;

import baseEntities.BaseTest;
import core.BrowsersService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();
        try {
            WebDriver driver = ((BrowsersService) currentClass).getDriver();
            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);
        } catch (Exception ex) {
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
