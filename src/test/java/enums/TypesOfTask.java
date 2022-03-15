//package enums;
//
//import org.openqa.selenium.WebElement;
//import pages.AddTaskWindow;
//
//public enum TypesOfTask {
//    TASK(new AddTaskWindow().getTaskTypeTask()),
//    IMPROVEMENT(new AddTaskWindow().getImprovementTypeTask()),
//    NEW_FEATURE(new AddTaskWindow().getNewFeatureTypeTask()),
//    BUG(new AddTaskWindow().getBugTypeTask()),
//    EPIC(new AddTaskWindow().getEpicTypeTask());
//
//    WebElement webElement;
//
//    private TypesOfTask(WebElement webElement) {
//       this.webElement = webElement;
//    }
//
//    public String toString() {
//        switch (this) {
//            case TASK:
//                return "1";
//            case IMPROVEMENT:
//                return "2";
//            case NEW_FEATURE:
//                return "3";
//                case BUG:
//                return "4";
//            case EPIC:
//                return "5";
//            default:
//                return "-1";
//        }
//    }
//}
