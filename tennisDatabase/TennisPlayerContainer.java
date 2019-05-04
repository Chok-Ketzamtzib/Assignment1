package tennisDatabase;

 class TennisPlayerContainer implements TennisPlayerContainerInterface {

	private TennisPlayerContainerNode head;
	private int playerCount = 0;

	public TennisPlayerContainer() {

		this.head = null;

	}

	@Override
	public void insertPlayer(TennisPlayer p) throws TennisDatabaseException {
		
		if (!idNewPlayerCheck(p)) {
          
            if (this.playerCount == 0) {// If list empty, no need to consider sorting, insert at front.
                
            	// Create a sorted double-linked circular list with only one node.
                TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(p);
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
                this.head = newNode;
                this.playerCount++;
                
            } else {//List not empty, find the point of insertion.
                
                TennisPlayerContainerNode currNode = this.head;
                TennisPlayerContainerNode prevNode = currNode.getPrev();
                int currNodeIndex = 0;
                
                while ((currNodeIndex < this.playerCount) && (currNode.getPlayer().compareTo(p) < 0)) {
                    prevNode = currNode;
                    currNode = currNode.getNext();
                    currNodeIndex++;
                }
                //"currNode" and "prevNode" point at the 2 sides of the insertion point.
                //Perform insertion
                TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(p);
                newNode.setNext(currNode);
                newNode.setPrev(prevNode);
                prevNode.setNext(newNode);
                currNode.setPrev(newNode);
                this.playerCount++;
                // Special case, insertion point is at front.
                if (currNodeIndex == 0) {
                    this.head = newNode;
                }
            }
        } else {
            throw new TennisDatabaseException("Duplicate Player Detected. Insertion Failed");
        }
	}

	@Override
	public void insertMatch(TennisMatch m) throws TennisDatabaseException { 
		
		 // Extract the ids of player1 and player2 of the input match "m"
        String idPlayer1 = m.getIdPlayer1();
        String idPlayer2 = m.getIdPlayer2();
        // Search the node associated with player1, by id.
        TennisPlayerContainerNode nodePlayer1 = this.head;
        boolean p1Found = false;
        int nodeP1Index = 0;
        while ((nodeP1Index < this.playerCount) && (nodePlayer1.getPlayer().getId().compareTo(idPlayer1) < 0)) {
            nodePlayer1 = nodePlayer1.getNext();
            nodeP1Index++;
        }
        // Check if we found the node of player1.
        if ((nodePlayer1 != null) && (nodePlayer1.getPlayer().getId().equals(idPlayer1))) {
            p1Found = true;
        }
        // Search the node associated with player2, by id.
        TennisPlayerContainerNode nodePlayer2 = this.head;
        boolean p2Found = false;
        int nodeP2Index = 0;
        while ((nodeP2Index < this.playerCount) && (nodePlayer2.getPlayer().getId().compareTo(idPlayer2) < 0)) {
            nodePlayer2 = nodePlayer2.getNext();
            nodeP2Index++;
        }
        // Check if we found the node of player2.
        if ((nodePlayer2 != null) && (nodePlayer2.getPlayer().getId().equals(idPlayer2))) {
            p2Found = true;
        }
        if (p1Found && p2Found) {
            // Insert match "m" into the node of player1.
            nodePlayer1.insertMatch(m);
            // Insert match "m" into the node of player2.
            nodePlayer2.insertMatch(m);
        } else {
            throw new TennisDatabaseException("Unable to find ids of player 1 and player 2");
        }

	}

	@Override
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException {
		  	
		TennisPlayer[] allPlayers = new TennisPlayer[playerCount];
		TennisPlayerContainerNode node = head;

	    allPlayers[0] = head.getPlayer();
	    node = node.getNext();

	       	for (int i = 1; i < playerCount; i++) {
	            allPlayers[i] = node.getPlayer();
	            node = node.getNext();
	        }

	        return allPlayers;
	}

	//Searches through nodes to find player. Throws exception if id does not exist
	public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException {
		
		 TennisPlayerContainerNode node = this.head;
	        boolean idFound = false;
	        int nodeIndex = 0;
	        while ((nodeIndex < this.playerCount) && (node.getPlayer().getId().compareTo(id) < 0)) {
	            node = node.getNext();
	            nodeIndex++;
	        }
	      
	        if ((node != null) && (node.getPlayer().getId().equals(id))) {  // Check if the node is found
	            idFound = true;
	        }

	        if (idFound) {
	            return node.getPlayer();
	        } else {
	        	
	            throw new TennisDatabaseRuntimeException("Player could not be found, id does not exist");
	        }
	}
	
	//Searches for player with inputted id and creates an array of their matches
    public TennisMatch[] getPlayerMatches(String id) throws TennisDatabaseRuntimeException {
    	
        TennisPlayerContainerNode node = this.head;
        boolean idFound = false;
        int nodeIndex = 0;

        while(nodeIndex < this.playerCount && !(node.getPlayer().getId().equals(id))) {
        	node = node.getNext();
        	nodeIndex++;
        }
        
        if(node != null) {
        	return node.getMatches();
        }
        
        throw new TennisDatabaseRuntimeException("Player could not be found.");

    }

	@Override
	public TennisMatch[] getMatchesOfPlayer(String playerId) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		
		TennisPlayerContainerNode node = this.head;
        boolean idFound = false;
        int nodeIndex = 0;
        while ((nodeIndex < this.playerCount) && (node.getPlayer().getId().compareTo(playerId) < 0)) {
            node = node.getNext();
            nodeIndex++;
        }
        // Check if we found the node.
        if ((node != null) && (node.getPlayer().getId().equals(playerId))) {
            idFound = true;
        }

        if (idFound) {
            return node.getMatches();
        } else {
            throw new TennisDatabaseRuntimeException("Player could not be found.");
        }
	}
	
	//checks if new player ID already exists
    public boolean idNewPlayerCheck(TennisPlayer inPlayer) {
    	
        TennisPlayerContainerNode node = this.head;
        
        for (int i = 0; i < playerCount; i++) {
        	
            if (node.getPlayer().getId().equals(inPlayer.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public int getPlayerCount() {
        
    	return playerCount;
    	
    }
}
