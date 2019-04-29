// Steven Causley
// CS-102, Spring 2019
// Assignment 1
package TennisDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface
{

    TennisMatchContainer matchContainer = new TennisMatchContainer();
    TennisPlayerContainer playerContainer = new TennisPlayerContainer();

    @Override
    public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {

        Scanner fileScan;
        int playerCount = 1;
        int matchCount = 1;



        try
        {
            File inFile = new File(fileName);
            fileScan = new Scanner(inFile).useDelimiter("[\\r\\n]+");
        }
        catch (FileNotFoundException e)
        {
            throw new TennisDatabaseException("ERROR: Input file not found.");
        }


        while (fileScan.hasNextLine())
        {
            String inString = fileScan.nextLine();
            Scanner inScan = new Scanner(inString).useDelimiter("[\\r\\n/]");
            String token = inScan.next().toUpperCase();

            if (token.equals("PLAYER"))
            {
            //TODO: Insert try catch blocks
                System.out.println("PLAYER DETECTED");
                String id = inScan.next().toUpperCase();
                String firstName = inScan.next().toUpperCase();
                String lastName = inScan.next().toUpperCase();
                int year = inScan.nextInt();
                String country = inScan.next().toUpperCase();
                TennisPlayer p = new TennisPlayer(id,firstName,lastName,year,country);
                //playerContainer.insertAtFront(p);
                playerCount++;

            }
            if (token.equals("MATCH"))
            {
                System.out.println("MATCH DETECTED");
                String playerId1 = inScan.next().toUpperCase();
                String playerId2 = inScan.next().toUpperCase();
                int[] date = splitDate(inScan.next());
                String location = inScan.next().toUpperCase();
                String score = inScan.next().toUpperCase();

                TennisMatch m = new TennisMatch(playerId1, playerId2, date[0], date[1],date [2], location, score);
                matchContainer.insertMatch(m);

            }
        }

    }

    @Override
    public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException
    {
        return null;
    }

    @Override
    public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException
    {
        return new TennisPlayer[0];
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {
        return new TennisMatch[0];
    }

    @Override
    public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException
    {
        return matchContainer.getAllMatches();
    }

    @Override
    public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseException
    {

    }

    @Override
    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) throws TennisDatabaseException
    {
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month,day, tournament, score);

        matchContainer.insertMatch(m);
    }

    //splits the date into a String array for use with TennisMatch constructor
    public int[] splitDate(String date)
    {
        String year = date.substring(0,4);
        String month= date.substring(4,6);
        String day = date.substring(6,8);

        int[] output = new int[3];
        output[0] = Integer.parseInt(year);
        output[1] = Integer.parseInt(month);
        output[2] = Integer.parseInt(day);

        return output;
    }
}
