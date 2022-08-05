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

    static String addedManel = """
                [32m --> manel || days remaining 7 || FRIDAY <--\s
                [0m
                                
                """;

    static String getFucked = "get fucked";

}
