package lt.vtmc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = "#input-firstname")
    private WebElement inputFirstName;
    @FindBy(css = "#input-lastname")
    private WebElement inputLastName;
    @FindBy(css = "#input-email")
    private WebElement inputEmail;
    @FindBy(css = "#input-telephone")
    private WebElement inputTelephoneNumber;
    @FindBy(css = "#input-password")
    private WebElement inputPassword;
    @FindBy(css = "#input-confirm")
    private WebElement inputPasswordConfirm;
    @FindBy(css = "[name='agree']")
    private WebElement checkboxAgree;
    @FindBy(css = "input[value='Continue'")
    private WebElement buttonContinue;
    private String accountSuccessfullyCreatedMessage = "Congratulations! Your new account has been successfully created!";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterInputFirstName(String firstname) {
        inputFirstName.sendKeys(firstname);
    }

    public void enterInputLastName(String lastname) {
        inputLastName.sendKeys(lastname);
    }

    public void enterInputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterInputTelephoneNumber(String telephoneNumber) {
        inputTelephoneNumber.sendKeys(telephoneNumber);
    }

    public void enterInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterInputPasswordConfirm(String passwordConfirm) {
        inputPasswordConfirm.sendKeys(passwordConfirm);
    }

    public void clickCheckboxAgree() {
        checkboxAgree.click();
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public boolean isAccountSuccessfullyCreated() {
        return driver.getPageSource().contains(accountSuccessfullyCreatedMessage);
    }


}