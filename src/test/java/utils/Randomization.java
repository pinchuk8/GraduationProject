package utils;

import baseEntities.BasePage;
import enums.TypesOfTask;
import org.openqa.selenium.WebDriver;
import pages.AddTaskPage;

import java.util.Random;

public class Randomization {

    public static String getRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static int gerRandomInt(int rightBound) {
        Random rnd = new Random();
        return rnd.nextInt(rightBound);
    }

    public static void getRandomTaskType() {
        AddTaskPage addTaskPage = null;
        Random rnd = new Random();
        int a = rnd.nextInt(4);
        switch (a) {
            case 0:
                addTaskPage.taskTypeTask();
                break;
            case 1:
                addTaskPage.improvementTypeTask();
                break;
            case 2:
                addTaskPage.newFeatureTypeTask();
                break;
            case 3:
                addTaskPage.bugTypeTask();
                break;
            default:
                System.out.println("Invalid task type");
        }
    }
}

