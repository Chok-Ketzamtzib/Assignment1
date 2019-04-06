package TennisDatabase;

public class TennisDatabase implements TennisDatabaseInterface {

	@Override
	public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub

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
