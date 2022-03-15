package utils;


import pages.AddTaskWindow;

import java.util.Random;

public class Randomization {
    private AddTaskWindow addTaskPage;

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

   /* public static TypesOfTask getRandomTaskType() {
        Random rnd = new Random();
        int a = rnd.nextInt(4);
        switch (a) {
            case 0:
                return TypesOfTask.TASK;
            case 1:
                return TypesOfTask.IMPROVEMENT;
            case 2:
                return TypesOfTask.NEW_FEATURE;
            case 3:
                return TypesOfTask.BUG;
            case 4:
                return TypesOfTask.EPIC;
            default:
                System.out.println("Invalid task type");
        }
        return null;
    }*/
}

