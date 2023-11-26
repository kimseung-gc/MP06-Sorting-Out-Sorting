package Utils;

public class MP6Util {
  /**
   * This function swaps the item in generic arr at index i and j.
   * @param <T>
   * @param arr
   * @param i
   * @param j
   */
  public static <T> void swap(T[] arr, int i, int j){
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return;
  } // swap

  /**
   * Reverses the array.
   * @param <T>
   * @param arr
   */
  public static <T> void reverse(T[] arr){
    int lastInd = arr.length - 1;
    for(int i = 0; i < arr.length/2; i++){
      MP6Util.swap(arr, i, lastInd - i);
    } // for
  } // reverse(T[])

  /**
   * utility function to copy arr1 to arr2 in the limited indices (start to end-1).
   * @param <T>
   * @param arr1
   * @param arr2
   * @param start
   * @param end
   */
  public static <T> void copyToRange(T[] arr1, T[] arr2, int start, int end) {
    for (int i = start; i < end; i++) {
      arr2[i] = arr1[i];
    } // for
  } // copyToRange(T[], T[], int, int)
} // class MP6Util
