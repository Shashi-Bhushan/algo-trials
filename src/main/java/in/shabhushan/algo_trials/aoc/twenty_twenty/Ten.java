package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ten {
  private static Set<Long> set;
  private static long max;
  private static Map<Long, Long> memo;

  public static void main(String[] args) {
    long[] input = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/10.txt"))
    )).lines().mapToLong(Long::parseLong).toArray();

    set = new HashSet<>();
    max = 0;

    for (long i: input) {
      max = Math.max(max, i);
      set.add(i);
    }

    boolean keepRunning = true;
    long start = 0;

    long oneCount = 0;
    long threeCount = 0;

    OUTER:
    while (keepRunning) {
      for (long i = start + 1; i < start + 4; i++) {
        if (set.contains(i)) {
          if (start + 1 == i) {
            oneCount++;
          } else if (start + 3 == i) {
            threeCount++;
          }

          start = i;
          continue OUTER;
        }
      }

      keepRunning = false;
    }

    threeCount++;

    System.out.println(oneCount);
    System.out.println(threeCount);

    memo = new HashMap<>();

    System.out.println(dfs(0));
  }

  public static long dfs(long startIndex) {
    if (startIndex == max) return 1;
    else if (memo.containsKey(startIndex)) return memo.get(startIndex);
    else {
      long sum = 0;

      for (long i = startIndex + 1; i < startIndex + 4; i++) {
        if (set.contains(i)) {
          sum += dfs(i);
        }
      }

      memo.put(startIndex, sum);
      return sum;
    }
  }
}
