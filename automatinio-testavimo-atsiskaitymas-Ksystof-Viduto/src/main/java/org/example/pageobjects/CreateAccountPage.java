package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(css = "#firstname")
    WebElement inputFirstname;

    @FindBy(css = "#lastname")
    WebElement inputLastname;

    @FindBy(css = "#email_address")
    WebElement inputEmailAddress;

    @FindBy(css = "#password")
    WebElement inputPassword;

    @FindBy(css = "#password-confirmation")
    WebElement inputPasswordConfirmation;

    @FindBy(css = "button[title='Create an Account'")
    WebElement buttonCreateAnAccount;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterInputFirstname(String firstname) {
        inputFirstname.sendKeys(firstname);
    }

    public void enterInputLastname(String lastname) {
        inputLastname.sendKeys(lastname);
    }

    public void enterInputEmailAddress(String emailAddress) {
        inputEmailAddress.sendKeys(emailAddress);
    }

    public void enterInputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterInputPasswordConfirmation(String passwordConfirm) {
        inputPasswordConfirmation.sendKeys(passwordConfirm);
    }

    public void clickButtonCreateAnAccount() {
        buttonCreateAnAccount.click();
    }

}
