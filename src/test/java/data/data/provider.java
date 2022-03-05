package data.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import utils.Randomization;


public class provider {
    public static class StaticProvider {
        //protected By warning_messenger_selector = By.xpath("//button[@class='css-wbe0z8']");
        @DataProvider(name = "dataForLimitValues")
        public Object[][] dataForSomeFunction() {
            return new Object[][]{
                    {Randomization.getRandomString(1)},
                    {Randomization.getRandomString(2)},
                    {Randomization.getRandomString(3)},
                    {Randomization.getRandomString(80)},
                    {Randomization.getRandomString(81)},
            };
        }
    }
}
