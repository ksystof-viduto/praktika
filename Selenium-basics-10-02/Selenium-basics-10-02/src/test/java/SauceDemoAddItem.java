import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SauceDemoAddItem {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }


    @Test
    void login() {
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();


        WebElement itemAdd = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        itemAdd.click();

        boolean isShoppingCartBadgeDisplayed = driver.findElement(By.cssSelector(".shopping_cart_badge")).isDisplayed();
        assertTrue(isShoppingCartBadgeDisplayed,"Shopping cart badge is not displayed");
    }
}
