package tennisDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TennisDatabase implements TennisDatabaseInterface {
	
	

	@Override
	public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		
		String fileData;
		BufferedReader in; // Reads text from a character-input stream from File 
		try { 
			
			in = new BufferedReader(new FileReader(fileName));
		
			while((fileData= in.readLine()) != null) { //while each line in the file has text
			    System.out.println(fileData);
			}
			
			in.close();
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
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
