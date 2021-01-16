package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Two {
  public static void main(String[] args) {
    Supplier<Stream<PasswordPolicy>> policies = () -> new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/2.txt"))
    )).lines().map(a -> {
      String[] s = a.split(":");

      String[] temp = s[0].trim().split(" ");

      String[] nums = temp[0].split("-");

      return new PasswordPolicy(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), temp[1].charAt(0), s[1].trim());
    });

    long filteredCount = policies.get().filter(a -> {
      int count = 0;

      for (int i = 0; i < a.pass.length(); i++) {
        if (a.ch == a.pass.charAt(i))
          count++;
      }

      return a.min <= count && count <= a.max;
    }).count();

    System.out.println(filteredCount);

    long secondFilteredCount = policies.get()
        .filter(a -> {
          int count = 0;

          if (a.min - 1 >= 0 && a.pass.charAt(a.min - 1) == a.ch) count++;


          if (a.max - 1 >= 0 && a.pass.charAt(a.max - 1) == a.ch) count++;

          return count == 1;
        }).count();

    System.out.println(secondFilteredCount);
  }

  private static class PasswordPolicy{
    int min;
    int max;
    char ch;
    String pass;

    public PasswordPolicy(int min, int max, char ch, String pass) {
      this.min = min;
      this.max = max;
      this.ch = ch;
      this.pass = pass;
    }
  }
}
