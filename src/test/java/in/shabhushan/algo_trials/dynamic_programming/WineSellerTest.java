package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WineSellerTest {
  @Test
  public void testWineSeller() {
    assertEquals(64, WineSeller.getMaxProfit(new int[]{2, 4, 6, 2, 5}));
  }
}
