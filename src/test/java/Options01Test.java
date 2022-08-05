import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Options01Test extends TestSchema {

    @Test
    final void test_0_option() throws Exception {
        /*
        Arrancar y pulsar 0 para salir
         */
        String in, out;

        out = OutputString.mainMenu;

        in = "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_1_0_option() throws Exception {
        /*
        Arrancar y pulsar 0 para salir
         */
        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "1" + NL;
        out += OutputString.defaultFriendList + NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_invalid_number() throws Exception {
        /*
        Arrancar, opción 1 (listado) y pulsar 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "256" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_invalid_text() throws Exception {
        /*
        Arrancar, opción <texto> (error) y pulsar 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "introduzco texto - error" + NL;
        out += "please enter a number" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

}
