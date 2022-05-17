
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PQueueHeap<E extends Comparable<E>> extends AbstractQueue<E> {

	int size; //Tracks the current size of the array
	E[] heap; //Array used to implement the heap

	
	//Default Constructor
	public PQueueHeap() {
		// TODO Auto-generated constructor stub
		size = 0; //Initial size is 0 elements
		heap = (E[]) new Comparable[11]; //Constructs an array of 15 elements
		//Casting of comparable array based on code found on https://stackoverflow.com/questions/34827626/cannot-be-cast-to-ljava-lang-comparable
	}
	
	/**
	 * Adds the element to the end of the heap
	 * 
	 * @param e - element to add
	 * 
	 * @return true
	 * 
	 * @throws
	 * NullPointerException - if the element you are trying to add is null
	 */
	@Override
	public boolean offer(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		if (heap == null) {
			heap[1] = e;
		}
		else if (e == null) {
			throw new NullPointerException("Element is null");
		}
		else {
			if ((size + 2) > heap.length) {
				heap = doubleArr(heap);
			}
			heap[size + 1] = e;
			
		}
		
		size++;

		climbUp(size);
		
		return true;
	}
	
	/**
	 * Adds the element to the end of the heap
	 * 
	 * @param e - element to add
	 * 
	 * @return true
	 * 
	 * @throws
	 * NullPointerException - if the element you are trying to add is null
	 */
	public boolean add(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		
		if (e == null) {
			throw new NullPointerException("Element is null");
		}
		
		else {
			
			if (heap == null) {
				heap[1] = e;
			}
			else {
				if ((size + 2) > heap.length) {
					heap = doubleArr(heap);
				}
				heap[size + 1] = e;
				
			}
			
			size++;

			climbUp(size);
			
			return true;
		}
	}

	/**
	 * Returns and removes the head of the heap
	 * 
	 * @return the first element of the heap, or null if the heap is empty
	 */
	@Override
	public E poll() {
		// TODO Auto-generated method stub
		E head = heap[1];
		if (heap == null) {
			return null;
		}
		else {
			heap[1] = heap[size];
			heap[size] = null;
			size--;
		
			climbDown(1);
		}
		
		return head;
	}
	
	/**
	 * Returns and removes the head of the heap
	 * 
	 * @return first element of the heap
	 * 
	 * @throws
	 * NoSuchElementException - if the heap is empty
	 */
	public E remove() throws NoSuchElementException {
		
		E head = heap[1];

		if (heap == null) {
			throw new NoSuchElementException("Heap is empty");
		}
		else {
		
			heap[1] = heap[size];
			heap[size] = null;
			size--;
		
			climbDown(1);
		}
		
		return head;
	}
	
	/**
	 * Returns the head of the heap
	 * 
	 * @return first element of the heap
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if (heap == null) {
			return null;
		}
		else {
			return heap[1];
		}
		
		
	}
	

	/**
	 * Returns the size of the heap
	 * 
	 * @return number of elements in the heap
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * Returns a string representation of the heap
	 * 
	 * @return the elements of the heap in an array format, surrounded by brackets and separated by commas
	 */
	public String toString() {
		String heapString = "";
		heapString += "[";
		
		for (int i = 0; i < size; i++) {
			heapString += heap[i] + ", ";
		}
		
		heapString += heap[size] + "]";
		
		System.out.print(heapString);
		
		return heapString;
		
	}
	
	
	/**
	 * Returns the head of the heap
	 * 
	 * @return first element of the heap
	 * 
	 * @throws
	 * NoSuchElementException - if the heap is empty
	 */
	public E element() throws NoSuchElementException {
		if (heap == null) {
			throw new NoSuchElementException("Heap is empty");
		}
		else {
			return heap[1];
		}
	}
	
	/**
	 * Returns the index of the left child of the element in the heap array
	 * 
	 * @param p - index of the parent element
	 * 
	 * @return index of the left child of the element at index p
	 * 
	 */
	protected int leftFromP(int p) {
		return 2 * p;
	}
	
	/**
	 * Returns the index of the right child of the element in the heap array
	 * 
	 * @param p - index of the parent element
	 * 
	 * @return index of the right child of the element at index p
	 * 
	 */
	protected int rightFromP(int p) {
		return 2 * p + 1;
	}
	
	/**
	 * Returns the index of the parent of the element in the heap array
	 * 
	 * @param p - index of the child element
	 * 
	 * @return index of the parent of the element at index p
	 * 
	 */
	protected int parentOfP(int p) {
		return p / 2;
	}
	
	/**
	 * Swaps the content of two elements in the heap array
	 * 
	 * @param p - index of the first element
	 * @param q - index of the second element
	 * 
	 */
	protected void swap(int p, int q) {
		E temp = heap[p];
		heap[p] = heap[q];
		heap[q] = temp; 
	}
	
	/**
	 * Shows whether or not an element in the heap has a left child
	 * 
	 * @param j - index of the parent element
	 * 
	 * @return true if 2 times the index of the parent is contained within the array, false otherwise
	 * 
	 */
	protected boolean hasLeft(int j) {
		return leftFromP(j) <= size;
	}
	
	/**
	 * Shows whether or not an element in the heap has a right child
	 * 
	 * @param j - index of the parent element
	 * 
	 * @return true if 2 times the index of the parent + 1 is contained within the array, false otherwise
	 * 
	 */
	protected boolean hasRight(int j) {
		return rightFromP(j) <= size;
	}
	
	/**
	 * Creates a new array double the size of the original with all of its elements
	 * 
	 * @param arr - the original array
	 * 
	 * @return an array that is twice the size of the original with the original elements in the same order
	 * 
	 */
	protected E[] doubleArr(E[] arr) {
		E[] temp = Arrays.copyOf(arr, arr.length * 2);
		return temp;
	}
	
	
	/**
	 * Continually swaps an element with its parent
	 * 
	 * @param j - number of times to swap upwards
	 * 
	 * Algorithm from Data Structures & Algorithms on page 377
	 */
	protected void climbUp(int j) {
		
		while (j > 1) {
			int p = parentOfP(j);

			if (heap[j].compareTo(heap[p]) >= 0) {
				break;
			}
			swap(j, p);
			j = p;
		}
	}
	
	/**
	 * Continually swaps an element with the child of least priority
	 * 
	 * @param j - number of times to swap downwards
	 * 
	 * Algorithm from Data Structures & Algorithms on page 378
	 */
	protected void climbDown(int j) {
		
		while (hasLeft(j)) {
			int left = leftFromP(j);
			
			int smallest = left;

			if (hasRight(j)) {
				int right = rightFromP(j);
				if (heap[left].compareTo(heap[right]) > 0) {
					smallest = right;
				}
			}
			
			if (heap[smallest].compareTo(heap[j]) >= 0) {
				break;
			}
			
			swap(j, smallest);
			j = smallest;
		}
	}
	
	/**
	 * Compares two elements of any reference type that implements Comparable
	 * 
	 * @param o - the object this instance is to be compared to
	 * 
	 * @return 0 if the objects are equal, Negative if this object is less than o, Positive if this object is greater than o
	 * 
	 */
	protected int compareTo(E o) {
		// TODO Auto-generated method stub
		return this.compareTo(o);
	}

	
	public static void main(String[] args) {

		PQueueHeap<Integer> heapInt = new PQueueHeap<Integer>();
		
		heapInt.offer(1);
		heapInt.offer(2);
		heapInt.offer(3);
		heapInt.offer(3);
		heapInt.offer(2);
		heapInt.offer(3);
		heapInt.offer(3);
		heapInt.offer(10);
		
		heapInt.add(1);
		heapInt.toString();
		heapInt.remove();
		heapInt.toString();
		heapInt.offer(3);
		heapInt.toString();
		heapInt.remove();
		heapInt.toString();
		
	
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
