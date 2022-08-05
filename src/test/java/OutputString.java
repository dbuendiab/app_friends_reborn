public class OutputString {
    static String mainMenu = """
                                
                                
                1.Show friend list (by date)
                2.Create friend
                3.Delete friend
                4.Show friend
                5.Edit friend
                6.Sort friend by name
                0.Exit
                                
                                
                                
                """;

    static String editMenu = """
                                
             1 = edit name\s
             2 = edit date\s
             3 = edit days between appointments
             
            """;

    static String defaultFriendList = """
                                
                [31m --> juan || you're 16 days late!! || WEDNESDAY <--\s
                [0m
                [31m --> ignasi || you're 2 days late!! || WEDNESDAY <--\s
                [0m
                [31m --> guille || you're 1 days late!! || THURSDAY <--\s
                [0m
                [33m --> maria || disappointment is today!! || FRIDAY <--\s
                [0m
                [32m --> pepe || days remaining 6 || THURSDAY <--\s
                [0m
                """;

    static String byNameFriendList = """
                                
                [31m --> guille || you're 1 days late!! || THURSDAY <--\s
                [0m
                [31m --> ignasi || you're 2 days late!! || WEDNESDAY <--\s
                [0m
                [31m --> juan || you're 16 days late!! || WEDNESDAY <--\s
                [0m
                [33m --> maria || disappointment is today!! || FRIDAY <--\s
                [0m
                [32m --> pepe || days remaining 6 || THURSDAY <--\s
                [0m
                """;


    static String defaultFriendListWithoutIgnasi = """
                                
                [31m --> juan || you're 16 days late!! || WEDNESDAY <--\s
                [0m
                [31m --> guille || you're 1 days late!! || THURSDAY <--\s
                [0m
                [33m --> maria || disappointment is today!! || FRIDAY <--\s
                [0m
                [32m --> pepe || days remaining 6 || THURSDAY <--\s
                [0m
                """;

    static String showIgnasi = """
                                
                [31m --> ignasi || you're 2 days late!! || WEDNESDAY <--\s
                [0m
                
                """;

    static String toStringIgnasi = "ignasi,2022-08-03,4";

    static String addedManel = """
                [32m --> manel || days remaining 7 || FRIDAY <--\s
                [0m
                                
                """;

    static String getFucked = "get fucked";

}
