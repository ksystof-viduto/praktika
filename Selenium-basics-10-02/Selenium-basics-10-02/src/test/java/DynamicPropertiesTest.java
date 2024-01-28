import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicPropertiesTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }

    @Test
    void waitTest() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(elementToBeClickable(By.cssSelector("#enableAfter")));
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        assertTrue(enableAfter.isEnabled(), "Element is not yet enabled.");

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(attributeContains(By.id("colorChange"), "class", "text-danger"));
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        assertTrue(colorChange.isDisplayed(), "Color has not been changed yet.");

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOfElementLocated(By.id("visibleAfter")));
        WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
        assertTrue(visibleAfter.isDisplayed(), "Element is not yet visible.");
    }
}
