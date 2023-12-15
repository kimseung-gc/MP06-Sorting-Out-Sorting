import java.util.Comparator;
import Utils.MP6Util;

/**
 * MergeSort and QuickSort
 * https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
 * 
 * @author Seunghyeon (Hyeon) Kim
 */

public class KimHyeonSort implements Sorter {
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
   * 
   * @param <T>
   * @param values
   * @param order
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    Sorter sorter;
    if (values == null) {
      return;
    } // if
    runStat(values, order);
    if (this.ordered) {
      return;
    } // if
    if (this.reversed) {
      MP6Util.reverse(values);
      return;
    } // if
    if (this.insertionSteps < this.mergeSteps) {
      sorter = new InsertionSort();
      sorter.sort(values, order);
      return;
    } // if
    sorter = new MergeSort();
    sorter.sort(values, order);
  } // sort(T[], Comparator<? super T>)

  /**
   * It runs the statistics for the given array and comparator.
   * 
   * @param <T>
   * @param values
   * @param order
   */
  private <T> void runStat(T[] values, Comparator<? super T> order) {
    this.ordered = true;
    this.reversed = true;
    for (int i = 1; i < values.length; i++) {
      if (order.compare(values[i - 1], values[i]) > 0) {
        this.ordered = false;
        this.insertionSteps += i;
      } // if
      if (order.compare(values[i - 1], values[i]) < 0) {
        this.reversed = false;
      } // if
    } // for
    this.mergeSteps = 2 * values.length * (int) (Math.log(values.length) / Math.log(2));
  } // runStat(T[] Comparator<? super T>)
} // class KimHyeonSort
