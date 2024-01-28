import lt.vtmc.GamePage;
import org.junit.jupiter.api.Test;

public class GamePageTest extends BaseTest {

    GamePage gamePage;

    @Test
    void clickUntilWin() {
        gamePage = new GamePage(driver);

        gamePage.clickButtonChangeColorUntilRed();
        System.out.println("");
    }
}
