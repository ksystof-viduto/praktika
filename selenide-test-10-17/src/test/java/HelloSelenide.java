import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HelloSelenide {
    @Test
    void test() {
        Configuration.holdBrowserOpen =true;
        Configuration.baseUrl = "https://opencart.abstracta.us/";
        open("");
        $(byText("My Account")).click();
    }
}
