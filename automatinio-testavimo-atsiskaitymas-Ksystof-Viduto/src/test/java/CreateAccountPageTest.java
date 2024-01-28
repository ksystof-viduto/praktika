import org.example.pageobjects.AccountPage;
import org.example.pageobjects.CreateAccountPage;
import org.example.pageobjects.MainPage;
import org.example.utils.DataGenerator;
import org.junit.jupiter.api.Test;


import static org.example.utils.WaitUtils.*;
import static org.junit.jupiter.api.Assertions.*;


public class CreateAccountPageTest extends BaseTest {

    CreateAccountPage createAccountPage;
    MainPage mainPage;
    AccountPage accountPage;

    String validFirstname = "abcde";
    String validLastname = "edcba";
    String validEmailAddress = DataGenerator.getRandomEmail();
    String validPassword = "123456PASSword!";
    String validPasswordConfirm = "123456PASSword!";


    @Test
    void createValidAccount() {
        createAccountPage = new CreateAccountPage(driver);
        mainPage = new MainPage(driver);
        accountPage = new AccountPage(driver);

        mainPage.clickButtonCreateAnAccount();
        createAccountPage.enterInputFirstname(validFirstname);
        createAccountPage.enterInputLastname(validLastname);
        createAccountPage.enterInputEmailAddress(validEmailAddress);
        createAccountPage.enterInputPassword(validPassword);
        createAccountPage.enterInputPasswordConfirmation(validPasswordConfirm);
        createAccountPage.clickButtonCreateAnAccount();

        waitForDisplayed(driver, accountPage.messageSuccess);

        assertTrue(accountPage.isAccountCreatedSuccessfully());
    }
}
