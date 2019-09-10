import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testGetFirstWordFromString() {
        String test = "todo lets go to the zoo";
        String expected = "todo";
        Assertions.assertEquals(expected, Parser.getFirstWordFromString(test));
    }

    @Test
    public void testRemoveFirstWordFromString() {
        String test = "todo lets go to the zoo";
        String expected = "lets go to the zoo";
        assertEquals(expected, Parser.removeFirstWordFromString(test));
    }

    @Test
    public void testUserInputStringToArray() {
        String test = "todo lets go to the zoo";
        String[] expected = {"todo", "lets", "go", "to", "the", "zoo"};
        assertArrayEquals(expected, Parser.userInputStringToArray(test));
    }
}
