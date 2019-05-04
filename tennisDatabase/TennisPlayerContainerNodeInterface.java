


// Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package tennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayerNode class.
interface TennisPlayerContainerNodeInterface {
   
   // Accessors (getters).
   public TennisPlayer getPlayer();
   public TennisPlayerContainerNode getPrev();
   public TennisPlayerContainerNode getNext();
   
   // Modifiers (setters).
   public void setPrev( TennisPlayerContainerNode p );
   public void setNext( TennisPlayerContainerNode n );
   
   // Desc.: Insert a TennisMatch object (reference) into this node.
   // Input: A TennisMatch object (reference).
   // Output: Throws an exception if match cannot be inserted in this list.
   public void insertMatch( TennisMatch m ) throws TennisDatabaseException;
   
   // Desc.: Returns all matches of this player arranged in the output array (sorted by date, most recent first).
   // Output: Throws an exception if there are no matches in this list.
   public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException;
   
}


