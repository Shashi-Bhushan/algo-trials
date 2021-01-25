package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.PairSum.pairSumArray;
import static in.shabhushan.algo_trials.arrays.PairSum.pairSumHash;
import static org.junit.Assert.assertEquals;

public class PairSumTest {
  @Test
  public void testPairSumHash() {
    assertEquals(3, pairSumHash(new int[]{1, 1, 1}, 2));
    assertEquals(3, pairSumHash(new int[]{5, 5, 5}, 10));
    assertEquals(4, pairSumHash(new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10}, 11));
  }

  @Test
  public void testPairSumArray() {
    assertEquals(3, pairSumArray(new int[]{1, 1, 1}, 2));
    assertEquals(4, pairSumArray(new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10}, 11));
  }

  @Test
  public void testPairDifferenceArray() {

    assertEquals(4, pairSumArray(new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10}, 11));
  }
}
