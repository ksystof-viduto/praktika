import lt.vtmc.pageObjects.MainPage;
import lt.vtmc.pageObjects.RegisterPage;
import lt.vtmc.utils.DataGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageTest extends BaseTest {
    RegisterPage registerPage;

    MainPage mainPage;

    String validFirstName = "John";

    String validLastName = "Doe";

    String validPassword = "123456John";

    String validEmail = "johrndoe1234567@email.com";

    String validTelephoneNumber = "123456789";

    @Test
    void registerUserValid() {
        registerPage = new RegisterPage(driver);
        mainPage = new MainPage(driver);

        mainPage.clickDropdownMyAccountRegister();

        registerPage.enterInputFirstName(validFirstName);
        registerPage.enterInputLastName(validLastName);
        registerPage.enterInputEmail(DataGenerator.getRandomEmail());
        registerPage.enterInputTelephoneNumber(validTelephoneNumber);

        registerPage.enterInputPassword(validPassword);
        registerPage.enterInputPasswordConfirm(validPassword);
        registerPage.clickCheckboxAgree();

        registerPage.clickButtonContinue();

        assertTrue(registerPage.isAccountSuccessfullyCreated());


    }
}
