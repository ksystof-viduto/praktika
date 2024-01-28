package lt.vtmc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductComparisonPage extends BasePage{
    @FindBy(css = ".rating")
    List<WebElement> comparedProducts;

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductComparisonPageOpen() {
        return driver.getTitle().contains("Product Comparison");
    }

    public int countComparedProductCount() {
        return comparedProducts.size();
    }
}
