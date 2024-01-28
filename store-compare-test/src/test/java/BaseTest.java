import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
