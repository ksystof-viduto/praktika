import pageObjects.LoginPage;
import pageObjects.MainPage;
import org.junit.jupiter.api.Test;
import utils.WaitUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.WaitUtils.waitForDisplayed;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String invalidPassword = "oops";

    @Test
    void userCanLogin() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(validPassword);
        loginPage.clickLoginButton();

        assertEquals("Products", mainPage.getTitle());
    }

    @Test
    void userCanNotLoginWithIncorrectPassword() {
        loginPage = new LoginPage(driver);

        loginPage.setInputUsername(validUsername);
        loginPage.setInputPassword(invalidPassword);
        loginPage.clickLoginButton();
        waitForDisplayed(driver, loginPage.getErrorWebElement());

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals("todo", loginPage.getErrorText());
    }
}
