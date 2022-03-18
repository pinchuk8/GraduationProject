package utils;

import core.BrowsersService;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class NGTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On Test Failure");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
    }
}
