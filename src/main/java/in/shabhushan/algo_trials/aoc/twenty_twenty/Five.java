package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Five {
  public static void main(String[] args) {
    Stream<Integer> integerStream = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/5.txt"))
    )).lines().map(a -> {
      int row = getRow(a, 0, 0, 127);
      int col = getColumn(a, 7, 0, 7);

      return row * 8 + col;
    });

    Set<Integer> set = integerStream.collect(Collectors.toSet());

    int max = set.stream().max(Integer::compareTo).get();

    System.out.println(max);

    for (int i = 0; i <= max; i++) {
      if (!set.contains(i) && set.contains(i - 1) && set.contains(i + 1)) {
        System.out.println(i);
        break;
      }
    }
  }

  private static int getRow(String s, int index, int low, int high) {
    if (low == high) {
      return low;
    } else {
      int mid = (((low + 1) + (high + 1)) / 2) - 1;

      if (s.charAt(index) == 'F') {
        return getRow(s, index + 1, low, mid);
      } else {
        return getRow(s, index + 1, mid + 1, high);
      }
    }
  }

  private static int getColumn(String s, int index, int low, int high) {
    if (low == high) {
      return low;
    } else {
      int mid = (((low + 1) + (high + 1)) / 2) - 1;

      if (s.charAt(index) == 'L') {
        return getColumn(s, index + 1, low, mid);
      } else {
        return getColumn(s, index + 1, mid + 1, high);
      }
    }
  }
}
