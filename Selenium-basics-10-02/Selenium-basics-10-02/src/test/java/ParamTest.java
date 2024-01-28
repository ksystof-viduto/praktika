import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 15, Integer.MAX_VALUE})
    void paramTest1(int number) {
        assertEquals(1, number % 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -44, 0, -3, -55, Integer.MAX_VALUE})
    void paramTest2(int number) {
        assertTrue(number <= 0);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Woof", "Moo", "Meow", "Aaaaaa", "Moo"})
    void paramTest3(String string) {
        assertEquals("Moo", string);
    }
    @ParameterizedTest
    @CsvFileSource( resources = "myStrings.txt")
    void paramTest4(String string) {
        assertEquals(3, string.length());
    }


}
