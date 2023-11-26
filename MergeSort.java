import java.util.Comparator;
import Utils.MP6Util;

/**
 * MergeSort and QuickSort
 * https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
 * Sort using merge sort.
 *
 * @author Seunghyeon (Hyeon) kim
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  /**
   * Sorting function using the mergesort method. Generally has O(n log n) speed.
   * 
   * @param <T>
   * @param values
   * @param compare
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null) {
      return;
    } // if
    /**
     * Call the helper function: merge. Call it such that it will sort the whole
     * array.
     */
    sort(values, values.clone(), 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  /**
   * It sorts the vals from lo to hi with a given comparator. A clone of vals has
   * to be given as temp in order for an helper array reference for merge sorting
   * the vals.
   * @param <T>
   * @param vals
   * @param temp
   * @param lo
   * @param hi
   * @param order
   * @Warning This method is made private as the temp has specific requirements
   */
  private <T> void sort(T[] vals, T[] temp, int lo, int hi, Comparator<? super T> order) {
    if (vals.length == 1 || vals.length == 0) {
      return;
    } // if
    // middle index is, by definition, (lo+hi)/2 rounded down
    int mid = (lo + hi) / 2;
    // tempLen is the length of the sub array that the code is looking at
    int tempLen = hi - lo;
    // Base case
    if (tempLen < 2) {
      // When there is nothing more to call recursively, return vals
      return;
    } else {
      // Sort the first half of the vals recursively
      sort(vals, temp, mid, hi, order);
      // Sort the latter half of the vals recursively
      sort(vals, temp, lo, mid, order);
    } // if/else
    // Merge the sorted halves
    merge(vals, temp, lo, mid, hi, order);
  } // sort(T[], T[], int, int, Comparator<? super T>)

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array. This is a helper function for the sort 
   * function.
   * @pre vals must be the unsorted list, and a valid comparator for
   *      generic type <T>. The lo and hi are the lower index and higher
   *      index which the function sorts [lo, hi) region.
   * @post Each subarray is sorted accorting to comparator.
   */
  private <T> void merge(T[] vals, T[] helperArr, int lo, int mid, int hi, Comparator<? super T> comparator) {
    // right half of the array by index
    int r = mid;
    // left half of the array by index
    int l = lo;
    // by iterating a for loop, merge the arrays
    for (int i = lo; i < hi; i++) {
      // When out of index, append the rest of the list at the end of helperArr
      vals[i] = (((r == hi) && (l < mid)) ? helperArr[l++] : (((l == mid) && (r < hi)) ? helperArr[r++] :
      // By using the comparator, sort the vals (if helperArr[l] ≤ helperArr[r],
      // vals[i] = helperArr[l])
          (comparator.compare(helperArr[l], helperArr[r]) <= 0) ? helperArr[l++] :
          // Else, vals[i] = helperArr[r]
          helperArr[r++]));
    } // for
    if(hi-lo != vals.length){
      // copy and paste the partially sorted array
      MP6Util.copyToRange(vals, helperArr, lo, hi);
    } // if
    return;
  } // merge (T[], T[], int, int, int, Comparator<? super T>)
} // class MergeSort