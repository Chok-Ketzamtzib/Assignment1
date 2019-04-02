
// Giuseppe Turini
// CS-102, Spring 2019
// Assignment 1

package TennisDatabase;

import java.lang.Comparable;
import java.lang.Exception;
import java.lang.RuntimeException;

// Interface (package-private) providing the specifications for the SortedLinkedList generic class.
interface SortedLinkedListInterface<T extends Comparable<? super T>> {

	// Desc.: Insert an object of type T this container.
	// Input: An object (reference) of type T.
	// Output: Throws a checked (critical) exception if the insertion is not
	// successful.
	public void insert(T m) throws Exception;

	// Desc.: Returns copies (deep copies) of all matches in the list arranged in
	// the output array (sorted by date, most recent first).
	// Output: Throws an unchecked (non-critical) exception if there are no items in
	// this container.
	public T[] getAll() throws RuntimeException;

	// Desc.: Returns the match at position i (array-like index) in the list.
	// Output: Throws an unchecked (non-critical) exception if the index is invalid.
	public T get(int i) throws RuntimeException;

}
