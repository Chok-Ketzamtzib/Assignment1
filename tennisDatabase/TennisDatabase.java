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
		/*
		Scanner fileScanner = null;
		int playerCounter =1;
		int matchCounter =1;
		
		try {
			File inputFile = new File (fileName);
			fileScanner = new Scanner(inputFile).useDelimiter("[\\r\\n]+");
		}
		catch( FileNotFoundException e) {
			throw new TennisDatabaseException("Input not found");
		}
		while (fileScanner.hasNextLine()) {
		String inputString = fileScanner.nextLine();
		Scanner inputScanner = new Scanner(inputString).useDelimiter("[\\r\\n/]");
		if (token.equals("PLAYER") ) {
		try {
		String id = inputScanner.next().toUpperCase(); //Uppercase not recommended
		String firstName = inputScanner.next().toUpperCase();
		String lastName = inputScanner.next().next().toUpperCase();
		int year = inputScanner.nextInt();
		String country = inputScanner.next();
		TennisPlayer p = new TennisPlayer( id, firstName, lastName, year, country);
		}
		}
		}
		*/

	        Scanner fileScan = null;
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
	            	System.out.println(inString);
	                try
	                {
	                    String id = inScan.next().toUpperCase();
	                    String firstName = inScan.next().toUpperCase();
	                    String lastName = inScan.next().toUpperCase();
	                    int year = inScan.nextInt();
	                    String country = inScan.next().toUpperCase();
	                    TennisPlayer p = new TennisPlayer(id,firstName,lastName,year,country);
	                    //tennisplayercountainer.insertplayer(p)
	                    playerCount++;
	                }
	                finally {
	                    System.out.println("Finally statement");
	                }
	                 
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
