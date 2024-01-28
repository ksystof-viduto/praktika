package lt.vtmc.pageobjects;

import lt.vtmc.utils.ActionsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {

    @FindBy(css = "#generate")
    public static WebElement slider;

    @FindBy(css = "button[class='button is-primary']")
    WebElement buttonGetCountries;

    @FindBy(css = ".has-text-primary-light")
    WebElement boxCountriesText;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSliderByValue(int horizontalOffset) {
        ActionsUtil.dragAndDropLeftRight(driver, slider, horizontalOffset);
    }

    public void clickButtonGetCountries() {
        buttonGetCountries.click();
    }

    public String getCountriesText() {
        return boxCountriesText.getText();
    }
}
