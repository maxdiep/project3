import java.util.*;

/**
 * A data structure that implements a maximum heap. The heap's internal storage
 * should be based on a standard Java array.
 */
interface Heap<T extends Comparable<? super T>> {
	/**
	 * Adds the specified item to the heap.
	 * This operation must run in logarithmic time <em>O</em>O(log <em>n</em>), where <em>n</em>
	 * is the number of items currently stored in the heap.
	 * @param item the item to add
	 */
	void add (T item);

	/**
	 * Removes and returns the currently "largest" item from the heap (which is always at the top).
	 * This operation must run in constant time.
	 * @return the top of the heap
	 */
	T removeFirst ();

	/**
	 * Returns the number of items currently stored in the heap.
	 * This operation must run in constant time.
	 * @return the number of items currently stored in the heap.
	 */
	int size ();
}
