package TennisDatabase;

class TennisMatchContainer implements TennisMatchContainerInterface
{
    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {

    }

    @Override
    public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException
    {
        return new TennisMatch[0];
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException
    {
        return new TennisMatch[0];
    }
}
