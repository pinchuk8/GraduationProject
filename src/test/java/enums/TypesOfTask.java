package enums;

import org.openqa.selenium.WebElement;
import pages.AddTaskPage;

public enum TypesOfTask {
    TASK(new AddTaskPage().getTaskTypeTask()),
    IMPROVEMENT(new AddTaskPage().getImprovementTypeTask()),
    NEW_FEATURE(new AddTaskPage().getNewFeatureTypeTask()),
    BUG(new AddTaskPage().getBugTypeTask()),
    EPIC(new AddTaskPage().getEpicTypeTask());

    WebElement webElement;

    private TypesOfTask(WebElement webElement) {
       this.webElement = webElement;
    }

    public String toString() {
        switch (this) {
            case TASK:
                return "1";
            case IMPROVEMENT:
                return "2";
            case NEW_FEATURE:
                return "3";
                case BUG:
                return "4";
            case EPIC:
                return "5";
            default:
                return "-1";
        }
    }
}
