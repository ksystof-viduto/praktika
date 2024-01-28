package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(linkText = "Create an Account")
    WebElement buttonCreateAnAccount;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCreateAnAccount() {
        buttonCreateAnAccount.click();
    }

}