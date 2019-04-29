


// Steven Causley
// Interface by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisMatchesContainer class.
interface TennisMatchContainerInterface {

   // Desc.: Insert a tennis match into this container.
   // Input: A tennis match.
   // Output: Throws a checked (critical) exception if the container is full.
   public void insertMatch( TennisMatch m ) throws TennisDatabaseException;
   
   // Desc.: Returns all matches in the database arranged in the output array (sorted by date, most recent first).
   // Output: Throws an exception if there are no matches in this container.
   public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException;
   
   // Desc.: Returns all matches of input player (id) arranged in the output array (sorted by date, most recent first).
   // Input: The id of the tennis player.
   // Output: Throws an unchecked (non-critical) exception if there are no tennis matches in the list.
   public TennisMatch[] getMatchesOfPlayer( String playerId ) throws TennisDatabaseRuntimeException, TennisDatabaseException;
   
}


