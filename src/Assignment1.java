//Steven Causley
//CS 102-01
//Assignment 1

//TODO: Fix Heading Comments
import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;
import TennisDatabase.TennisMatch;

import java.util.Scanner;


public class Assignment1
{
    public static void main(String[] args)
    {
        Scanner consoleIn = new Scanner(System.in);
        int actionInput;

        TennisDatabase database = new TennisDatabase();

        //check to see if argument was entered
        try
        {
            String fileName = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ERROR: Please specify an input file in the command line");
        }


        try
        {
            database.loadFromFile(args[0]);
        }
        catch (TennisDatabaseRuntimeException e)
        {
            System.out.println("LOAD ERROR RUNTIME");
        }
        catch (TennisDatabaseException e)
        {
            System.out.println("LOAD ERROR");
        }


        do
        {
            System.out.println("CS 102-01 Tennis Manager - Available Commands");
            System.out.println("1 --> Print all tennis players");
            System.out.println("2 --> Print all tennis matches of a player");
            System.out.println("3 --> Print all tennis matches.");
            System.out.println("4 --> Insert a tennis player.");
            System.out.println("5 --> Insert a tennis match.");
            System.out.println("9 --> Exit");
            System.out.println("Enter your selection:");
            actionInput = consoleIn.nextInt();
            switch (actionInput)
            {
                case 1:
                    System.out.println("You selected \"Print all tennis players.\"");
                    //database.getAllPlayers();
                    //TODO: print all players
                    break;
                case 2:
                    System.out.println("You selected \"Print all tennis matches of a player.\"");
                    System.out.println("Enter player id:");
                    String idInput = consoleIn.next();
                    try
                    {
                        database.getMatchesOfPlayer(idInput);
                    }
                    catch (TennisDatabaseException e)
                    {
                        System.out.println("...");
                    }
                    break;
                case 3:
                    System.out.println("You selected \"Print all tennis matches.\"");

                    //TODO: Make toString for TennisMatch
                    TennisMatch[] matchArray = database.getAllMatches();
                    try
                    {
                        for (int i = 0; i < matchArray.length; i++)
                        {
                            matchArray[i].print();
                        }
                    }
                    catch (NullPointerException e) //do nothing with empty array spaces
                    {

                    }
                    break;
                case 4:
                    System.out.println("You selected \"Insert a tennis player.\"");
                    //TODO: Insert code
                    break;
                case 5:
                    System.out.println("You selected \"Insert a tennis match.\"");
                    //TODO: Insert code
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input detected. Please enter a valid selection");
            }
        }
        while(actionInput != 9);



    }


}
