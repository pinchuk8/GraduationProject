package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.Listener;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;
   

    @BeforeMethod
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);


        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void closePage() {
        driver.quit();
    }
}

