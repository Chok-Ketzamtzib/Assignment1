


// Steven Causley
// Interface by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

import java.lang.String;

// Interface (package-private) providing the specifications for the TennisDatabase class.
interface TennisDatabaseInterface {

   // Desc.: Loads data from file following the format described in the specifications.
   // Output: Throws an unchecked (non-critical) exception if the loading is not fully successfull.
   //         Throws a checked (critical) exception if the file (file name) does not exist.
   public void loadFromFile( String fileName ) throws TennisDatabaseException, TennisDatabaseRuntimeException;
   
   // Desc.: Search for a player in the database by input id, and returns a copy of that player (if found).
   // Output: Throws an unchecked (non-critical) exception if there is no player with that input id.
   public TennisPlayer getPlayer( String id ) throws TennisDatabaseRuntimeException;
   
   // Desc.: Returns copies (deep copies) of all players in the database arranged in the output array (sorted by id, alphabetically).
   // Output: Throws an unchecked (non-critical) exception if there are no players in the database.
   public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException;
   
   // Desc.: Returns copies (deep copies) of all matches of input player (id) arranged in the output array (sorted by date, most recent first).
   // Input: The id of a player.
   // Output: Throws a checked (critical) exception if the player (id) does not exists.
   //         Throws an uncheckedor (non-critical) exception if there are no matches (but the player id exists).
   public TennisMatch[] getMatchesOfPlayer( String playerId  ) throws TennisDatabaseException, TennisDatabaseRuntimeException;
   
   // Desc.: Returns copies (deep copies) of all matches in the database arranged in the output array (sorted by date, most recent first).
   // Output: Throws an unchecked (non-critical) exception if there are no matches in the database.
   public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException;
   
   // Desc.: Insert a player into the database.
   // Input: All the data required for a player.
   // Output: Throws a checked (critical) exception if player id is already in the database.
   public void insertPlayer( String id, String firstName, String lastName, int year, String country ) throws TennisDatabaseException;

   // Desc.: Insert a match into the database.
   // Input: All the data required for a match.
   // Output: Throws a checked (critical) exception if a player does not exist in the database.
   //         Throws a checked (critical) exception if the match score is not valid.
   public void insertMatch( String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score ) throws TennisDatabaseException;
   
}


