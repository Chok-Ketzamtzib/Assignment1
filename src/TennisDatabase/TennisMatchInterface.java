


// Steven Causley
// Interface by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

import java.lang.String;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

// Interface (package-private) providing the specifications for the TennisMatch class.
public interface TennisMatchInterface extends Comparable<TennisMatch> {      
   // Accessors (getters).
   public String getIdPlayer1();
   public String getIdPlayer2();
   public int getDateYear();
   public int getDateMonth();
   public int getDateDay();
   public String getTournament();
   public String getMatchScore();
   public int getWinner();
   
   // Desc.: Static method to process a tennis match score (as a string), recursively.
   // Output: An integer value that could be only 1 (player 1 won) or 2 (player 2 won).
   //         Throws an unchecked (non-critical) exception if the score is invalid (no winner).
   public static int processMatchScore( String matchScore ) throws TennisDatabaseRuntimeException {
      // STEP 1: Convert match score ("6-3,6-7,6-2") into sets won (2-1).
      int[] setScore = processMatchScoreRec( matchScore );
      int setsPlayer1 = setScore[0];
      int setsPlayer2 = setScore[1];
      // STEP 2: Compare sets won by player 1 versus sets won by player 2, and return winner.
      if( setsPlayer1 > setsPlayer2 ) { return 1; }
      else if( setsPlayer2 > setsPlayer1 ) { return 2; }
      else { throw new TennisDatabaseRuntimeException( "Match score processing: no winner!" ); }
   }
   
   // Desc.: Static internal method to process a tennis match score (as a string), recursively.
   // Output: An array of 2 integers storing the sets won by each player.
   //         Throws an unchecked (non-critical) exception if the score is invalid (no winner).
   private static int[] processMatchScoreRec( String matchScore ) throws TennisDatabaseRuntimeException {
      // Init output variable.
      int[] setScore = new int[] { 0, 0 };
      // Error: input score is empty (recursion should NEVER reach this point).
      if( matchScore.length() == 0 ) { throw new TennisDatabaseRuntimeException( "Match score processing: empty match score!" ); }
      // Input score NOT empty.
      else {
         // Extract set 1 data, and process it.
         try {
            Scanner scoreScanner = new Scanner(matchScore).useDelimiter(",");
            String set1Score = scoreScanner.next();
            Scanner set1Scanner = new Scanner(set1Score).useDelimiter("-");
            int gamesPlayer1 = set1Scanner.nextInt();
            int gamesPlayer2 = set1Scanner.nextInt();
            // Process set 1 data to determine set 1 winner.
            if( gamesPlayer1 > gamesPlayer2 ) { setScore[0]++; }
            else if( gamesPlayer1 < gamesPlayer2 ) { setScore[1]++; }
            else { throw new TennisDatabaseRuntimeException( "Match score processing: invalid set score!" ); }
            // Extract rest of score, and process it (recursively).
            // Check if input score includes only 1 sets
            // BASE CASE: match score with only 1 set.
            if( set1Score.length() == matchScore.length() ) { return setScore; }
            // RECURSION: process rest of score (except set 1) recursively.
            else {
               String restScore = matchScore.substring( set1Score.length()+1 );
               int[] otherSetsScore = processMatchScoreRec( restScore );
               setScore[0] += otherSetsScore[0];
               setScore[1] += otherSetsScore[1];
               return setScore;
            }
         }
         catch( InputMismatchException e ) { throw new TennisDatabaseRuntimeException( "Match score processing: invalid score!" ); }
         catch( NoSuchElementException e ) { throw new TennisDatabaseRuntimeException( "Match score processing: invalid score!" ); }
      }
   }
   
}


