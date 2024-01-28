import lt.vtmc.pageobjects.SliderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SliderTest extends BaseTest{

    SliderPage sliderPage;

    @Test
    void moveSliderByValue() {
        sliderPage = new SliderPage(driver);

        sliderPage.moveSliderByValue(-250);
        sliderPage.clickButtonGetCountries();

        List<String> countries = Arrays.asList(sliderPage.getCountriesText().split(" - "));

        Assertions.assertEquals(5,countries.size());
    }
}
