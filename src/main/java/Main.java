import java.io.File;
import java.time.LocalDate;


public class Main {

    Input input;

    LocalDate today;

    App app;

    Main() {
        input = new Input();
        today = null;
        app = new App();
    }

    public void printMenu() {

        String menu = """
                                
                                
                1.Show friend list (by date)
                2.Create friend
                3.Delete friend
                4.Show friend
                5.Edit friend
                6.Sort friend by name
                7. Update friend nextDate
                0.Exit
                                
                                
                """;


        System.out.println(menu);
    }


/*
        boolean mustRepeat = true;
        int option = 0;
        do {
            System.out.print("Elija una opción (0 para salir): ");
            if (scanner.hasNextInt()) {     // Comprueba si tenemos un int a la entrada
                option = scanner.nextInt(); // Caso que sí, lo leemos
                scanner.nextLine();         // Scanner debe leer el resto de la línea (el carácter \n) para descartarla
                mustRepeat = false;         // Ya podemos salir
            } else if (scanner.hasNextLine()) {     // Si no hay int, leemos la línea para descartarla
                scanner.nextLine();
                System.out.println("Error. Se espera un número");
            }
        } while (mustRepeat);

        return option;
*/

    public void executeOption(int option) throws Exception {


        switch (option) {
            case 1 -> {
                System.out.println();
                for (Friend elem : app.getFriendListSortedByNextDate()) {
                    System.out.println(elem.showData());
                }
                System.out.println();
            }
            case 2 -> {
                System.out.println("enter name to add friend");
                String lovedFriend = input.getString();
                System.out.println("enter days between appointments");
                int incDaysOfFriend = input.getNumber();
                //try {
                app.addFriend(lovedFriend, incDaysOfFriend);
                //} catch (Exception e) {
                //    System.out.println("friend already exists");
                //    break;
                //}
                app.saveData();
            }
            case 3 -> {
                System.out.println("enter name to delete friend");
                String hatedFriend = input.getString();
                app.removeFriend(hatedFriend);
                app.saveData();
            }
            case 4 -> {
                System.out.println("enter name of friend");
                String inquiredFriend = input.getString();
                if (app.friendAlreadyExists(inquiredFriend) == -1) {

                    System.out.println("friend doesn't exist");
                    break;
                }
                Friend thatFriend = app.getFriend(inquiredFriend);
                System.out.println("\n" + thatFriend.showData() + "\n");
            }
            case 5 -> {
                System.out.println("enter name of friend");
                String selectedFriend = input.getString();
                try {
                    Friend theFriend = app.getFriend(selectedFriend);
                    System.out.println("\n" + theFriend.toString() + "\n");
                    System.out.println("""
                            1 = edit name\s
                            2 = edit date\s
                            3 = edit days between appointments""".indent(1));

                    int opt = input.getNumber();

                    switch (opt) {
                        case 1 -> {
                            System.out.println("enter new name");
                            String newName = input.getString();
                            if (app.friendAlreadyExists(newName) > -1) {

                                System.out.println("name already in use");
                                break;
                            }
                            try {
                                theFriend.setName(newName);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        case 2 -> {
                            System.out.println("enter new date, format yyyy-mm-dd");
                            LocalDate newDate2 = input.getDate();
                            if (newDate2 != null) {
                                app.editNextDateManual(theFriend.getName(), newDate2);
                            }
                        }
                        case 3 -> {
                            System.out.println("enter number of days");

                            int numberOfDays = Input.getNumber();
                            try {
                                theFriend.setIncDays(numberOfDays);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        default -> System.out.println("you don't wanna collaborate, okay");
                    }

                    app.saveData();

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }
            }

            case 6 -> {

                System.out.println();
                for (Friend elem : app.getFriendListSortedByName()) {
                    System.out.println(elem.showData());
                }
                System.out.println();
            }

            case 7 -> {
                System.out.println("enter name of friend");
                String inquiredFriend = Input.getString();
                if (app.friendAlreadyExists(inquiredFriend) == -1) {

                    System.out.println("friend doesn't exist");
                    break;
                }
                Friend thatFriend = app.getFriend(inquiredFriend);
                thatFriend.setNextDate();
                System.out.println("\n" + thatFriend.showData() + "\n");

            }
        }
    }

    private void updateTime() {

        if (today == null || today.compareTo(LocalDate.now()) < 0) {
            today = LocalDate.now();
            app.updateFriends();
        }
    }


    public static void main(String[] args) throws Exception {
        Main theApp = new Main();

        /*app.addFriend("diego");
        app.addFriend("sediego");
        app.addFriend("sedieg");

        app.saveData();*/

        File f = new File("friendList.txt");
        if (f.isFile()) {

            theApp.app.loadData();
        }
        theApp.app.saveData();

        while (true) {

            // updateTime();
            theApp.printMenu();

            int option = theApp.input.getNumber();

            if (option == 0) {
                System.out.println("get fucked");
                break;
            }
            theApp.executeOption(option);
            theApp.app.saveData();
        }
        theApp.input.close();
    }
}
