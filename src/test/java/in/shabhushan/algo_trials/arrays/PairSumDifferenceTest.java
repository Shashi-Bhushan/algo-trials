package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.PairSumDifference.pairSumDifference;
import static org.junit.Assert.assertEquals;

public class PairSumDifferenceTest {
  @Test
  public void testPairSumDifference() {
//    assertEquals(0, pairSumDifference(new int[]{1, 2}, 0));
//    assertEquals(2, pairSumDifference(new int[]{1, 5, 3, 4, 2}, 3));
//    assertEquals(5, pairSumDifference(new int[]{8, 12, 16, 4, 0, 20}, 4));
    assertEquals(2, pairSumDifference(new int[]{1, 1, 1, 2, 2}, 0));
    assertEquals(7, pairSumDifference(new int[]{8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3 }, 3));
  }
}
