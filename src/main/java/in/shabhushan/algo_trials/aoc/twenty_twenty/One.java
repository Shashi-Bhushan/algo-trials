package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class One {
  public static void main(String[] args) {
    int[] arr = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/1.txt"))
    ))
        .lines()
        .mapToInt(Integer::valueOf)
        .toArray();

    Map<Integer, Integer> indexMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int alt = 2020 - arr[i];

      if (indexMap.containsKey(alt)) {
        System.out.println(arr[i] + " " + alt);
      } else if (!indexMap.containsKey(arr[i])){
        indexMap.put(arr[i], i);
      }
    }

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i];

      for (int j = i + 1; j < arr.length; j++) {
        int alt = 2020 - (arr[i] + arr[j]);

        if (indexMap.containsKey(alt)) {
          System.out.println(arr[i] + " " + arr[j] + " " + alt);
        }
      }
    }
  }
}
