import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSort and QuickSort
 * https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
 */

/**
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
   * @param <T>
   * @param values
   * @param compare
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values == null){
      return;
    }
    /* Call the helper function: merge. Call it such that it will sort the whole array. */
    merge(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

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
    // middle index is, by definition, (lo+hi)/2 rounded down
    int mid = (lo + hi)/2;
    // tempLen is the length of the sub array that the code is looking at
    int tempLen = hi-lo;
    // Base case
    if(tempLen == 0  || tempLen == 1){
      // When there is nothing more to call recursively, return vals
      return;
    }
    // Sort the first half of the vals recursively
    merge(vals, mid, hi, comparator);
    // Sort the latter half of the vals recursively
    merge(vals, lo, mid, comparator);
    // returning array, as it is a generic array, I used Arrays.copyOf() function
    T[] ret = Arrays.copyOfRange(vals, lo, hi);
    // right half of the array by index
    int r = (int)ret.length/2;
    // left half of the array by index
    int l = 0;
    // by iterating a for loop, sort the ret
    for(int i = lo; i < hi; i++){
      // When out of index, append the rest of the list at the end of ret
      vals[i] = (((r == hi-lo) && (l < mid-lo))?                    ret[l++] : 
                (((l == mid-lo) && (r < hi-lo))?                    ret[r++] :
      // By using the comparator, sort the vals (if ret[l] ≤ ret[r], vals[i] = ret[l])
                  (comparator.compare(ret[l], ret[r]) <= 0)?        ret[l++] : 
      // Else, vals[i] = ret[r]
                                                                    ret[r++]));
    } // for
    // return the sorted array
    return;
  } // merge
} // class MergeSort