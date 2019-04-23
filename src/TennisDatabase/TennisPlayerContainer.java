//Steven Causley
//CS-192, Spring 2019
//Assignment 1
package TennisDatabase;

public class TennisPlayerContainer implements TennisPlayerContainerInterface
{
    private TennisPlayerContainerNode head;

    public TennisPlayerContainer()
    {
        this.head = null;
    }

    public void insertAtFront(TennisPlayer inputPlayer)
    {
        //TODO: Change to work with get/set
        //Step 1: Create a new node to store input player.
        TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(inputPlayer);
        //Step 2: Connect the new node to the existing nodes.
        newNode.next = this.head;//2a: linking new node to old first node
        newNode.prev = this.head.prev;//2b: linking new node to last node
        this.head.prev.next = newNode; //2c, get head, get prev, set next This is the last node
        this.head.prev = newNode;//2d linking old first node to new node
        //Step 3: Link head to the new first node
        this.head = newNode;
    }
    public TennisPlayer getPlayer(String id)
    {
        return null;
    }
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
