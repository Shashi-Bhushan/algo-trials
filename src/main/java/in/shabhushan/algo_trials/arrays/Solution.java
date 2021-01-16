package in.shabhushan.algo_trials.arrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private int[][] A;

  private int row;
  private int col;

  private int zeroCount;

  public int solve(int[][] A) {
    this.A = A;
    this.row = A.length;
    this.col = A[0].length;

    int starti = 0;
    int startj = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (A[i][j] == 0) {
          zeroCount++;
        } else if (A[i][j] == 1) {
          starti = i;
          startj = j;
        }
      }
    }

    boolean[][] visited = new boolean[row][col];

    visited[starti][startj] = true;

    return helper(visited, starti, startj, 0);
  }

  private int helper(boolean[][] visited, int r, int c, int count) {
    if (A[r][c] == 2) {
      //System.out.println("count " + count + " zerocount " + zeroCount);
      return (count == 1 + zeroCount) ? 1 : 0;
    } else {
      int ans = 0;

      for (int[] d: DIR) {
        int x = r + d[0];
        int y = c + d[1];

        if (isWithinBounds(x, y) && visited[x][y] == false && A[x][y] != -1) {
          visited[x][y] = true;

          ans += helper(visited, x, y, count + 1);

          visited[x][y] = false;
        }
      }

      return ans;
    }
  }

  private boolean isWithinBounds(int r, int c) {
    return 0 <= r && r < row && 0 <= c && c < col;
  }

  private static int[][] DIR = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };
}
