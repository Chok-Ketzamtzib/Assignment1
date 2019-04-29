package tennisDatabase;

public class TennisPlayerContainer implements TennisPlayerContainerInterface {

	private TennisPlayerContainerNode head;

	public TennisPlayerContainer() {

		this.head = null;

	}

	public void insertAtFront(TennisPlayer inputPlayer) {

		// Step 1: create a new node to store input player.
		TennisPlayerContainerNode newNode = new TennisPlayerContainerNode(inputPlayer);
		// STEP 2: Connect the new node to the existing nodes
		newNode.next = this.head; // STEP 2A
		newNode.prev = this.head.prev; // STEP 2B
		this.head.prev.next = newNode; // STEP 2C
		this.head.prev = newNode; // STEP 2D
		// STEP 3: Link head to the new first node.
		this.head = newNode;

	}

	@Override
	public void insertPlayer(TennisPlayer p) throws TennisDatabaseException {

	}

	@Override
	public void insertMatch(TennisMatch m) throws TennisDatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TennisPlayer getPlayer(String id) throws TennisDatabaseRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
