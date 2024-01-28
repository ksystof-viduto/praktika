package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = ".message-success")
    public WebElement messageSuccess;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedSuccessfully() {
        return messageSuccess.isDisplayed();
    }
}
