//Steven Causley
//CS-192, Spring 2019
//Assignment 1

package TennisDatabase;

public class TennisPlayerContainer implements TennisPlayerContainerInterface
{
    private TennisPlayerContainerNode head;
    private int playerCount =0;

    public TennisPlayerContainer()
    {
        this.head = null;
    }


    public TennisPlayer getPlayer(String id)
    {
        return null;
    }
    @Override
    public void insertPlayer(TennisPlayer p) throws TennisDatabaseException
    {
        // Special case: list empty, no need to consider sorting, insert at front.
        if( this.playerCount == 0 ) {
            // Create a sorted doubly-linked circular list with only 1 node.
            TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(p);
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            this.head = newNode;
            this.playerCount++;
        }
        else {
            // List not empty: find the point of insertion.
            TennisPlayerContainerNode currNode = this.head;
            TennisPlayerContainerNode prevNode = currNode.getPrev();
            int currNodeIndex = 0;
            while( ( currNodeIndex < this.playerCount ) &&
                   ( currNode.getPlayer().compareTo( p ) < 0 ) ) {
                prevNode = currNode;
                currNode = currNode.getNext();
                currNodeIndex++;
            }
            // Here, "currNode" and "prevNode" point at the 2 sides of the insertion point.
            // Perform insertion.
            TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(p);
            newNode.setNext(currNode);
            newNode.setPrev(prevNode);
            prevNode.setNext(newNode);
            currNode.setPrev(newNode);
            this.playerCount++;
            // Special case: insertion point at front.
            if( currNodeIndex == 0 ) {
                this.head = newNode;
            }
        }
        System.out.println("PLAYER LOADED");
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseException
    {
        // Extract the ids of player1 and player2 of the input match "m"
        String idPlayer1 = m.getIdPlayer1();
        String idPlayer2 = m.getIdPlayer2();
        // Search the node associated with player1, by id.
        TennisPlayerContainerNode nodeP1 = this.head;
        boolean p1Found = false;
        int nodeP1Index = 0;
        while( ( nodeP1Index < this.playerCount ) && ( nodeP1.getPlayer().getId().compareTo(idPlayer1) < 0 ) ) {
            nodeP1 = nodeP1.getNext();
            nodeP1Index++;
        }
        // Check if we found the node of player1.
        if( ( nodeP1 != null ) && ( nodeP1.getPlayer().getId().equals(idPlayer1) ) ) {
            p1Found = true;
        }
        // Search the node associated with player2, by id.
        TennisPlayerContainerNode nodeP2 = this.head;
        boolean p2Found = false;
        int nodeP2Index = 0;
        while( ( nodeP2Index < this.playerCount ) && ( nodeP2.getPlayer().getId().compareTo(idPlayer2) < 0 ) ) {
            nodeP2 = nodeP2.getNext();
            nodeP2Index++;
        }
        // Check if we found the node of player2.
        if( ( nodeP2 != null ) && ( nodeP2.getPlayer().getId().equals(idPlayer2) ) ) {
            p2Found = true;
        }
        // ...
        if( p1Found && p2Found ) {
            // Insert match "m" into the node of player1.
            nodeP1.insertMatch(m);
            // Insert match "m" into the node of player2.
            nodeP2.insertMatch(m);
        }
        else {
            throw new TennisDatabaseException( "" );
        }
    }

    @Override
    public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException
    {
        return new TennisPlayer[0];
    }
}
