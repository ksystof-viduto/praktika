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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitTest {

    WebDriver driver;


    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
//        driver.get("https://testpages.herokuapp.com/styled/progress-bars-sync.html");
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }

    @Test
    void waitForFinish() {
//    new WebDriverWait(driver, Duration.ofSeconds(15)).until(textToBe(By.cssSelector("#status"), "Stopped"));
//    new WebDriverWait(driver, Duration.ofSeconds(15)).until(invisibilityOfElementWithText(By.cssSelector("#status"), "Running"));
//    new WebDriverWait(driver, Duration.ofSeconds(15)).until(attributeToBe(By.cssSelector("#status"), "value", "Running"));
//    new WebDriverWait(driver, Duration.ofSeconds(15)).until(numberOfElementsToBe(By.xpath("//progress[@value='100'"), 3));
    }

    @Test
    void waitForAlert() {
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        WebElement promptButton = driver.findElement(By.id("promtButton"));

        alertButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(alertIsPresent());
        String expectedAlertMessage = "You clicked a button";
        String actualAlertMessage = driver.switchTo().alert().getText();
        assertEquals(expectedAlertMessage, actualAlertMessage);
        driver.switchTo().alert().accept();

        timerAlertButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(alertIsPresent());
        expectedAlertMessage = "This alert appeared after 5 seconds";
        actualAlertMessage = driver.switchTo().alert().getText();
        assertEquals(expectedAlertMessage, actualAlertMessage);
        driver.switchTo().alert().accept();

        confirmButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement confirmMessage = driver.findElement(By.id("confirmResult"));
        assertTrue(confirmMessage.isDisplayed());

        promptButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(alertIsPresent());
        driver.switchTo().alert().sendKeys("John Doe");
        driver.switchTo().alert().accept();
        WebElement confirmMessagePrompt = driver.findElement(By.id("promptResult"));
        assertTrue(confirmMessagePrompt.isDisplayed());
    }
}
