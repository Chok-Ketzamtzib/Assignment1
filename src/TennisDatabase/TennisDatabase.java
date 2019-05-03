// Steven Causley
// CS-102, Spring 2019
// Assignment 1
package TennisDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface
{

    private TennisMatchContainer matchContainer = new TennisMatchContainer();
    private TennisPlayerContainer playerContainer = new TennisPlayerContainer();

    //Scans input file and loads players and matches into respective containers
    @Override
    public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {

        Scanner fileScan;


        //check that file is valid
        try
        {
            File inFile = new File(fileName);
            fileScan = new Scanner(inFile).useDelimiter("[\\r\\n]+");
        } catch (FileNotFoundException e)
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
                String id = inScan.next().toUpperCase();
                String firstName = inScan.next().toUpperCase();
                String lastName = inScan.next().toUpperCase();
                int year = inScan.nextInt();
                String country = inScan.next().toUpperCase();
                insertPlayer(id, firstName, lastName, year, country);

            }
            if (token.equals("MATCH"))
            {
                String playerId1 = inScan.next().toUpperCase();
                String playerId2 = inScan.next().toUpperCase();
                int[] date = splitDate(inScan.next());
                String location = inScan.next().toUpperCase();
                String score = inScan.next().toUpperCase();

                insertMatch(playerId1, playerId2, date[0], date[1], date[2], location, score);

            }
            //Ignore lines without PLAYER or MATCH
        }

    }

    @Override
    public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException
    {
        return playerContainer.getPlayer(id);
    }

    @Override
    public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException
    {
        return playerContainer.getAllPlayers();
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException
    {
        return playerContainer.getPlayerMatches(playerId);
    }

    @Override
    public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException
    {
        return matchContainer.getAllMatches();
    }

    //Adds player to playerContainer
    @Override
    public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseException
    {
        try
        {
            TennisPlayer newPlayer = new TennisPlayer(id.toUpperCase(), firstName.toUpperCase(), lastName.toUpperCase(), year, country.toUpperCase());
            playerContainer.insertPlayer(newPlayer);
        } catch (TennisDatabaseException e)
        {
            throw new TennisDatabaseRuntimeException("Tennis Database Exception in insertPlayer");
        }

    }

    //Adds match to matchContainer
    @Override
    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) throws TennisDatabaseException
    {
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month, day, tournament, score);


        try
        {
            matchContainer.insertMatch(m);
            playerContainer.insertMatch(m);
        } catch (TennisDatabaseRuntimeException e)
        {
            throw new TennisDatabaseRuntimeException("Error: Invalid Match. Match not added");
        }


    }

    //splits the date into a String array for use with TennisMatch constructor
    public int[] splitDate(String date)
    {
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);

        int[] output = new int[3];
        output[0] = Integer.parseInt(year);
        output[1] = Integer.parseInt(month);
        output[2] = Integer.parseInt(day);

        return output;
    }

    //Prints matches with a specific player id
    public String[] getMatchesOfPlayerString(String idInput)
    {
        TennisMatch[] matchArray = playerContainer.getPlayerMatches(idInput);
        if (matchArray.length == 0) //if player has no matches
        {
            String[] outputArray = new String[1];
            outputArray[0] = ("This player does not have any matches.");
            return outputArray;
        } else
        {
            String[] outputArray = new String[matchArray.length];
            for (int i = 0; i < matchArray.length; i++)
            {
                outputArray[i] = (String.format("%02d", matchArray[i].getDateYear()) + "/" + String.format("%02d",
                        matchArray[i].getDateMonth()) + "/" + String.format("%02d", matchArray[i].getDateMonth()) + "," + " "
                        + playerContainer.getPlayer(matchArray[i].getIdPlayer1()).getFirstName() + " "
                        + playerContainer.getPlayer(matchArray[i].getIdPlayer1()).getLastName()
                        + " - " + playerContainer.getPlayer(matchArray[i].getIdPlayer2()).getFirstName() + " "
                        + playerContainer.getPlayer(matchArray[i].getIdPlayer2()).getLastName()
                        + "," + " " + matchArray[i].getTournament() + "," + " " + matchArray[i].getMatchScore());
            }
            return outputArray;
        }
    }

    //Converts all players in playerContainer into String array
    public String[] getPlayerStringArray()
    {

        if (playerContainer.getPlayerCount() == 0)
        {
            String[] outputArray = new String[1];
            outputArray[0] = "No Players in System";
            return outputArray;
        } else
        {
            String[] outputArray = new String[playerContainer.getPlayerCount()];
            TennisPlayer[] playerArray = getAllPlayers();
            calcWinLoss();
            for (int i = 0; i < playerArray.length; i++)
            {
                outputArray[i] = (playerArray[i].getId() + ": " + playerArray[i].getFirstName() + " " +
                        playerArray[i].getLastName() + ", " + playerArray[i].getBirthYear() + ", " + playerArray[i].getWins() + "/" + playerArray[i].getLosses() + " " + "(WIN/LOSS)");
            }
            return outputArray;
        }
    }

    //Calculates amount of matches won/lost for all players
    public void calcWinLoss()
    {
        TennisMatch[] array = getAllMatches();
        for (int i = 0; i < getMatchCount(); i++)
        {
            if (array[i].getWinner() == 1)
            {
                getPlayer(array[i].getIdPlayer1()).addWin();
                getPlayer(array[i].getIdPlayer2()).addLoss();
            } else
            {
                getPlayer(array[i].getIdPlayer1()).addLoss();
                getPlayer(array[i].getIdPlayer2()).addWin();
            }
        }
    }

    //gets number of matches in matchContainer
    public int getMatchCount()
    {
        return matchContainer.getMatchCount();
    }

    //returns array of strings for all matches
    public String[] getAllMatchesString()
    {
        TennisMatch[] array = getAllMatches();
        int arrayLength = 0;

        //find length of array without null values
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
            {
                arrayLength++;
            }
        }
        String[] output = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++)
        {
            output[i] = (String.format("%02d", array[i].getDateYear()) + "/" + String.format("%02d", array[i].getDateMonth()) + "/" + String.format("%02d", array[i].getDateDay()) + "," + " "
                    + getPlayer(array[i].getIdPlayer1()).getFirstName() + " " + getPlayer(array[i].getIdPlayer1()).getLastName() + " - " + getPlayer(array[i].getIdPlayer2()).getFirstName() + " " + getPlayer(array[i].getIdPlayer2()).getLastName() + "," + " " + array[i].getTournament() + "," + " " + array[i].getMatchScore());
        }
        return output;
    }

}
