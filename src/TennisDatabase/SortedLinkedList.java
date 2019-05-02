


// Steven Causley
// Original by Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

import java.lang.reflect.Array;

// SortedLinkedList generic class, implemeting a sorted linked list (to store the matches of a player).
// Note: "T extends Comparable" is an upper bounded type parameter ("T" is any class derived/implementing Comparable).
// Note: "? super T" is a lower bounded wildcards ("?" is any superclass of "T").
class SortedLinkedList<T extends Comparable<? super T>>
{

    private SortedLinkedListNode<T> head; // Entry point: reference to 1st node, or null if list is empty.
    private int numItems; // Number of items-nodes in the list.

    // Constructor.
    public SortedLinkedList()
    {
        this.head = null;
        this.numItems = 0;
    }

    // Getter for the number of items in this list.
    public int size()
    {
        return this.numItems;
    }

    // Desc.: Insert an object of type T this container.
    // Input: An object (reference) of type T.
    // Output: Throws a checked (critical) exception if the insertion is not successful.
    public void insert(T m) throws Exception
    {
        // Setup 2 references to right-before and right-after the insertion point.
        SortedLinkedListNode<T> currNode = this.head;
        SortedLinkedListNode<T> prevNode = null;
        // Find point of insertion.
        while ((currNode != null) && (m.compareTo(currNode.item) < 0))
        {
            prevNode = currNode;
            currNode = currNode.next;
        }
        // Wrap input data into a new node.
        SortedLinkedListNode<T> newNode = new SortedLinkedListNode<T>(m);
        // Check if insertion is at front, or if list is empty
        if (prevNode == null)
        {
            this.head = newNode;
            newNode.next = currNode;
            this.numItems++;
        }
        // Insertion at middle, or at end.
        else
        {
            newNode.next = currNode;
            prevNode.next = newNode;
            this.numItems++;
        }
    }

    // Desc.: Returns the match at position i (array-like index) in the list.
    // Output: Throws an unchecked (non-critical) RuntimeException exception if the index is invalid.
    public T get(int i) throws RuntimeException
    {
        // Check if input index is valid.
        if ((i < 0) || (i >= this.numItems))
        {
            throw new RuntimeException("Error getting list item: index invalid!");
        } else
        {
            // Retrieving the list item ad inded "i".
            SortedLinkedListNode<T> currNode = this.head;
            int indexCurrNode = 0;
            while (indexCurrNode < i)
            {
                indexCurrNode++;
                currNode = currNode.next;
            }
            // Return node at "i" content.
            return currNode.item;
        }
    }

}


