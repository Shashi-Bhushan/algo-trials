package in.shabhushan.algo_trials.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
  private static final int MOD = 1000_000_000 + 7;

  public static int pairSumHash(int[] A, int B) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : A) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int count = 0;

    for (int num : A) {
      int alt = B - num;

      if (map.containsKey(alt)) {
        count += map.get(alt);

        if (num == alt) {
          count--;
        }

        if (count >= MOD) {
          count = count % MOD;
        }
      }
    }

    return count / 2;
  }

  public static int pairSumArray(int[] A, int B) {
    int[] rem = new int[B];

    for (int i : A) {
      if (i < B) {
        int r = i % B;

        rem[r]++;

        if (rem[r] >= MOD) {
          rem[r] = rem[r] % MOD;
        }
      }
    }

    long count = 0;

    for (int i = 1; i < B / 2; i++) {
      if (rem[i] > 0 && rem[B - i] > 0) {
        count += (long) rem[i] * rem[B - i];

        if (count >= MOD) {
          count = count % MOD;
        }
      }
    }

    if (B % 2 == 0) {
      if (rem[B / 2] > 1) {
        count = count + ((long) rem[B / 2] * (rem[B / 2] - 1)) / 2;

        if (count >= MOD) {
          count = count % MOD;
        }
      }
    } else {
      if (rem[B / 2] > 0 && rem[B - B / 2] > 0) {
        count = count + ((long) rem[B / 2] * rem[B - B / 2]);

        if (count >= MOD) {
          count = count % MOD;
        }
      }
    }

    return (int) count;
  }
}
