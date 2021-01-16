package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Six {
  public static void main(String[] args) {
    List<String> input = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/6.txt"))
    )).lines().collect(Collectors.toList());

    int[] freq = new int[26];

    int count = 0;

    for (String s : input) {
      if (s.isEmpty()) {
        for (int f: freq) count += f;

        freq = new int[26];
      } else {
        String trimmedStr = s.trim();

        for (int i = 0; i < trimmedStr.length(); i++) {
          freq[trimmedStr.charAt(i) - 'a'] = 1;
        }
      }
    }

    for (int f: freq) count += f;

    System.out.println(count);

    freq = new int[26];

    count = 0;
    int groupSize = 0;


    for (String s : input) {
      if (s.isEmpty()) {
        for (int f: freq) {
          // Add 1 to count now, only those "yes" who are equal to the groupSizes
          if (f == groupSize)
            count++;
        }

        groupSize = 0;
        freq = new int[26];
      } else {
        String trimmedStr = s.trim();
        groupSize++;

        for (int i = 0; i < trimmedStr.length(); i++) {
          freq[trimmedStr.charAt(i) - 'a']++;
        }
      }
    }

    for (int f: freq) {
      // Add 1 to count now, only those "yes" who are equal to the groupSizes
      if (f == groupSize)
        count++;
    }

    System.out.println(count);
  }
}
