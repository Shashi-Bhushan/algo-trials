package in.shabhushan.algo_trials.dynamic_programming.matric_chain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixChainMultiplicationOOP {

  public static int mcm(int[] p) {
    // Map<Pair<MatrixStart, MatrixEnd>, CostOfMultiplication>
    Map<Map.Entry<Integer, Integer>, MatrixCost> map = new HashMap<>();

    List<MatrixCost> matrixCosts = MatrixCost.makePairs(p);

    return MatrixCost.minimumCost(matrixCosts, 0, matrixCosts.size() - 1, map).getCost();
  }
}
