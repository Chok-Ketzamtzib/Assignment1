//Steven Causley
//CS-192, Spring 2019
//Assignment 1

package TennisDatabase;

class TennisPlayerContainer implements TennisPlayerContainerInterface
{
    private TennisPlayerContainerNode head;
    private int playerCount = 0;

    public TennisPlayerContainer()
    {
        this.head = null;
    }

    //Searches through nodes to find player. Throws exception if id does not exist
    public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException
    {
        TennisPlayerContainerNode node = this.head;
        boolean idFound = false;
        int nodeIndex = 0;
        while ((nodeIndex < this.playerCount) && (node.getPlayer().getId().compareTo(id) < 0))
        {
            node = node.getNext();
            nodeIndex++;
        }
        // Check if we found the node.
        if ((node != null) && (node.getPlayer().getId().equals(id)))
        {
            idFound = true;
        }

        if (idFound)
        {
            return node.getPlayer();
        } else
        {
            throw new TennisDatabaseRuntimeException("Player could not be found.");
        }
    }

    //Searches for player with inputted id and creates an array of their matches
    public TennisMatch[] getPlayerMatches(String id) throws TennisDatabaseRuntimeException
    {
        TennisPlayerContainerNode node = this.head;
        boolean idFound = false;
        int nodeIndex = 0;
        while ((nodeIndex < this.playerCount) && (node.getPlayer().getId().compareTo(id) < 0))
        {
            node = node.getNext();
            nodeIndex++;
        }
        // Check if we found the node.
        if ((node != null) && (node.getPlayer().getId().equals(id)))
        {
            idFound = true;
        }

        if (idFound)
        {
            return node.getMatches();
        } else
        {
            throw new TennisDatabaseRuntimeException("Player could not be found.");
        }
    }

    //adds new player and player container node
    @Override
    public void insertPlayer(TennisPlayer p) throws TennisDatabaseException
    {
        if (!dupePlayerCheck(p))
        {
            // Special case: list empty, no need to consider sorting, insert at front.
            if (this.playerCount == 0)
            {
                // Create a sorted doubly-linked circular list with only 1 node.
                TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(p);
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
                this.head = newNode;
                this.playerCount++;
            } else
            {
                // List not empty: find the point of insertion.
                TennisPlayerContainerNode currNode = this.head;
                TennisPlayerContainerNode prevNode = currNode.getPrev();
                int currNodeIndex = 0;
                while ((currNodeIndex < this.playerCount) &&
                        (currNode.getPlayer().compareTo(p) < 0))
                {
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
                if (currNodeIndex == 0)
                {
                    this.head = newNode;
                }
            }
        } else
        {
            throw new TennisDatabaseException("Duplicate Player Detected. Insertion Failed");
        }
    }

    //Adds match to proper player nodes
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
        while ((nodeP1Index < this.playerCount) && (nodeP1.getPlayer().getId().compareTo(idPlayer1) < 0))
        {
            nodeP1 = nodeP1.getNext();
            nodeP1Index++;
        }
        // Check if we found the node of player1.
        if ((nodeP1 != null) && (nodeP1.getPlayer().getId().equals(idPlayer1)))
        {
            p1Found = true;
        }
        // Search the node associated with player2, by id.
        TennisPlayerContainerNode nodeP2 = this.head;
        boolean p2Found = false;
        int nodeP2Index = 0;
        while ((nodeP2Index < this.playerCount) && (nodeP2.getPlayer().getId().compareTo(idPlayer2) < 0))
        {
            nodeP2 = nodeP2.getNext();
            nodeP2Index++;
        }
        // Check if we found the node of player2.
        if ((nodeP2 != null) && (nodeP2.getPlayer().getId().equals(idPlayer2)))
        {
            p2Found = true;
        }
        // ...
        if (p1Found && p2Found)
        {
            // Insert match "m" into the node of player1.
            nodeP1.insertMatch(m);
            // Insert match "m" into the node of player2.
            nodeP2.insertMatch(m);
        } else
        {
            throw new TennisDatabaseException("");
        }
    }

    @Override
    public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException
    {
        TennisPlayer[] output = new TennisPlayer[playerCount];
        TennisPlayerContainerNode node = head;

        output[0] = head.getPlayer();
        node = node.getNext();

        for (int i = 1; i < playerCount; i++)
        {
            output[i] = node.getPlayer();
            node = node.getNext();
        }

        return output;
    }

    @Override
    public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException, TennisDatabaseRuntimeException
    {
        TennisPlayerContainerNode node = this.head;
        boolean idFound = false;
        int nodeIndex = 0;
        while ((nodeIndex < this.playerCount) && (node.getPlayer().getId().compareTo(playerId) < 0))
        {
            node = node.getNext();
            nodeIndex++;
        }
        // Check if we found the node.
        if ((node != null) && (node.getPlayer().getId().equals(playerId)))
        {
            idFound = true;
        }

        if (idFound)
        {
            return node.getMatches();
        } else
        {
            throw new TennisDatabaseRuntimeException("Player could not be found.");
        }
    }

    //checks if inputted player already exists
    public boolean dupePlayerCheck(TennisPlayer inPlayer)
    {
        TennisPlayerContainerNode node = this.head;
        for (int i = 0; i < playerCount; i++)
        {
            if (node.getPlayer().getId().equals(inPlayer.getId()))
            {
                return true;
            }
        }
        return false;
    }

    public int getPlayerCount()
    {
        return playerCount;
    }
}
