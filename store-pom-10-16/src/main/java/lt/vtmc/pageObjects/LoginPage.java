package lt.vtmc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#input-email")
    private WebElement inputEmail;
    @FindBy(css = "#input-password")
    private WebElement inputPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
