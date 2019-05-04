/** 
* This file contains methods which allow one to manipulate a collection of tennis records
* Stores two objects called TennisPlayerContainer & TennisMatchContainer
* @project CS-102 Assignment 1
* @author William Wakefield
* @date 27 April 2019
*/
package tennisDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface {
	
	private TennisPlayerContainer playerContainer = new TennisPlayerContainer(); //Creates object to access TennisplayerContainer class 
	private TennisMatchContainer matchContainer = new TennisMatchContainer(); //creates object to access TennisMatchContainer class

	@Override
	public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException {

		Scanner fileScan;
		try { 
			File inFile = new File(fileName);
			fileScan = new Scanner(inFile).useDelimiter("[\\r\\n]+");
		} catch (FileNotFoundException e) {
			throw new TennisDatabaseException("ERROR: Input file not found.");
		}

		while (fileScan.hasNextLine()) {

			String inString = fileScan.nextLine();
			Scanner inScan = new Scanner(inString).useDelimiter("[\\r\\n/]");
			String token = inScan.next().toUpperCase();

			if (token.equals("PLAYER")) {
				
				String id = inScan.next().toUpperCase();
				String firstName = inScan.next().toUpperCase();
				String lastName = inScan.next().toUpperCase();
				int year = inScan.nextInt();
				String country = inScan.next().toUpperCase();
				
				insertPlayer(id, firstName, lastName, year, country);
			}

			else if (token.equals("MATCH")) {
				String idPlayer1 = inScan.next().toUpperCase();
				String idPlayer2 = inScan.next().toUpperCase();
				int[] date = splitDate(inScan.next());
				String tournament = inScan.next().toUpperCase();
				String score = inScan.next().toUpperCase();
				
				insertMatch(idPlayer1, idPlayer2, date[0], date[1], date[2], tournament, score);
			}
			
			else {
				fileScan.close();
				inScan.close();
				throw new TennisDatabaseException("ERROR: Input file not formatted correctly");
			}
			inScan.close();
		}
		fileScan.close();

	}

	@Override
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException {
		
		return playerContainer.getAllPlayers();
	}

	@Override
	public TennisMatch[] getMatchesOfPlayer(String playerId)
			throws TennisDatabaseException, TennisDatabaseRuntimeException {
		
		return playerContainer.getMatchesOfPlayer(playerId);
	}
	 //Prints matches with a specific player id
    public String[] getMatchesOfPlayerString(String idInput)
    {
        TennisMatch[] matchArray = playerContainer.getPlayerMatches(idInput);
        if(matchArray.length==0) {//if player has no matches  
        	String[] outputArray = {"This player does not have any matches. Refer to command 5 if you would like to insert matches for this player"};
            return outputArray;
        } else {
            String[] outputArray = new String[matchArray.length];
            for (int i = 0; i < matchArray.length; i++) {
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
    
    public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException {
        
    	return playerContainer.getPlayer(id);
    }
    
	@Override
	public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException {
		
		return matchContainer.getAllMatches();
	}

	@Override //Adds player data to playerContainer
	public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseException {
		
		try {
			TennisPlayer newPlayer = new TennisPlayer(id, firstName, lastName, year, country);
			playerContainer.insertPlayer(newPlayer); 
            
		} catch (TennisDatabaseException e) {
			throw new TennisDatabaseRuntimeException("Tennis Database Exception in insertPlayer");
		}

	}

	@Override //Adds match data to matchContainer
	public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament,
			String score) throws TennisDatabaseException {
		TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month, day, tournament, score);
		
        try {
            matchContainer.insertMatch(m);
            playerContainer.insertMatch(m);
        } catch (TennisDatabaseRuntimeException e) {
            throw new TennisDatabaseRuntimeException("Error: Invalid Match. Match not added");
        }

	}
	
	//splits the date into a String array which is parsed into Integer to be used with TennisMatch constructor
	//TODO: insert try catch block, catch statement is date invalid, return null, work with null
    public int[] splitDate(String date) throws TennisDatabaseException {
    	
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        
        int[] parsedDate= new int[3];
        parsedDate[0] = Integer.parseInt(year);
        parsedDate[1] = Integer.parseInt(month);
        parsedDate[2] = Integer.parseInt(day);
        
        return parsedDate;
    }

    //Converts all players' data within playerContainer into String array
    public String [] getPlayerStringArray() {

        if (playerContainer.getPlayerCount() == 0) {
            String[] outputArray = new String[1];
            outputArray[0]="No Players in System";
            return outputArray;
        } else {
            String[] outputArray = new String[playerContainer.getPlayerCount()];
            TennisPlayer[] playerArray = getAllPlayers();
            calcWinLoss();
            for (int i = 0; i < playerArray.length; i++) {
                outputArray[i]=(playerArray[i].getId() + ": " + playerArray[i].getFirstName() + " " +
                        playerArray[i].getLastName() + ", " + playerArray[i].getBirthYear() + ", " + playerArray[i].getWins() + "/" + playerArray[i].getLosses() + " " + "(WIN/LOSS)");
            }
            return outputArray;
        }
    }
    
    //Calculates amount of matches won/lost for all players
    public void calcWinLoss() {
        TennisMatch[] array = getAllMatches();
         for (int i = 0; i < getMatchCount(); i++) {
            if (array[i].getWinner() == 1) {
                getPlayer(array[i].getIdPlayer1()).addWin();
                getPlayer(array[i].getIdPlayer2()).addLoss();
            } else {
                getPlayer(array[i].getIdPlayer1()).addLoss();
                getPlayer(array[i].getIdPlayer2()).addWin();
            }
        }
    }
    
    //gets number of matches in matchContainer
    public int getMatchCount() {
    	
        return matchContainer.getMatchCount();
        
    }

}
