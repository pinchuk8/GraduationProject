package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown {
    private UIElement uiElement;

    public DropDown(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public DropDown(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void click() {
        uiElement.click();
    }
}
