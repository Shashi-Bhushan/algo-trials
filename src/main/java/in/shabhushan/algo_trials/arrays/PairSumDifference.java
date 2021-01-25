package in.shabhushan.algo_trials.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSumDifference {
  public static int pairSumDifference(int[] A, int B) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : A) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    long count = 0;

    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {

      if (B == 0) {
        if (entry.getValue() > 1) count += 2;
      } else {
        if (map.containsKey(entry.getKey() + B)) {
          count++;
        }

        if (map.containsKey(entry.getKey() - B)) {
          count++;
        }
      }
    }

    int c = (int) (count / 2);
    int carry = (int) (count % 2);

    return c + carry;
  }
}
