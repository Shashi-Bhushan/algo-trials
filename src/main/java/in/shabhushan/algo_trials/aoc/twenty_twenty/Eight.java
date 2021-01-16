package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Eight {

  private static List<Map.Entry<String, Integer>> lines;

  public static void main(String[] args) {
    int lineNumber = 0;
    int acc = 0;

    lines = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/8.txt"))
    )).lines().map(a -> {
      String[] s = a.split(" ");

      int val = Integer.parseInt(s[1].substring(1));

      if (s[1].charAt(0) == '-') {
        val = -val;
      }

      return Map.entry(s[0], val);
    }).collect(
        Collectors.toList()
    );

    Set<Integer> visited = new HashSet<>();

    while (lineNumber < lines.size()) {
      if (visited.contains(lineNumber)) {
        break;
      } else {
        visited.add(lineNumber);
      }

      Map.Entry<String, Integer> line = lines.get(lineNumber);

      switch (line.getKey()) {
        case "nop":
          lineNumber++;
          break;
        case "acc":
          acc += line.getValue();
          lineNumber++;
          break;
        case "jmp":
          lineNumber += line.getValue();
          break;
      }
    }

    System.out.println(acc);

    System.out.println(dfs(0, 0, false, new HashSet<>()));
  }

  private static Map.Entry<Boolean, Integer> dfs(int lineNumber, int sum, boolean changed, Set<Integer> visited) {
    if (visited.contains(lineNumber)) {
      return Map.entry(false, 0);
    } else if (lineNumber == lines.size()){
      return Map.entry(true, sum);
    } else {
      Map.Entry<String, Integer> line = lines.get(lineNumber);

      Map.Entry<Boolean, Integer> response = null;

      visited.add(lineNumber);

      if (line.getKey().equals("acc")) {
        response = dfs(lineNumber + 1, sum + line.getValue(), changed, visited);
      } else if (line.getKey().equals("nop")) {
        // Treat this as NOP
        response = dfs(lineNumber + 1, sum, changed, visited);

        // were you not able to solve it as NOP ?
        // were you allowed to change the key
        if (!response.getKey() && !changed) {
          // Treat this as Jump
          response = dfs(lineNumber + line.getValue(), sum, true, visited);
        }
      } else if (line.getKey().equals("jmp")) {
        // Treat this as JMP
        response = dfs(lineNumber + line.getValue(), sum, changed, visited);

        // were you not able to solve it as JMP ?
        // were you allowed to change the key
        if (!response.getKey() && !changed) {
          // Treat this as NOP
          response = dfs(lineNumber + 1, sum, true, visited);
        }
      }

      visited.remove(lineNumber);

      return response;
    }
  }
}
