package lt.vtmc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {
    public static void dragAndDropLeftRight(WebDriver driver, WebElement element, int value) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, value,0).perform();
    }
}
