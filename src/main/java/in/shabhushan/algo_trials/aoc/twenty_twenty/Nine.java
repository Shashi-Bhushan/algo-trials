package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Nine {
  private static final int PREAMBLE_SIZE = 25;

  public static void main(String[] args) {
    long[] input = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/9.txt"))
    )).lines().mapToLong(Long::parseLong).toArray();

    Set<Long> set = new HashSet<>();

    for (int i = 0; i < PREAMBLE_SIZE; i++) {
      set.add(input[i]);
    }

    long foundNumber = 0;

    for (int i = PREAMBLE_SIZE; i < input.length; i++) {
      long num = input[i];

      boolean found = false;

      for (int j = i - PREAMBLE_SIZE; j < i; j++) {
        if (set.contains(num - input[j])) {
          found = true;
          break;
        }
      }

      if (found) {
        set.remove(input[i - PREAMBLE_SIZE]);
        set.add(input[i]);
      } else {
        foundNumber = input[i];
        System.out.println(input[i]);
        break;
      }
    }

    int left = 0;
    int right = 0;

    int sum = 0;

    while (left <= right && right < input.length) {
      if (sum < foundNumber) {
        sum += input[right++];
      } else if (sum > foundNumber) {
        sum -= input[left++];
      } else {

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = left; i < right; i++) {
          min = Math.min(min, input[i]);
          max = Math.max(max, input[i]);
        }

        System.out.println(min + max);
        break;
      }
    }
  }
}
