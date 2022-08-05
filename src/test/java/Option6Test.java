import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Option6Test extends TestSchema {

    @Test
    final void test_6_0_option() throws Exception {
        /*
        Arrancar y pulsar 0 para salir
         */
        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "6" + NL;
        out += OutputString.byNameFriendList + NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }
}
