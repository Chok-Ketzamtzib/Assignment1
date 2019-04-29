package tennisDatabase;

public class TennisPlayerContainerNode {

	// TODO: vvv make the following private vvv
	TennisPlayerContainerNode next;
	TennisPlayerContainerNode prev;

	TennisPlayer player;

	// TODO: List of matches for this player
	public TennisPlayerContainerNode(TennisPlayer inputPlayer) {
		this.next = null;
		this.player = null;
		this.player = inputPlayer;
		// this.player = new TennisPlayer( inputPlayer.getFirstName(),
		// inputPlayer.getLastName(), ...)
	}
}
