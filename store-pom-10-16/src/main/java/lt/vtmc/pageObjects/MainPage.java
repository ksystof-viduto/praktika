package lt.vtmc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(linkText = "My Account")
    private WebElement dropdownMyAccount;

    @FindBy(linkText = "Register")
    private WebElement dropdownMyAccountRegister;

    @FindBy(linkText = "Login")
    private WebElement dropdownMyAccountLogin;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdownMyAccountRegister() {
        dropdownMyAccount.click();
        dropdownMyAccountRegister.click();
    }

    public void clickDropdownMyAccountLogin() {
        dropdownMyAccount.click();
        dropdownMyAccountLogin.click();
    }
}
