import java.util.Arrays;
import java.util.Queue;


public class Sort {

	public static <E extends Comparable<? super E>> void PQSort(Queue<E> pq, E[] a) {
		for (int i = 0; i < a.length; i++) {
			pq.offer(a[i]);
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] = pq.remove();
		}
	}
	
	
	public static void main(String[] args) {

		PQueueHeap<Integer> heapInt = new PQueueHeap<Integer>();
		
		Integer[] arrayInt = {1, 2, 3, 3, 2, 3, 3, 10};
//		
//		Sort sort = new Sort();
//		
		System.out.print("Original: " + Arrays.toString(arrayInt));
//		
//		sort.PQSort(heapInt, arrayInt);
//		System.out.print("\n");
//		System.out.print("Sorted: " + Arrays.toString(arrayInt));		
//		
//		System.out.print("\n\n");
//		
//		PQueueSortedArray<String> heapString = new PQueueSortedArray<String>();
//		
//		String[] arrayString = {"G", "F", "H", "B", "D", "E", "C", "A"};
//		
//		System.out.print("Original: " + Arrays.toString(arrayString));
//		
//		sort.PQSort(heapString, arrayString);
//		System.out.print("\n");
//		System.out.print("Sorted: " + Arrays.toString(arrayString));
//		
//		System.out.print("\n\n");
//		
//		PQueueUnsortedArray<String> heapString2 = new PQueueUnsortedArray<String>();
//		
//		String[] arrayString2 = {"G", "F", "H", "B", "D", "E", "C", "A"};
//		
//		System.out.print("Original: " + Arrays.toString(arrayString2));
//		
//		sort.PQSort(heapString, arrayString2);
//		System.out.print("\n");
//		System.out.print("Sorted: " + Arrays.toString(arrayString2));
		
		
		
	}
}
