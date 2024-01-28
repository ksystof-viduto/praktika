package lt.vtmc;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement dropdownMyAccount = $(byText("My Account"));

    private SelenideElement dropdownMyAccountLogin = $(byLinkText("Login"));

    private SelenideElement dropdownMyAccountRegister = $(byLinkText("Register"));

    void clickDropdownMyAccount() {
        dropdownMyAccount.click();
    }

    void clickDropdownMyAccountLogin() {
        dropdownMyAccountLogin.click();
    }

    void clickDropdownMyAccountRegister() {
        dropdownMyAccountRegister.click();
    }
}