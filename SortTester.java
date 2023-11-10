import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigInteger;
import java.util.Comparator;

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
} // class SortTester
