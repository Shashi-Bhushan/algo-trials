package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.dynamic_programming.MinSumpathinTriangle.minimumTotal;
import static org.junit.Assert.assertEquals;

public class MinSumpathinTriangleTest {
  @Test
  public void testMinsumPath() {
    assertEquals(11, minimumTotal(List.of(
        List.of(2),
        List.of(3, 4),
        List.of(6, 5, 7),
        List.of(4, 1, 8, 3)
    )));
  }
}
