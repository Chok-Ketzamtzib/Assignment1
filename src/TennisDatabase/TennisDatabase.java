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

    @Override
    public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {

        Scanner fileScan;



        //check that file is valid
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
                insertPlayer(id,firstName,lastName,year,country);

            }
            if (token.equals("MATCH"))
            {
                System.out.println("MATCH DETECTED");
                String playerId1 = inScan.next().toUpperCase();
                String playerId2 = inScan.next().toUpperCase();
                int[] date = splitDate(inScan.next());
                String location = inScan.next().toUpperCase();
                String score = inScan.next().toUpperCase();

                insertMatch(playerId1, playerId2, date[0], date[1],date [2], location, score);

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

    @Override
    public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseException
    {
        try
        {
            TennisPlayer newPlayer = new TennisPlayer(id, firstName, lastName, year, country);
            playerContainer.insertPlayer(newPlayer);
        }
        catch (TennisDatabaseException e)
        {
            System.out.println("Tennis Database Exception in insertPlayer");
        }

    }

    @Override
    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) throws TennisDatabaseException
    {
        TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month,day, tournament, score);


        try
        {
            matchContainer.insertMatch(m);
            playerContainer.insertMatch(m);
        }
        catch (TennisDatabaseRuntimeException e)
        {
            System.out.println("Error: Invalid Match. Match not added");
        }



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
    public void printMatchesOfPlayer(String idInput)
    {
        TennisMatch[] matchArray = playerContainer.getPlayerMatches(idInput);
        for(int i = 0; i < matchArray.length; i++)
        {
            System.out.println(String.format("%02d", matchArray[i].getDateYear()) + "/" + String.format("%02d", matchArray[i].getDateMonth()) +"/" + String.format("%02d", matchArray[i].getDateMonth()) + "," + " "
                    + playerContainer.getPlayer(matchArray[i].getIdPlayer1()).getFirstName() + " " + playerContainer.getPlayer(matchArray[i].getIdPlayer1()).getLastName()
                    + "-" + playerContainer.getPlayer(matchArray[i].getIdPlayer2()).getFirstName() + " " + playerContainer.getPlayer(matchArray[i].getIdPlayer2()).getLastName()
                    + "," + " " + matchArray[i].getTournament() + "," + " " + matchArray[i].getMatchScore());
        }

    }
    public void printAllPlayer()
    {

        if(playerContainer.getPlayerCount() == 0)
        {
            System.out.println("No Players in System");
        }
        else
        {
            TennisPlayer[] playerArray = getAllPlayers();
            calcWinLoss();
            for (int i = 0; i < playerArray.length; i++)
            {
                System.out.println(playerArray[i].getId() + ": " + playerArray[i].getFirstName() + " " +
                        playerArray[i].getLastName() + ", " + playerArray[i].getBirthYear() + ", " + playerArray[i].getWins() + "/" + playerArray[i].getLosses() + " " + "(WIN/LOSS)");
            }
        }
    }
    public void calcWinLoss()
    {
        TennisMatch[] array = matchContainer.getAllMatches();
        for(int i = 0; i < getMatchCount(); i++)
        {
            if(array[i].getWinner() == 1)
            {
                playerContainer.getPlayer(array[i].getIdPlayer1()).addWin();
                playerContainer.getPlayer(array[i].getIdPlayer2()).addLoss();
            }
            else
            {
                playerContainer.getPlayer(array[i].getIdPlayer1()).addLoss();
                playerContainer.getPlayer(array[i].getIdPlayer2()).addWin();
            }
        }
    }
    public int getMatchCount()
    {
        return matchContainer.getMatchCount();
    }

}
