package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_Static extends BasePage {
    @FindBy(css = "#user-name")
    private static WebElement inputUsername;

    @FindBy(css = "#password")
    private static WebElement inputPassword;

    @FindBy(css = "#login-button")
    private static WebElement buttonLogin;




    public LoginPage_Static(WebDriver driver) {
        super(driver);
    }

    public static void setInputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public static void setInputPassword(String pass) {
        inputPassword.sendKeys(pass);
    }

    public static void clickLoginButton() {
        buttonLogin.click();
    }


}
