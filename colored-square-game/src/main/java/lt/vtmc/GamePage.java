package lt.vtmc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage {

    @FindBy(css = "#changeLink")
    WebElement buttonChangeColor;

    @FindBy(css = "#theButton")
    WebElement buttonConfirmRedColor;

    @FindBy(css = "#theSquare")
    WebElement square;


    public GamePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSquareRed() {
        return square.getAttribute("style").contains("background-color: green;");
    }

    public void clickButtonChangeColorUntilRed() {
        while (!isSquareRed()) {
            clickButtonChangeColor();
        }
    }

    public void clickButtonChangeColor() {
        buttonChangeColor.click();
    }

    public void clickButtonConfirmRedColor(){
        buttonConfirmRedColor.click();
    }
}