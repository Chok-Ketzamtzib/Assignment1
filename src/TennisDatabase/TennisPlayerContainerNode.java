package TennisDatabase;

public class TennisPlayerContainerNode implements TennisPlayerNodeInterface
{
    //TODO: Change to private variables, work with getters/setters
    TennisPlayerContainerNode next;
    TennisPlayerContainerNode prev;

    TennisPlayer player;

    public TennisPlayerContainerNode(TennisPlayer inputPlayer)
    {
        this.next = null;
        this.prev = null;
        this.player = inputPlayer;
        //this.player = new TennisPlayer(inputPlayer.getFirstName(), inputPlayer.getLastName()......);
    }

    @Override
    public TennisPlayer getPlayer()
    {
        return null;
    }

    @Override
    public TennisPlayerContainerNode getPrev()
    {
        return null;
    }

    @Override
    public TennisPlayerContainerNode getNext()
    {
        return null;
    }

    @Override
    public void setPrev(TennisPlayerContainerNode p)
    {

    }

    @Override
    public void setNext(TennisPlayerContainerNode n)
    {

    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {

    }

    @Override
    public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException
    {
        return new TennisMatch[0];
    }
}
