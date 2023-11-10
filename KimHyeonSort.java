import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSort and QuickSort
 * https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
 */

public class KimHyeonSort implements Sorter{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new KimHyeonSort();
  private int insertionSteps;
  private int mergeSteps;
  private boolean reversed;
  private boolean ordered;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  KimHyeonSort() {
  } // KimHyeonSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  /**
   * Sorting function using my own sorting method. Generally has O(n log n) speed.
   * @param <T>
   * @param values
   * @param order
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values == null){
      return;
    } // if
    runStat(values, order);
    if(this.ordered){
      return;
    } // if
    if(this.reversed){
      reverse(values);
      return;
    } // if
    if(this.insertionSteps < this.mergeSteps){
      insertionSort(values, order);
      return;
    } // if
    mergeSort(values, order);
  } // sort(T[], Comparator<? super T>)

  /**
   * It runs the statistice for the given array and comparator.
   * @param <T>
   * @param values
   * @param order
   */
  private <T> void runStat(T[] values, Comparator<? super T> order){
    this.ordered = true;
    this.reversed = true;
    for(int i = 1; i < values.length; i++){
      if(order.compare(values[i-1], values[i]) > 0){
        this.ordered = false;
        this.insertionSteps += i;
      } // if
      if(order.compare(values[i-1], values[i]) < 0){
        this.reversed = false;
      } // if
    } // for
    this.mergeSteps = 2 * values.length * (int)(Math.log(values.length)/ Math.log(2));
  } // runStat(T[] Comparator<? super T>)

  /**
   * Reverses the array.
   * @param <T>
   * @param arr
   */
  private <T> void reverse(T[] arr){
    int lastInd = arr.length - 1;
    for(int i = 0; i < arr.length/2; i++){
      swap(arr, i, lastInd - i);
    } // for
  } // reverse(T[])

  /**
   * Sorting function using the merge sort method. Generally has O(n log n) speed.
   * @param <T>
   * @param values
   * @param compare
   */
  public <T> void mergeSort(T[] values, Comparator<? super T> order) {
    if(values == null){
      return;
    } // if
    /* Call the helper function: merge. Call it such that it will sort the whole array. */
    merge(values, 0, values.length, order);
  } // mergeSort(T[], Comparator<? super T>

  /**
   * Sorting function using the insertion sort method. Generally has O(n log n) speed (similar to quicksort).
   * @param <T>
   * @param values
   * @param compare
   */
  public <T> void insertionSort(T[] values, Comparator<? super T> order) {
    if(values == null){
      return;
    } // if
    for(int curInd = 1; curInd < values.length; curInd++){
      int prevInd = curInd - 1;
      int j = prevInd;
      while ((j >= 0) && (order.compare(values[j+1], values[j])<0)) {
        /* When next index of j is smaller than j, swap them until values[j] find their space */
        swap(values, j+1, j);
        j--;
      } // while
    } // for
  } // insertionSort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array. This is the recursive helper function 
   * for the sort function.
   *
   * @pre vals must be the unsorted list, and a valid comparator for
   * generic type <T>. The lo and hi are the lower index and higher
   * index which the function sorts [lo, hi) region.
   * @post Each subarray is sorted accorting to comparator.
   */
  private <T> void merge(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    if(vals == null){
      return;
    }
    /* middle index is, by definition, (lo+hi)/2 rounded down */
    int mid = (lo + hi)/2;
    /* tempLen is the length of the sub array that the code is looking at */
    int tempLen = hi-lo;
    /* Base case */
    if(tempLen == 0  || tempLen == 1){
      /* When there is nothing more to call recursively, return vals */
      return;
    }
    /* Sort the first half of the vals recursively */
    merge(vals, mid, hi, comparator);
    /* Sort the latter half of the vals recursively */
    merge(vals, lo, mid, comparator);
    /* returning array, as it is a generic array, I used Arrays.copyOf() function */
    T[] ret = Arrays.copyOfRange(vals, lo, hi);
    /* right half of the array by index */
    int r = (int)ret.length/2;
    /* left half of the array by index */
    int l = 0;
    /* by iterating a for loop, sort the ret */
    for(int i = lo; i < hi; i++){
      /* When out of index, append the rest of the list at the end of ret */
      vals[i] = (((r == hi-lo) && (l < mid-lo))?                    ret[l++] : 
                (((l == mid-lo) && (r < hi-lo))?                    ret[r++] :
      /* By using the comparator, sort the vals (if ret[l] ≤ ret[r], vals[i] = ret[l]) */
                   (comparator.compare(ret[l], ret[r]) <= 0)? ret[l++] : 
      /* Else, vals[i] = ret[r] */
                                                              ret[r++]));
    } // for
    /* return the sorted array */
    return;
  } // merge

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
} // class KimHyeonSort
