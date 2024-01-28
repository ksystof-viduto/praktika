package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "#user-name")
    private WebElement inputUsername;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = "#login-button")
    private WebElement buttonLogin;

    public WebElement getErrorWebElement() {
        return error;
    }

    @FindBy(css = "[data-test='error']")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setInputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void setInputPassword(String pass) {
        inputPassword.sendKeys(pass);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

    public boolean isErrorDisplayed() {
        return error.isDisplayed();
    }

    public String getErrorText() {
        return error.getText();
    }
}
