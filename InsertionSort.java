import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Seunghyeon (Hyeon) kim
 */


public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  /**
   * Sorting function using the insertion sort method. Generally has O(n log n) speed (similar to quicksort).
   * @param <T>
   * @param values
   * @param compare
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values == null){
      return;
    }
    for(int curInd = 1; curInd < values.length; curInd++){
      int prevInd = curInd - 1;
      int j = prevInd;
      while ((j >= 0) && (order.compare(values[j+1], values[j])<0)) {
        /* When next index of j is smaller than j, swap them until values[j] find their space */
        swap(values, j+1, j);
        j--;
      } // while
    } // for
  } // sort(T[], Comparator<? super T>

  /**
   * This function swaps the item in generic arr at index i and j.
   * @param <T>
   * @param arr
   * @param i
   * @param j
   */
  private <T> void swap(T[] arr, int i, int j){
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return;
  } // swap
} // class InsertionSort