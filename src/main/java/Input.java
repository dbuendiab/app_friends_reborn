import java.time.LocalDate;
import java.util.Scanner;

public class Input {


    Scanner scanner;

    Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {

        return scanner.nextLine();

    }

    public Integer getNumber() {

        int num = -1;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();

        } else {
            System.out.println("please enter a number");
        }
        scanner.nextLine();
        return num;
    }

    public LocalDate getDate() {

        String newDate = scanner.nextLine();
        try {

            return LocalDate.parse(newDate);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("incorrect format");
        }
        return null;
    }

    public void close() {
        scanner.close();
    }
}
