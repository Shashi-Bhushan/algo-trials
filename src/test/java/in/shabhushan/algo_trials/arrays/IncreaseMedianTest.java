package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.IncreaseMedian.increaseMedian;
import static org.junit.Assert.assertEquals;

public class IncreaseMedianTest {
  @Test
  public void testIncreaseMedian() {
    assertEquals(5, increaseMedian(new int[]{1, 1, 1, 5, 5}, 5));
    assertEquals(3, increaseMedian(new int[]{1, 1, 1, 2, 5}, 4));
    assertEquals(1, increaseMedian(new int[]{1, 1, 1, 1, 1}, 2));
    assertEquals(5, increaseMedian(new int[]{1, 1, 1, 1, 2, 3, 4}, 11));
  }
}
