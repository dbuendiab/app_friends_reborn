import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class MockingFile {
    // Fecha de hoy para ajustar fechas anteriores y posteriores en las siguientes variables
    LocalDate today = LocalDate.now();

    // Fechas relativas a hoy (en formato texto)
    String fechaHoy = today.toString();
    String fechaMas6 = today.plusDays(6).toString();
    String fechaMenos1 = today.plusDays(-1).toString();
    String fechaMenos2 = today.plusDays(-2).toString();
    String fechaMenos16 = today.plusDays(-16).toString();
    //String fechaMas1 = today.plusDays(1).toString();
    //String fechaMas2 = today.plusDays(2).toString();
    String fechaMas16 = today.plusDays(16).toString();

    // Asigno esas fechas relativas a cada usuario para no liarme al aplicarlas
    String fechaPepe = fechaMas6;
    String fechaMaria = fechaHoy;
    String fechaIgnasi = fechaMenos2;
    String fechaJuan = fechaMenos16;
    String fechaGuille = fechaMenos1;
    String fechaScarlett = fechaMas16;

    // La lista de usuarios con las fechas sincronizadas a día de hoy
    String mockingList = String.format("""
                pepe,%s,7
                maria,%s,1
                ignasi,%s,4
                guille,%s,7
                juan,%s,7
                """, fechaPepe, fechaMaria, fechaIgnasi, fechaGuille, fechaJuan);

    // Para el mocking guardo la friendList.txt original en friendList.txt.bak
    // Y así la recreo para las pruebas, al final restauraré la original
    String friendListBackupFile = "friendList.txt.bak";
    String friendListFile = "friendList.txt";

    // Guardo la friendList original y la sustituyo por mis datos mockup
    void setMockingFile() throws IOException {
        if (Files.exists(Path.of(friendListFile))) {
            Files.copy(Path.of(friendListFile),
                    Path.of(friendListBackupFile),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        BufferedWriter br = new BufferedWriter(new FileWriter(friendListFile));
        br.write(mockingList);
        br.close();
    }

    // Restaura la friendList original, borrando la de prueba
    void unsetMockingFile() throws IOException {
        if (Files.exists(Path.of(friendListBackupFile))) {
            Files.copy(Path.of(friendListBackupFile),
                    Path.of(friendListFile),
                    StandardCopyOption.REPLACE_EXISTING);
            Files.delete(Path.of(friendListBackupFile));
        }
    }
}
