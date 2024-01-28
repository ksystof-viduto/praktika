import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SauceDemoTest.class, SauceDemoAddItem.class})
public class SauceDemoSuite {
}
