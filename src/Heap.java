
/**
 * @author Birhat Zorlu
 *
 */

@SuppressWarnings({ "unchecked", "hiding" })
public class Heap<String extends Comparable<String>> {
	

	private int size;            // Number of elements in heap
	private String[] heap;     // The heap array

	   
	public Heap(int capacity)
	   {
	      size = 0;
	      heap = (String[]) new Comparable[capacity];
	   }

	 /**
	  * Construct the binary heap given an array of items.
	  */
	   public Heap(String[] array)
	   {
	      size = array.length;
	      heap = (String[]) new Comparable[array.length+1];

	      System.arraycopy(array, 0, heap, 1, array.length);//we do not use 0 index

	      buildHeap();
	   }
	 /**
	  *   runs at O(size)
	  */
	   private void buildHeap()
	   {
	      for (int k = size/2; k > 0; k--)
	      {
	         percolatingDown(k);
	      }
	   }
	   private void percolatingDown(int k)
	   {
	      String tmp = heap[k];
	      int child;

	      for(; 2*k <= size; k = child)
	      {
	         child = 2*k;

	         if(child != size &&
	            heap[child].compareTo(heap[child + 1]) > 0) child++;

	         if(tmp.compareTo(heap[child]) > 0)  heap[k] = heap[child];
	         else
	                break;
	      }
	      heap[k] = tmp;
	   }

	 /**
	  *  Sorts a given array of items.
	  */
	   public void heapSort(String[] array)
	   {
	      size = array.length;
	      heap = (String[]) new Comparable[size+1];
	      System.arraycopy(array, 0, heap, 1, size);
	      buildHeap();

	      for (int i = size; i > 0; i--)
	      {
	         String tmp = heap[i]; //move top item to the end of the heap array
	         heap[i] = heap[1];
	         heap[1] = tmp;
	         size--;
	         percolatingDown(1);
	      }
	      for(int k = 0; k < heap.length-1; k++)
	         array[k] = heap[heap.length - 1 - k];
	   }

	 /**
	  * Deletes the top item
	  */
	   public String deleteMin() throws RuntimeException
	   {
	      if (size == 0) throw new RuntimeException();
	      String min = heap[1];
	      heap[1] = heap[size--];
	      percolatingDown(1);
	      return min;
		}

	 /**
	  * Inserts a new item
	  */
	   public void insert(String x)
	   {
	      if(size == heap.length - 1) doubleSize();

	      //Insert a new item to the end of the array
	      int pos = ++size;

	      //Percolate up
	      for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
	         heap[pos] = heap[pos/2];

	      heap[pos] = x;
	   }
	   private void doubleSize()
	   {
	      String [] old = heap;
	      heap = (String []) new Comparable[heap.length * 2];
	      System.arraycopy(old, 1, heap, 1, size);
	   }
}
