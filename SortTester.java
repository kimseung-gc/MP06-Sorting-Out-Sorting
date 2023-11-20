import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Seunghyeon (Hyeon) Kim
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void doubleTest(){
    Double[] unsorted = new Double[] {0.5, 0.2, -0.4, 7.0, 2.2, -2.4};
    Double[] sorted = new Double[] {-2.4, -0.4, 0.2, 0.5, 2.2, 7.0};
    Comparator<Double> comp = (x, y)->x.compareTo(y);
    sorter.sort(unsorted, comp);
    assertArrayEquals(unsorted, sorted);
  } // doubleArrayTest

  @Test
  public void reversedOrderDoubleTest(){
    Double[] unsorted = new Double[] {0.5, 0.2, -0.4, 7.0, 2.2, -2.4};
    Double[] sorted = new Double[] {7.0, 2.2, 0.5, 0.2, -0.4, -2.4};
    Comparator<Double> comp = (x, y)->(-1)*x.compareTo(y);
    sorter.sort(unsorted, comp);
    assertArrayEquals(unsorted, sorted);
  } // doubleArrayTest

  @Test
  public void bigIntegerTest(){
    BigInteger[] original = new BigInteger[] {BigInteger.valueOf(1), BigInteger.valueOf(4), BigInteger.valueOf(-1), BigInteger.valueOf(2)};
    BigInteger[] expected = new BigInteger[] {BigInteger.valueOf(-1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(4)};
    Comparator<BigInteger> comp = (x, y) -> x.compareTo(y);
    sorter.sort(original, comp);
    assertArrayEquals(original, expected);
  } // bigIntegerTest

  @Test
  public void emptyArrayTest(){
    Object[] original = new Object[] {};
    Object[] expected = new Object[] {};
    sorter.sort(original, null);
    assertArrayEquals(original, expected);
  } // emptyArrayTest

  @Test
  public void nullPointerTest(){
    Object[] original = null;
    Object[] expected = null;
    sorter.sort(original, null);
    assertArrayEquals(original, expected);
  } // nullPointerTest

  @Test
  public void magnitudeOfIntTest(){
    Integer[] unsorted = new Integer[] {-11, 6, 7, -2, 10, -3, 1};
    Integer[] sorted = new Integer[] {1, -2, -3, 6, 7, 10, -11};
    Comparator<Integer> comp = (x, y)->x*x-y*y;
    sorter.sort(unsorted, comp);
    assertArrayEquals(unsorted, sorted);
  } // magnitudeOfIntTest

  @Test
  public void hugeArrayTest(){
    final int NUM = 40000000;
    Long[] sorted = new Long[NUM];
    for(Long i = Long.valueOf(0); i < NUM; i++){
      sorted[(int)i.longValue()] = 2*i;
    } // for
    Long[] unsorted = Arrays.copyOf(sorted, NUM);
    Random rand = new Random();
    for(Long i = Long.valueOf(0); i < NUM/2; i++){
      int j = rand.nextInt(NUM/2);
      Long temp = unsorted[j];
      unsorted[j] = unsorted[NUM- j-1];
      unsorted[NUM- j-1] = temp;
    } // for
    Comparator<Long> comp = (x, y) -> x.compareTo(y);
    sorter.sort(unsorted, comp);
    assertArrayEquals(unsorted, sorted);
  } // hugeArrayTest()
} // class SortTester
