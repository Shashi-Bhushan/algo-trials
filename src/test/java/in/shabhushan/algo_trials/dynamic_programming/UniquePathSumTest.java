package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.UniquePathSum.uniquePathsWithObstacles;

public class UniquePathSumTest {
  @Test
  public void testUniquePathSum() {
    int res = uniquePathsWithObstacles(new int[][]{
        new int[]{0, 0, 1, 0, 1, 1, 1, 1},
        new int[]{0, 1, 0, 1, 0, 0, 1, 1},
        new int[]{0, 0, 1, 0, 0, 0, 0, 1},
    });

    System.out.println(res);
  }
}
