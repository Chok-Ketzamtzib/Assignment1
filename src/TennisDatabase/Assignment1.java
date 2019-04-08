package TennisDatabase;

import java.util.Scanner;

class Assignment1
{
    public static void main(String[] args) throws Exception
    {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("CS 102-01 Tennis Manager - Available Commands");
        System.out.println("1 --> Print all tennis players");
        System.out.println("2 --> Print all tennis matches of a player");
        System.out.println("9 --> Exit");
        System.out.println("Enter your selection:");

        int actionInput = consoleIn.nextInt();
        TennisDatabase database = new TennisDatabase();
        database.loadFromFile(args[0]);

        switch (actionInput)
        {
            case 1:
                System.out.println("You selected \"Print all tennis players.\"");
                database.getAllPlayers();
                //TODO: print all players
                break;
            case 2:
                System.out.println("You selected \"Print all tennis matches of a player.\"");
                System.out.println("Enter player id:");
                String idInput = consoleIn.next();
                database.getMatchesOfPlayer(idInput);
                //TODO: print all matches
                break;
            case 9:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid input detected. Exiting...");
        }

    }


}
