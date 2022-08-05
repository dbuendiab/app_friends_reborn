import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Una clase para capturar {@code System.out} e inyectar {@code System.in}.
 *
 * <p>Uso:</p>
 *
 * <code>
 * public void myTest() {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;MockIO mio = new MockIO("Pulsaciones introducidas por el usuario");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;try {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// Ejecutar el código a testear Main.main(), por ej.<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String out = mio.getOutput();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;} finally {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mio.close();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;// Comprobar que la salida es correcta<br>
 * }<br>
 * </code>
 * Basado en un artículo de Natanael Yang.
 * <a href="https://www.javacodegeeks.com/2019/02/approach-simulate-input-check-output.html">A Simple Approach to Simulate User Input and Check Output</a>
 */
public class MockIO {
    // Guardar los streams originales para restaurarlos al final
    private final static InputStream systemIn = System.in;
    private final static PrintStream systemOut = System.out;
    private final ByteArrayOutputStream os;

    public MockIO(String userInput) {
        os = setIOStreams(userInput);
    }

    // Convertir la entrada del usuario en un input stream (para Scanner)
    private void setInputStream(String userInput) {
        byte[] userBytes = userInput.getBytes();
        ByteArrayInputStream is = new ByteArrayInputStream(userBytes);
        System.setIn(is);
    }

    // Devolver la salida a un stream byte array
    private ByteArrayOutputStream setOutputStream() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        return baos;
    }

    // La siguiente función unifica las dos funciones anteriores
    private ByteArrayOutputStream setIOStreams(String userInput) {
        setInputStream(userInput);
        return setOutputStream();
    }

    /**
     * Devuelve la salida enviada por el programa a System.out
     * @return String con el contenido de salida
     */
    public String getOutput() {
        return os.toString().replace("\r\n", "\n");
    }

    // Restaurar los streams originales
    /**
     * Restaura los streams estándar si se necesita volver a usarlos
     * Tratándose de una clase para tests, posiblemente no haga falta invocarla
     */
    public void unsetIOStreams() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
