import org.junit.jupiter.api.Test;
import pageObjects.LoginPage;
import pageObjects.LoginPage_Fluent;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.WaitUtils.waitForDisplayed;

public class LoginPageTest_Fluent extends BaseTest {
    LoginPage_Fluent loginPage;
    MainPage mainPage;
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String invalidPassword = "oops";

    @Test
    void userCanLogin() {
        loginPage = new LoginPage_Fluent(driver);
//        mainPage = new MainPage(driver);

        loginPage.setInputUsername(validUsername)
                .setInputUsername(validUsername)
                .clickLoginButton();


//        assertEquals("Products", mainPage.getTitle());
    }

}
