package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_Fluent extends BasePage {
    @FindBy(css = "#user-name")
    private WebElement inputUsername;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = "#login-button")
    private WebElement buttonLogin;


    public LoginPage_Fluent(WebDriver driver) {
        super(driver);
    }

    public LoginPage_Fluent setInputUsername(String username) {
        inputUsername.sendKeys(username);
        return this;
    }

    public LoginPage_Fluent setInputPassword(String pass) {
        inputPassword.sendKeys(pass);
        return this;
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }


}
