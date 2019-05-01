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
    public static void main(String[] args) throws TennisDatabaseException
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
                    database.printAllPlayer();

                    break;
                case 2:
                    System.out.println("You selected \"Print all tennis matches of a player.\"");
                    System.out.println("Enter player id:");
                    String idInput = consoleIn.next();
                    try
                    {
                        database.printMatchesOfPlayer(idInput);
                    }
                    catch (TennisDatabaseRuntimeException e)
                    {
                        System.out.println("Could not print matches for id: " + idInput);
                    }
                    break;
                case 3:
                    System.out.println("You selected \"Print all tennis matches.\"");

                    TennisMatch[] matchArray = database.getAllMatches();
                    try
                    {
                        if(database.getMatchCount() == 0)
                        {
                            System.out.println("No Matches in System");
                        }
                        else
                        {
                            for (int i = 0; i < matchArray.length; i++)
                            {
                                matchArray[i].print();
                            }
                        }
                    }
                    catch (NullPointerException e) //do nothing with empty array spaces
                    {

                    }
                    break;
                case 4:
                    System.out.println("You selected \"Insert a tennis player.\"");
                    System.out.println("Input player id:");
                    String newId = consoleIn.next();
                    System.out.println("Input first name:");
                    String newFirstName = consoleIn.next();
                    System.out.println("Input last name:");
                    String newLastName = consoleIn.next();
                    System.out.println("Input birth year:");
                    int newBirthYear = consoleIn.nextInt();
                    System.out.println("Input country:");
                    String newCountry = consoleIn.next();
                    System.out.println("Adding player...");
                    database.insertPlayer(newId, newFirstName, newLastName, newBirthYear, newCountry);

                    break;
                case 5:
                    System.out.println("You selected \"Insert a tennis match.\"");
                    System.out.println("Input player 1 id:");
                    String newId1 = consoleIn.next();
                    System.out.println("Input player 2 id:");
                    String newId2 = consoleIn.next();
                    System.out.println("Input year of match");
                    int newYear = consoleIn.nextInt();
                    System.out.println("Input month of match");
                    int newMonth = consoleIn.nextInt();
                    System.out.println("Input day of match");
                    int newDay = consoleIn.nextInt();
                    System.out.println("Input tournament name:");
                    consoleIn.nextLine();
                    String newName = consoleIn.nextLine();
                    System.out.println("Input scores, separated by commas:");
                    String newScore = consoleIn.next();
                    System.out.println("Adding match...");
                    database.insertMatch(newId1, newId2, newYear, newMonth, newDay, newName, newScore);
                    System.out.println("Match Added Successfully");
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
