// Steven Causley
// CS-102, Spring 2019
// Assignment 1
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
        if (this.matchCount == maxMatches)
        {
            TennisMatch[] newArray = new TennisMatch[this.matchArray.length * 2];
            for (int i = 0; i < this.matchCount; i++)
            {
                newArray[i] = this.matchArray[i];
            }
            this.matchArray = newArray;
            this.maxMatches = this.matchArray.length;
        }

        int point = 0;
        while ((point < this.matchCount) && (this.matchArray[point].compareTo(m) > 0))
        {
            point++;
        }
        if (point < this.matchCount)
        {
            for (int i = this.matchCount - 1; i >= point; i--)
            {
                this.matchArray[i + 1] = this.matchArray[i];
            }
        }
        this.matchArray[point] = m;
        this.matchCount++;
    }

    @Override
    public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException
    {
        return matchArray;
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException
    {
        /*
        int matches = 0;
        TennisMatch[] output = new TennisMatch[matches];
        for (int i = 0; i< this.matchCount; i++)
        {
            if (this.matchArray[i].getIdPlayer1().equals(playerId) || this.matchArray[i].getIdPlayer1().equals(playerId))
            {
                matches++;
                output[matches] = matchArray[i];
            }
        }
        for (int i )
        */

        return null;
    }

    public int getMatchCount()
    {
        return matchCount;
    }

}
