package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Seven {
  private static Map<String, List<Map.Entry<Integer, String>>> bags;

  private static Map<String, List<String>> parent;

  public static void main(String[] args) {
    // Map<BagColor, List<Pair<Quantity, BagColor>>
    bags = new HashMap<>();

    // Map<BagColor, List<Parent Colors>>
    parent = new HashMap<>();

    new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/7.txt"))
    )).lines().forEach(s -> {
      //String s = "light blue red bags contain 10 bright white bag, 32 muted yellow bags.";

      String[] c = s.split(" contain ");

      String bagColor = c[0].substring(0, c[0].indexOf(" bag"));

      List<Map.Entry<Integer, String>> contains = Arrays.stream(c[1].split("[, ][. ]")).map(a -> {
        String[] sp = a.split(" ");

        int quantity = (sp[0].equals("no")) ? 0 : Integer.parseInt(sp[0]);

        return Map.entry(quantity, String.join(" ", Arrays.copyOfRange(sp, 1, sp.length - 1)));
      }).collect(Collectors.toList());

      bags.put(bagColor, contains);

      contains.forEach(entry -> {
        if (!parent.containsKey(entry.getValue())) {
          parent.put(entry.getValue(), new ArrayList<>());
        }

        parent.get(entry.getValue()).add(bagColor);
      });
    });

    System.out.println(bags);
    System.out.println(parent);

    Set<String> visited = new HashSet<>();

    dfs(parent.get("shiny gold"), visited);

    System.out.println(visited.size());

    System.out.println(dfsSecond("shiny gold"));
  }

  private static void dfs(List<String> parents, Set<String> visited) {
    for (String p : parents) {
      if (!visited.contains(p)) {
        visited.add(p);

        List<String> pp = parent.get(p);

        if (pp != null) {
          dfs(pp, visited);
        }
      }
    }
  }

  private static int dfsSecond(String bag) {
    int sum = 0;

    for (Map.Entry<Integer, String> entry : bags.get(bag)) {
      sum += entry.getKey();

      if (!entry.getValue().equalsIgnoreCase("other")) {
        sum += (entry.getKey() * dfsSecond(entry.getValue()));
      }
    }

    return sum;
  }


}
