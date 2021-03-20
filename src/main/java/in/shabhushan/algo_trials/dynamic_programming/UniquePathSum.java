package in.shabhushan.algo_trials.dynamic_programming;

public class UniquePathSum {
  public static int uniquePathsWithObstacles(int[][] A) {
    int[] dp = new int[A[0].length];

    for (int i = 0; i < A[0].length; i++) {
      if (A[0][i] == 0) dp[i] = 1;
      else break;
    }

    for (int i = 1; i < A.length; i++) {
      if (A[i][0] == 1) {
        dp[0] = 0;
      }

      for (int j = 1; j < A[i].length; j++) {
        if (A[i][j] == 1) dp[j] = 0;
        else dp[j] += dp[j - 1];
      }
    }

    return dp[A[0].length - 1];
  }
}
