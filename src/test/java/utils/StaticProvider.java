package utils;

import org.testng.annotations.DataProvider;
import utils.Randomization;


public class StaticProvider {

    @DataProvider(name = "dataForLimitValues")
    public Object[][] dataForSomeFunction() {
        return new Object[][]{
                {Randomization.getRandomString(1)},
                {Randomization.getRandomString(2)},
                {Randomization.getRandomString(81)},
        };
    }
}
