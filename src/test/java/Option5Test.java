import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Option5Test extends TestSchema {

    @Test
    final void test_5_bad_non_existent_friend_option_0_option() throws Exception {
        /*
        Arrancar opción 5, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "boris" + NL;
        out += "this friend doesn't exist" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_bad_edit_option_bad_number_0_option() throws Exception {
        /*
        Arrancar opción 5, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "7" + NL;
        out += "you don't wanna collaborate, okay" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_bad_edit_option_text_instead_number_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "escribo texto" + NL;
        out += "please enter a number" + NL;
        out += "you don't wanna collaborate, okay" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_bad_edit_new_name_exists_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "1" + NL;
        out += "enter new name" + NL;

        in += "guille" + NL;
        out += "name already in use" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_name_ok_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "1" + NL;
        out += "enter new name" + NL;

        in += "alfonso" + NL;                   // Estaría bien presentar el resultado de la modificación
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_date_bad_format_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "2" + NL;
        out += "enter new date, format yyyy-mm-dd" + NL;

        in += "alfonso" + NL;
        out += """
                Text 'alfonso' could not be parsed at index 0
                incorrect format
                """;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_date_ok_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "2" + NL;
        out += "enter new date, format yyyy-mm-dd" + NL;

        in += "2022-09-25" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_days_bad_number_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "3" + NL;
        out += "enter number of days" + NL;

        in += "0" + NL;
        out += "son of a fucking bitch introduce correct number piece of absolute dogshit" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_days_bad_text_input_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "3" + NL;
        out += "enter number of days" + NL;

        in += "letras" + NL;
        out += "please enter a number" + NL;
        out += "son of a fucking bitch introduce correct number piece of absolute dogshit" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    final void test_5_edit_days_ok_0_option() throws Exception {
        /*
        Arrancar opción 2, añadir amigo, listar 1 y 0 para salir
         */

        String out = "";
        String in = "";

        out += OutputString.mainMenu;

        in += "5" + NL;
        out += "enter name of friend" + NL;

        in += "ignasi" + NL;
        out += NL + "ignasi,2022-08-03,4" + NL;
        out += OutputString.editMenu;

        in += "3" + NL;
        out += "enter number of days" + NL;

        in += "15" + NL;
        out += OutputString.mainMenu;

        in += "0" + NL;
        out += OutputString.getFucked + NL;

        String actualOutput = evalSequence(in);
        String expectedOutput = cleanCRLF(out);

        assertEquals(expectedOutput, actualOutput);
    }

}
