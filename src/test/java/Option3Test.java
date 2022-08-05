import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Option3Test extends TestSchema{

    @Test
    final void test_3_1_0_option() throws Exception {
        /*
        Arrancar opción 3, borrar amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "3" + NL;
        out += "enter name to delete friend" + NL;

        in += "ignasi" + NL;
        out += "deleted ignasi" + NL;
        out += OutputString.mainMenu;

        in += "1" + NL;
        out += OutputString.defaultFriendListWithoutIgnasi + NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_3_1_nonexistent_0_option() throws Exception {
        /*
        Arrancar opción 3, borrar amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "3" + NL;
        out += "enter name to delete friend" + NL;

        in += "adolfo" + NL;
        out += "you don't have a friend named adolfo" + NL;
        out += OutputString.mainMenu;

        in += "1" + NL;
        out += OutputString.defaultFriendList+ NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

}
