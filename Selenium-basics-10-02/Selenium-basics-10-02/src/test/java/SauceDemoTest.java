import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SauceDemoTest {
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

        boolean isLogoutButtonDisplayed = driver.findElement(By.cssSelector("#logout_sidebar_link[tabindex='-1']")).isDisplayed();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        assertFalse(isLogoutButtonDisplayed, "Not logged in.");
    }

    @Test
    void login2() {
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        String usernameString = driver.findElement(By.xpath("//*[@id='login_credentials']")).getText();
        String passwordString = driver.findElement(By.cssSelector(".login_password")).getText();


        System.out.println(usernameString);
        List<String> passwords = Arrays.asList(passwordString.split("\n"));
        List<String> usernames = Arrays.asList(usernameString.split("\n"));

        System.out.println(usernames);
        System.out.println(passwords);

        loginInput.sendKeys(usernames.get(1));
        passwordInput.sendKeys(passwords.get(1));

        loginButton.click();
    }


    @ParameterizedTest
    @CsvFileSource(resources = {"logins.csv"})
    void loginParam(String username, String password) {
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        boolean isLogoutButtonDisplayed = driver.findElement(By.cssSelector("#logout_sidebar_link[tabindex='-1']")).isDisplayed();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        assertFalse(isLogoutButtonDisplayed, "Not logged in.");
    }

}
