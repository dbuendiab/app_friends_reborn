import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSchema {

    private static final MockingFile mockingFile = new MockingFile();
    String NL = System.lineSeparator();

    // Normaliza los CRLF a LF para evitar errores al comparar
    String cleanCRLF(String s) {
        return s.replace("\r", "");
    }

    String evalSequence(String in) throws Exception {
        MockIO mio = new MockIO(in);
        Main.main(null);
        return cleanCRLF(mio.getOutput());
    }

    // Crea fichero de persistencia con datos ficticios
    @BeforeEach
    void setUp() throws Exception {
        mockingFile.setMockingFile();
    }

    // Restaura la lista de amigos original
    @AfterEach
    void tearDown() throws IOException {
        mockingFile.unsetMockingFile();
    }

}
