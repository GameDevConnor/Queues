import java.util.*;

public class PQueueUnsortedArray<T extends Comparable<T>> extends AbstractQueue<T> {
	private int size;
	private T[] arr;
	
	
	// Default constructor
	public PQueueUnsortedArray() {
		size = 0; // initial size is 0
		arr = (T[]) new Comparable[11]; // default capacity of a PQ is 11
	}
	
	
	/* main methods section */
	
	/**
	 * Inserts the specified element into this queue if it is possible
	 * to do so immediately without violating capacity restrictions,
	 * When using a capacity-restricted queue, this method is generally preferable to
	 * add(E), which can fail to insert an element only by throwing an exception 
	 * 
	 * This implementation returns true if offer succeeds, else throws an IllegalStateException.
	 * 
	 * @param e - the element to add
	 * @return true if the element was added to this queue, else false
	 * @throws
	 * ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * NullPointerException - if the specified element is null and this queue does not permit null elements
	 * IllegalArgumentException - if some property of this element prevents it from being added to this queue
	 */
	
	public boolean offer(T e) {
		if(e == null) {
			throw new NullPointerException("element must not be null");
		}
		// array will automatically update size when there is only one slot left
		if(size == arr.length - 1) {
			arr = Arrays.copyOf(arr, arr.length*2);
		}
		arr[size] = e; // assign e to current index then increment index
		size++; // update size and return true
		return true;
	}
	
	
	/**
	 * Inserts the specified element into this queue if it is possible
	 * to do so immediately without violating capacity restrictions,
	 * returning true upon success and throwing an IllegalStateException 
	 * if no space is currently available.
	 * 
	 * This implementation returns true if offer succeeds, else throws an IllegalStateException.
	 * 
	 * @Overrides add in class AbstractCollection<\E>
	 * @param e - the element to add
	 * @return true
	 * @throws
	 * IllegalStateException - if the element can't be added due to capacity restrictions
	 * ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * NullPointerException - if the specified element is null and this queue does not permit null elements
	 * IllegalArgumentException - if some property of this element prevents it from being added to this queue
	 */
	
	@Override
	public boolean add(T e) {
		offer(e);
		return true;
	}
	
	
	/**
	 * Retrieves and removes the head of this queue
	 * or return null if queue is empty
	 * 
	 * @return head of queue, null if queue is empty
	 */
	public T poll() {
		// check if the queue is empty
		if(this.size == 0) {
			return null;
		}
		int min = 0;   // declare index of smallest value at 0
		// scan the array and update the index of the smallest value without sorting the array
		for(int i = 1; i < size; i++) {
			if(((Comparable<T>)arr[i]).compareTo(arr[min]) < 0) {
				min = i;
			}
		}
		// the head of a PQ is the item with smallest value based on comparator
		T head = arr[min];
		T[] updateArr = (T[]) new Comparable[arr.length - 1];
		System.arraycopy(arr, 0, updateArr, 0, min);
		System.arraycopy(arr, min + 1, updateArr, min, arr.length - min - 1);
		arr = updateArr;
		size--;
		return head;
	}
	
	/**
	 * Retrieves and removes the head of this queue. This method differs
	 * from poll only in that it throws an exception if this queue is empty
	 * 
	 * This implementation returns the result of poll unless the queue is empty
	 * 
	 * @return head of queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public T remove() {
		// check if the queue is empty
		if(this.size == 0) {
			throw new NoSuchElementException("the queue is empty");
		}
		int min = 0;   // declare index of smallest value at 0
		// scan the array and update the index of the smallest value without sorting the array
		for(int i = 1; i < size; i++) {
			if(((Comparable<T>)arr[i]).compareTo(arr[min])< 0) {
				min = i;
			}
		}
		// the head of a PQ is the item with smallest value based on comparator
		T head = arr[min];
		T[] updateArr = (T[]) new Comparable[arr.length - 1];
		System.arraycopy(arr, 0, updateArr, 0, min);
		System.arraycopy(arr, min + 1, updateArr, min, arr.length - min - 1);
		arr = updateArr;
		size--;
		return head;
	}
	
	/**
	 * Retrieves but does not remove the head of this queue
	 * or return null if queue is empty
	 * 
	 * @return head of queue, null if queue is empty
	 */
	public T peek() {
		// check if the queue is empty
		if(this.size == 0) {
			return null;
		}
		int min = 0;   // declare index of smallest value at 0
		// scan the array and update the index of the smallest value without sorting the array
		for(int i = 1; i < size; i++) {
			if(((Comparable<T>)arr[i]).compareTo(arr[min])< 0) {
				min = i;
			}
		}
		// the head of a PQ is the item with smallest value based on comparator
		T head = arr[min];
		return head;
	}
	
	/**
	 * Retrieves but does not remove the head of this queue
	 * This method differs from peek only in that it throws
	 * an exception if this queue is empty.
	 * 
	 * This implementation returns the result of peek unless the queue is empty.
	 * 
	 * @return head of queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public T element() {
		// check if the queue is empty
		if(this.size == 0) {
			throw new NoSuchElementException("the queue is empty");
		}
		int min = 0;   // declare index of smallest value at 0
		// scan the array and update the index of the smallest value without sorting the array
		for(int i = 1; i < size; i++) {
			if(((Comparable<T>)arr[i]).compareTo(arr[min])< 0) {
				min = i;
			}
		}
		// the head of a PQ is the item with smallest value based on comparator
		T head = arr[min];
		return head;
	}
	
	public int size() {
		if(size > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return this.size;
	}
	
	public String toString() {
		String result = "[";
		if(this.size == 0) {
			result += "]";
		}
		else {
			for(int i = 0; i < size-1; i++) {
				result += String.valueOf(arr[i]) + ", "; 
			}
			result += String.valueOf(arr[size-1]) + "]";
		}
		return result;
	}
	
	
	
	/* Unsupported methods section */
	
	public Iterator<T> iterator(){
		throw new UnsupportedOperationException();
	}
	

}