package tennisDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface {

	@Override
	public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		

	        Scanner fileScan;
	        int playerCount = 1;
	        int matchCount = 1;

	        TennisMatchContainer matchContainer = new TennisMatchContainer();
	        
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

	            if (token.equals("PLAYER")){
	            
	            	System.out.println(inString);
	            	
	                String id = inScan.next().toUpperCase();
					String firstName = inScan.next().toUpperCase();
					String lastName = inScan.next().toUpperCase();
					int year = inScan.nextInt();
					String country = inScan.next().toUpperCase();
					TennisPlayer p = new TennisPlayer(id,firstName,lastName,year,country);
					//TennisPlayerContainer.insertPlayer(p)
					playerCount++;
	            }
	                
	                
	                else if (token.equals("MATCH")) {
	            	System.out.println(inString);
	            	matchContainer.insertMatch();	            	
	                }
	               
	                 
	            }
	        

			}

	@Override
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TennisMatch[] getMatchesOfPlayer(String playerId)
			throws TennisDatabaseException, TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPlayer(String id, String firstName, String lastName, int year, String country)
			throws TennisDatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament,
			String score) throws TennisDatabaseException {
		// TODO Auto-generated method stub

	}

}
