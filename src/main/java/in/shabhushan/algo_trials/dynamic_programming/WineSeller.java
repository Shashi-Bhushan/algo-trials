package in.shabhushan.algo_trials.dynamic_programming;

public class WineSeller {
  public static int getMaxProfit(int[] arr) {
    int n = arr.length;

    // dp[i][j] = max profit from arr[i][j] where i is start and j is end
    int[][] dp = new int[n + 1][n + 1];

    //return helper(arr, 0, n - 1, dp);

    for (int i = 1; i <= n; i++) {
      // this will be sold in Nth year
      dp[i][i] = n * arr[i - 1];
    }

    // for each column
    for (int i = 2; i <= n; i++) {

      // this can be calculated since start will be from row 1 always here
      int diff = i - 1;
      int year = n - diff;

      for (int start = 1, end = i; end <= n; start++, end++) {
        dp[start][end] = Math.max(
            arr[start - 1] * year + dp[start + 1][end],
            arr[end - 1] * year + dp[start][end - 1]
        );
      }
    }

    return dp[1][n];
  }

  private static int helper(int[] arr, int start, int end, int[][] dp) {
    int diff = end - start;
    int year = arr.length - diff;

    if (dp[start][end] != 0) {
      return dp[start][end];
    } else if (start == end) {
      dp[start][end] = arr[start] * year;
    } else {
      dp[start][end] = Math.max(
          arr[start] * year + helper(arr, start + 1, end, dp),
          helper(arr, start, end - 1, dp) + arr[end]  * year
      );
    }

    return dp[start][end];
  }
}
