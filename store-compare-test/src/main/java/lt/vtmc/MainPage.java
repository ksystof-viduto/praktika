package lt.vtmc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(css = ".fa-exchange")
    List<WebElement> buttonCompareProduct;
    @FindBy(linkText = "product comparison")
    WebElement linkProductComparisonPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCompareProduct(int productIndex) {
        buttonCompareProduct.get(productIndex).click();
    }

    public void clickLinkProductComparisonPage() {
        linkProductComparisonPage.click();
    }
}