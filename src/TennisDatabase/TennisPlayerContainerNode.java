//Steven Causley
//CS-192, Spring 2019
//Assignment 1

package TennisDatabase;

class TennisPlayerContainerNode implements TennisPlayerContainerNodeInterface
{

    private TennisPlayerContainerNode next;
    private TennisPlayerContainerNode prev;
    private TennisPlayer player;
    private SortedLinkedList<TennisMatch> list; // List of matches of this player.

    public TennisPlayerContainerNode(TennisPlayer inputPlayer)
    {
        this.next = null;
        this.prev = null;
        this.player = inputPlayer;
        this.list = new SortedLinkedList<TennisMatch>();

    }

    @Override
    public TennisPlayer getPlayer()
    {
        return this.player;
    }

    @Override
    public TennisPlayerContainerNode getPrev()
    {
        return this.prev;
    }

    @Override
    public TennisPlayerContainerNode getNext()
    {
        return this.next;
    }

    @Override
    public void setPrev(TennisPlayerContainerNode p)
    {
        this.prev = p;
    }

    @Override
    public void setNext(TennisPlayerContainerNode n)
    {
        this.next = n;
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {
        try
        {
            list.insert(m);
        } catch (Exception e)
        {
            throw new TennisDatabaseException("");
        }
    }

    @Override
    public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException
    {
        TennisMatch[] a = list.getAll();
        TennisMatch[] b = new TennisMatch[a.length];

        for (int i = 0; i < a.length; i++)
        {
            b[i] = new TennisMatch(a[i]);
        }
        return b;
    }
}
