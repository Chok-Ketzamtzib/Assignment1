


// Steven Causley
// Original by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

// SortedLinkedListNode generic class, implementing the node for the SortedLinkedList class.
class SortedLinkedListNode<T>
{

   T item; // Data.
   SortedLinkedListNode<T> next; // Link (reference) to next node.
   
   // Constructor.
   public SortedLinkedListNode( T i )
   {
      this.item = i;
      this.next = null;
   }
         
}


