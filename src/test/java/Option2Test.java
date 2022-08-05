import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Option2Test extends TestSchema {

    @Test
    final void test_2_1_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "2" + NL;
        out += "enter name to add friend" + NL;

        in += "manel" + NL;
        out += "enter days between appointments" + NL;

        in += "7" + NL;
        out += OutputString.mainMenu;

        in += "1" + NL;
        out += OutputString.defaultFriendList +
                OutputString.addedManel +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_2_1_0_name_exists() throws Exception {
        /*
        Arrancar opción 2, añadir amigo (existente), listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "2" + NL;
        out += "enter name to add friend" + NL;

        in += "ignasi" + NL;
        out += "enter days between appointments" + NL;

        in += "7" + NL;
        out += "friend already exists" + NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_2_1_0_bad_number() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "2" + NL;
        out += "enter name to add friend" + NL;

        in += "manel" + NL;
        out += "enter days between appointments" + NL;

        in += "0" + NL;
        out += "son of a fucking bitch introduce correct number piece of absolute dogshit" + NL +
                OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

}
