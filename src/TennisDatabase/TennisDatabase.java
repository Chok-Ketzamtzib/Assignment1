package TennisDatabase;

public class TennisDatabase implements TennisDatabaseInterface
{
    @Override
    public void loadFromFile(String fileName) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {

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
