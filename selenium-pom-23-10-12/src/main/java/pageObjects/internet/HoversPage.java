package pageObjects.internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class HoversPage extends BasePage {
    @FindBy(linkText = "View profile")
    public WebElement viewProfileLink;
    @FindBy(css = ".figure")
    public WebElement userAvatar;

    public HoversPage(WebDriver driver) {
        super(driver);
    }
}
