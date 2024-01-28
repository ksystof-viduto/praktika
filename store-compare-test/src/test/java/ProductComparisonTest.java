import lt.vtmc.MainPage;
import lt.vtmc.ProductComparisonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductComparisonTest extends BaseTest {
    MainPage mainPage;

    ProductComparisonPage productComparisonPage;

    @Test
    void addProductsForComparison() {
        mainPage = new MainPage(driver);
        productComparisonPage = new ProductComparisonPage(driver);

        mainPage.clickButtonCompareProduct(0);
        mainPage.clickButtonCompareProduct(1);

        mainPage.clickLinkProductComparisonPage();

        assertTrue(productComparisonPage.isProductComparisonPageOpen());
        assertEquals(2,productComparisonPage.countComparedProductCount());
    }


}
