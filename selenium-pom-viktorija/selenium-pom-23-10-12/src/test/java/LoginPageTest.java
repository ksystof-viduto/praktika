import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;

    @Test
    void userCanLogin() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.setInputUsername("standard_user");
        loginPage.setInputPassword("secret_sauce");
        loginPage.clickLoginButton();

        assertEquals("Products", mainPage.getTitle());
    }

    @Test
    void userCanNotLoginWithIncorrectPassword() {
        loginPage = new LoginPage(driver);

        loginPage.setInputUsername("standard_user");
        loginPage.setInputPassword("incorrect");
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("div h3")));

        assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.getLoginErrorMessage());
    }
}
