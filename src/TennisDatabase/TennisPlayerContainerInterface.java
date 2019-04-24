
// Steven Causley
// Interface by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayerContainer class.
interface TennisPlayerContainerInterface {

	// Desc.: Insert a tennis player into this container.
	// Input: A tennis player.
	// Output: Throws a checked (critical) exception if player id is already in this
	// container.
	// Throws a checked (critical) exception if the container is full.
	public void insertPlayer(TennisPlayer p) throws TennisDatabaseException;

	// Desc.: Insert a tennis match into the lists of both tennis players of the
	// input match.
	// Input: A tennis match.
	// Output: Throws a checked (critical) exception if the insertion is not fully
	// successful.
	public void insertMatch(TennisMatch m) throws TennisDatabaseException;

	// Desc.: Returns copies (deep copies) of all players in the database arranged
	// in the output array (sorted by id, alphabetically).
	// Output: Throws an unchecked (non-critical) exception if there are no players
	// in this container.
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException;

}
