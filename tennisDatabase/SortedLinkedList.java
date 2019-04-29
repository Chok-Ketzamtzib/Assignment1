


// Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package tennisDatabase;

// SortedLinkedList generic class, implemeting a sorted linked list (to store the matches of a player).
// Note: "T extends Comparable" is an upper bounded type parameter ("T" is any class derived/implementing Comparable).
// Note: "? super T" is a lower bounded wildcards ("?" is any superclass of "T").
class SortedLinkedList< T extends Comparable< ? super T > > implements SortedLinkedListInterface<T> {

   private SortedLinkedListNode<T> head; // Entry point: reference to 1st node, or null if list is empty.
   private int numItems; // Number of items-nodes in the list.

   // Constructor.
   public SortedLinkedList() {
      this.head = null;
      this.numItems = 0;
   }

   // Desc.: Insert an object of type T this container.
   // Input: An object (reference) of type T.
   // Output: Throws a checked (critical) exception if the insertion is not successful.
   public void insert( T m ) throws Exception {
      // Setup 2 references to right-before and right-after the insertion point.
      SortedLinkedListNode<T> currNode = this.head;
      SortedLinkedListNode<T> prevNode = null;
      // Find point of insertion.
      while( ( currNode != null ) && ( m.compareTo( currNode.item ) < 0 ) ) {
         prevNode = currNode;
         currNode = currNode.next;
      }
      // Wrap input data into a new node.
      SortedLinkedListNode<T> newNode = new SortedLinkedListNode<T>( m );
      // Check if insertion is at front, or if list is empty
      if( prevNode == null ) {
         this.head = newNode;
         newNode.next = currNode;
         this.numItems++;
      }
      // Insertion at middle, or at end.
      else {
         newNode.next = currNode;
         prevNode.next = newNode;
         this.numItems++;
      }
   }
   
   // Desc.: Returns all matches in the list arranged in the output array (sorted by date, most recent first).
   // Output: Throws an unchecked (non-critical) exception if there are no items in this container.
   public T[] getAll() throws RuntimeException {
      if( this.numItems == 0 ) { throw new RuntimeException( "Error getting list items: no items in list!" ); }
      else {
         // To avoid: "Note: TennisDatabase\SortedLinkedList.java uses unchecked or unsafe operations."
         //           "Note: Recompile with -Xlint:unchecked for details."
         // Use the annotation "@SuppressWarnings("unchecked")" to suppress the compile warnings (above) about unchecked generic operations.
         @SuppressWarnings("unchecked")
         T[] resArray = (T[]) new Object[ this.numItems ];
         // Transfer all list item in result array.
         int i = 0;
         SortedLinkedListNode<T> currNode = this.head;
         while( currNode != null ) {
            resArray[i] = currNode.item;
            i++;
            currNode = currNode.next;
         }
         // Returning result array.
         return resArray;
      }
   }
   
   // Desc.: Returns the match at position i (array-like index) in the list.
   // Output: Throws an unchecked (non-critical) exception if the index is invalid.
   public T get( int i ) throws RuntimeException {
      // Check if input index is valid.
      if( ( i < 0 ) || ( i >= this.numItems ) ) { throw new RuntimeException( "Error getting list item: index invalid!" ); }
      else {
         // Retrieving the list item ad inded "i".
         SortedLinkedListNode<T> currNode = this.head;
         int indexCurrNode = 0;
         while( indexCurrNode < i ) {
            indexCurrNode++;
            currNode = currNode.next;
         }
         // Return node at "i" content.
         return currNode.item;
      }   
   }
      
}


