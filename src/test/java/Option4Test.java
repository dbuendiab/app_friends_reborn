import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Option4Test extends TestSchema {

    @Test
    final void test_4_1_0_option() throws Exception {
        /*
        Arrancar opción 4, elegir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "4" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += OutputString.showIgnasi;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_4_1_nonexistent_0_option() throws Exception {
        /*
        Arrancar opción 3, borrar amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "4" + NL;
        out += "enter name of friend" + NL;

        in += "adolfo" + NL;
        out += "friend doesn't exist" + NL;
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

}
