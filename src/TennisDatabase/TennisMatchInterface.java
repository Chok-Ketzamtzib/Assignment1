
// Steven Causley
// Interface by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

import java.lang.String;

// Interface (package-private) providing the specifications for the TennisMatch class.
interface TennisMatchInterface extends Comparable<TennisMatch> {

    // Accessors (getters).
    public String getIdPlayer1();

    public String getIdPlayer2();

    public int getDateYear();

    public int getDateMonth();

    public int getDateDay();

    public String getTournament();

    public String getMatchScore();

    public int getWinner();

    // Desc.: Prints this match on the console.
    public void print();

}
