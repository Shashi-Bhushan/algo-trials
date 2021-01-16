package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Three {
  public static void main(String[] args) {
    List<String> input = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/3.txt"))
    )).lines().collect(Collectors.toList());

    int n = input.size();

    int len = input.get(0).length();

    int count = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if(isTree(input.get(i).charAt(j))) {
        count++;
      }

      j += 3;

      if (j >= len) {
        j = j % len;
      }
    }

    System.out.println(count);

    // PART TWO
    int[][] slopes = {
        {1, 1}, // RIGHT, DOWN
        {3, 1},
        {5, 1},
        {7, 1},
        {1, 2}
    };

    int[] counts = new int[5];

    for (int s = 0; s < slopes.length; s++) {
      j = 0;
      count = 0;

      for (int i = 0; i < n; i += slopes[s][1]) {
        if(isTree(input.get(i).charAt(j))) {
          count++;
        }

        j += slopes[s][0];

        if (j >= len) {
          j = j % len;
        }
      }

      counts[s] = count;
    }

    System.out.println(Arrays.toString(counts));
  }

  private static boolean isTree(char c) {
    return c =='#';
  }
}
