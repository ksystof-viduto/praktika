import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://eviltester.github.io/TestingApp/games/buggygames/the_coloured_square_game/colouredsquare.html#");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

}
