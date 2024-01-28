import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.internet.HoversPage;
import utils.ActionsUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.ActionsUtils.hoverOn;

public class ActionsDemo extends BaseTest {
    @Test
    void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        List<WebElement> elementsToHover = driver.findElements(By.cssSelector(".figure"));

        for (WebElement element : elementsToHover) {
            actions.moveToElement(element).perform();
            WebElement elementAfterHover = element.findElement(By.cssSelector(".figcaption"));
            assertTrue(elementAfterHover.isDisplayed());
        }
    }

    @Test
    void hoverPOM() {
        HoversPage hovers = new HoversPage(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");

        hoverOn(driver, hovers.userAvatar);

        assertTrue(hovers.viewProfileLink.isDisplayed());
    }
}
