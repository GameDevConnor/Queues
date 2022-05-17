import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class PQTest {

	@Test
	public void test() {

		PQueueHeap<Integer> pq = new PQueueHeap<>();
		Integer[] array = new Integer[1000];


		Random rd = new Random();
		for(int i = 0; i < 1000; i++) {
		     array[i] = rd.nextInt(100);
		}


		Sort.PQSort(pq,array);
		assertTrue("PQSort does not sort correctly ", isSorted(array));
		}

		private static boolean isSorted(Integer [] array){
		        if (array.length <= 1) return true;
		        for (int i = 1; i < array.length; i++){
		            if (array[i] < array [i-1]) {
		                return false;
		            }
		        }
		        return true;
		    }
		
		
		  @Test
		  public void SortTest() {

			  Queue<Integer> OurPQHeap = new PQueueHeap<Integer>();
		      Queue<Integer> OurPQUnsorted = new PQueueUnsortedArray<Integer>();
		      Queue<Integer> OurPQSorted = new PQueueSortedArray<Integer>();
		        
		      Random rnd = new Random();
		        
		      Integer[] a1 = new Integer[500];
		      Integer[] a2 = new Integer[500];
		      Integer[] a3 = new Integer[500];

		      for (int i = 0; i < 500; i++){
		            
		    	  int j = (i  * rnd.nextInt(9));
		          int k = (i  * rnd.nextInt(3));
		          int l = (i  * rnd.nextInt(5));
		          a1[i] = j;
		          a2[i] = k;
		          a3[i] = l;
		            
		      }

		      long startTime = System.nanoTime();
		      Sort.PQSort(OurPQHeap, a1);
		      long endTime = System.nanoTime();
		      long HeapTime = endTime - startTime;
		        
		      startTime = System.nanoTime();
		      Sort.PQSort(OurPQUnsorted, a2);
		      endTime = System.nanoTime();
		      long UnsortedTime = endTime - startTime;
		        
		      startTime = System.nanoTime();
		      Sort.PQSort(OurPQSorted, a3);
		      endTime = System.nanoTime();
		      long SortedTime = endTime - startTime;
		        
		        
		      System.out.println("Time taken by each PQ implementation in PQSort\nHeap Time: " + HeapTime/1e6 + " ns" + "\nUnsortedTime: " + UnsortedTime/1e6 + " ns"
		              + "\nSortedTime : " + SortedTime/1e6 + " ns");
		        
		      assertTrue("Non-constant PQSort performance for Heap vs Sorted and Unsorted Array implementation" , 
		                HeapTime < UnsortedTime
		                && HeapTime < SortedTime);
		      }
		  
		  
		  
		  @Test
		    public void SortTest2() {

		        Queue <Integer> queue = new PQueueHeap<Integer>();
		        
		        Integer[] a1 = new Integer[100000];
		        Integer[] a2 = new Integer[100000];
		        Random rnd = new Random();
		        
		        for (int i = 0; i < 100000; i++){
		           a1[i] =  rnd.nextInt(100);
		        }
		        for (int i = 0; i < 100000; i++){
		            a2[i] = rnd.nextInt(100);
		        }
		        long startTime = System.nanoTime();
		        Sort.PQSort(queue, a1);
		        long endTime = System.nanoTime();
		        long HeapTime = endTime - startTime;
		        
		        startTime = System.nanoTime();
		        Arrays.sort(a2);
		        endTime = System.nanoTime();
		        long ArraySortTime = endTime - startTime;
		        
		        
		        System.out.println("Array.sort vs Heap Time\nHeap Time: " + HeapTime/1e6 + "\nArrays.Sort Time: " + ArraySortTime/1e6);
		    
		    
		        assertTrue("Heap is slower than Arrays.Sort" , 
		                HeapTime < ArraySortTime);
		    }
		  
}
