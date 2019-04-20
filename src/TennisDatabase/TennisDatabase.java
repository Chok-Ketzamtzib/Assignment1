package TennisDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface
{
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

        //CONCEPT CODE FROM PROF

        while (fileScan.hasNextLine())
        {
            String inString = fileScan.nextLine();
            Scanner inScan = new Scanner(inString).useDelimiter("[\\r\\n/]");
            String token = inScan.next().toUpperCase();

            if (token.equals("PLAYER"))
            {
            //TODO: Insert try catch blocks
                String id = inScan.next().toUpperCase();
                String firstName = inScan.next().toUpperCase();
                String lastName = inScan.next().toUpperCase();
                int year = inScan.nextInt();
                String country = inScan.next().toUpperCase();
                TennisPlayer p = new TennisPlayer(id,firstName,lastName,year,country);
                //tennisplayercountainer.insertplayer(p)
                playerCount++;
            }
        }

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
        return new TennisMatch[0];
    }

    @Override
    public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseException
    {

    }

    @Override
    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) throws TennisDatabaseException
    {

    }
}
