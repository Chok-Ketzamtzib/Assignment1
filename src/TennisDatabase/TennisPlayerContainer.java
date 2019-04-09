package TennisDatabase;

public class TennisPlayerContainer implements TennisPlayerContainerInterface
{
    @Override
    public void insertPlayer(TennisPlayer p) throws TennisDatabaseException
    {

    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {

    }

    @Override
    public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException
    {
        return new TennisPlayer[0];
    }
}
