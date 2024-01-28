import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://letcode.in/slider");
        driver.manage().addCookie(new Cookie("FCCDCF", "%5Bnull%2Cnull%2Cnull%2C%5B%22CP0JloAP0JloAEsACBENDcCoAP_AAEPAABBoINJB7D7FbSFCwH57aLsAMAhXRsCAQqQAAASBAmABQAKQIAQCkkAYFESgBAACAAAAICZBIQIMCAgACUABQAAAAAEEAAAABAAIIAAAgAEAAAAIAAACAIAAEAAIAAAAEAAAmQhAAIIACAAAhAAAIAAAAAAAAAAAAgCAAAAAAAAAAAAAAAAAAQQaQD2F2K2kKFgPi2QWYAQBCijYEAhUAAAAkCBIAAgAUgQAgFIIAwAIFAAAAAAAAAQEgCQAAQABAAAIACgAAAAAAIAAAAAAAQQAAAAAIAAAAAAAAEAQAAAAAQAAAAIAABEhCAAQQAEAAAAAAAQAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAgAA%22%2C%221~2072.70.89.93.108.122.149.196.2253.2299.259.2357.311.317.323.2373.338.358.2415.415.2506.2526.482.486.494.495.2568.2571.2575.540.574.2624.609.2677.2779.827.864.981.1048.1051.1095.1097.1201.1205.1276.1301.1365.1415.1449.1570.1577.1651.1716.1735.1753.1765.1834.1870.1878.1889.1958%22%2C%22917B88C6-EAC2-4460-9DB0-DD059963B3AD%22%5D%2Cnull%2Cnull%2C%5B%5D%5D"));
        driver.navigate().refresh();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
