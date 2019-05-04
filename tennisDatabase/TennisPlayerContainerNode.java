package tennisDatabase;

 class TennisPlayerContainerNode {

	private TennisPlayerContainerNode next;
	private TennisPlayerContainerNode prev;

	private TennisPlayer player;
	private SortedLinkedList<TennisMatch> list; // List of matches of this player.

	public TennisPlayerContainerNode(TennisPlayer inputPlayer) {
		this.next = null;
		this.player = null;
		this.player = inputPlayer;
		this.list = new SortedLinkedList<TennisMatch>();
	}
	
    public TennisPlayer getPlayer() {
        return this.player;
    }

    public TennisPlayerContainerNode getPrev() {
        return this.prev;
    }

    public TennisPlayerContainerNode getNext() {
        return this.next;
    }

    public void setPrev(TennisPlayerContainerNode p) {
        this.prev = p;
    }

    public void setNext(TennisPlayerContainerNode n) {
        this.next = n;
    }

    public void insertMatch(TennisMatch m) throws TennisDatabaseException {

    	try {
            list.insert(m);
        } catch (Exception e) {
            throw new TennisDatabaseException("insertion to doubly linked list failed");
        }
    	
    }

    public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException { //utilizes shadow cloning method
    	
        TennisMatch[] a = new TennisMatch[list.size()];
        
        for(int i = 0; i < list.size();i++) {
        	
            a[i] = list.get(i);
        }

        TennisMatch[] b = new TennisMatch[a.length];

        for (int i = 0; i < a.length; i++) {
        	
            b[i] = new TennisMatch(a[i]); //copy constructor to TennisMatch Class
        
        }
        
        return b;
    }
}
