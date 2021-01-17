package in.shabhushan.algo_trials.dynamic_programming.matric_chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixCost {
  private int rows;
  private int cols;
  private long cost;

  private MatrixCost left;
  private MatrixCost right;

  public MatrixCost(int rows, int cols, long cost) {
    this.rows = rows;
    this.cols = cols;
    this.cost = cost;
  }

  public MatrixCost(int rows, int cols, long cost, MatrixCost left, MatrixCost right) {
    this.rows = rows;
    this.cols = cols;
    this.cost = cost;
    this.left = left;
    this.right = right;
  }

  private long cost(MatrixCost otherMatrix) {
    return this.rows * this.cols * otherMatrix.cols + this.cost + otherMatrix.cost;
  }

  private MatrixCost multiply(MatrixCost other) {
    return new MatrixCost(this.rows, other.cols, cost(other), this, other);
  }

  public static List<MatrixCost> makePairs(int[] arr) {
    List<MatrixCost> result = new ArrayList<>();

    for (int i = 1; i < arr.length; i++) {
      result.add(new MatrixCost(arr[i-1], arr[i], 0));
    }

    return result;
  }

  public static MatrixCost minimumCost(List<MatrixCost> matrices, int start, int end, Map<Map.Entry<Integer, Integer>, MatrixCost> map) {
    if (start == end) return matrices.get(start);
    else {
      Map.Entry<Integer, Integer> pair = Map.entry(start, end);

      if (!map.containsKey(pair)) {
        MatrixCost min = null;

        // put bracket between start and end at k
        for (int k = start; k < end; k++) {
          MatrixCost left = minimumCost(matrices, start, k, map);
          MatrixCost right = minimumCost(matrices, k + 1, end, map);

          MatrixCost result = left.multiply(right);

          if (min == null || result.cost < min.cost) {
            min = result;
          }
        }

        map.put(pair, min);
      }

      return map.get(pair);
    }
  }

  public static MatrixCost minimumCost(List<MatrixCost> matrices) {
    int n = matrices.size();

    MatrixCost[][] costs = new MatrixCost[n][n];

    for (int i = 0; i < n; i++) {
      // 0 cost along diagonal
      costs[i][i] = matrices.get(i);
    }

    for (int len = 1; len < n; len++) {
      for (int i = 0; i < n - len; i++) {
        int k = i + len;

        for (int j = i; j < k; j++) {
          MatrixCost cost = costs[i][j].multiply(costs[j + 1][k]);

          if (costs[i][k] == null || cost.getCost() < costs[i][k].getCost()) {
            costs[i][k] = cost;
          }

        }
      }
    }

    return costs[0][n - 1];
  }

  public long getCost() {
    return cost;
  }
}
