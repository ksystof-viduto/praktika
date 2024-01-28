import org.junit.jupiter.api.Test;

import static pageObjects.LoginPage_Static.*;

public class LoginPageTest_Static extends BaseTest {

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Test
    void userCanLogin() {
        setInputUsername(validUsername);
        setInputPassword(validPassword);
        clickLoginButton();

//        assertEquals("Products", mainPage.getTitle());
    }
}
