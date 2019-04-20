package TennisDatabase;

public class TennisMatchContainer implements TennisMatchContainerInterface
{
    private TennisMatch[] matchArray;
    private int matchCount;//number of matches in array (logical size)
    private int maxMatches = 2; //max number of matches in array

    public TennisMatchContainer()
    {
        this.matchArray = new TennisMatch[2];
        this.matchCount = 0;
    }
    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {
        if(this.matchCount == maxMatches)
        {
            //array full
            //throw new TennisDatabaseException("ERROR: Container full, cannot insert match.");
            TennisMatch[] newArray = new TennisMatch[this.matchArray.length * 2];
            for(int i =0; i < this.matchCount; i++)
            {
                newArray[i] = this.matchArray[i];
            }
            this.matchArray = newArray;
            this.maxMatches = this.matchArray.length;
        }

            //array not full
            this.matchArray[this.matchCount] = m;
            this.matchCount++;
        System.out.println("MATCH LOADED");
    }

    @Override
    public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException
    {
        return matchArray;
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException
    {
        return new TennisMatch[0];
    }
}
