package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  @Test
  public void test() {
//    assertEquals(2, new Solution().solve(new int[][]{
//        {1, 0, 0, 0},
//        {0, 0, 0, 0},
//        {0, 0, 2, -1},
//    }));

//    assertEquals(0, new Solution().solve(new int[][]{
//        {0, 1},
//        {2, 0},
//    }));

    assertEquals(1, new Solution().solve(new int[][]{
        {2, -1},
        {0, 0},
        {-1, 1},
    }));
  }
}
