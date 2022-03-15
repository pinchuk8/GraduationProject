package utils;

import utils.Randomization;


public class DataProvider {
    public static class StaticProvider {
        @org.testng.annotations.DataProvider(name = "dataForLimitValues")
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
