package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Four {
  public static void main(String[] args) {
    List<String> input = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/4.txt"))
    )).lines().collect(Collectors.toList());

    int count = 0;
    int ans = 0;

    for (String s: input) {
      if (s.isEmpty()) {
        if (count == 28) {
          ans++;
        }

        count = 0;
      } else {
        String[] str = s.split(" ");

        for (String a: str) {
          count += map.get(a.split(":")[0]);
        }
      }
    }

    if (count == 28) ans++;

    System.out.println(ans);

    // PART TWO

    count = 0;
    ans = 0;

    for (String s: input) {
      if (s.isEmpty()) {
        if (count == 28) {
          ans++;
        }

        count = 0;
      } else {
        String[] str = s.split(" ");

        for (String a: str) {
          String[] fields = a.split(":");

          String key = fields[0];

          if (key.equals("byr") && validDate(fields[1], 1920, 2000)) {
            count += map.get(fields[0]);
          } else if (key.equals("iyr") && validDate(fields[1], 2010, 2020)) {
            count += map.get(fields[0]);
          } else if (key.equals("eyr") && validDate(fields[1], 2020, 2030)) {
            count += map.get(fields[0]);
          } else if (key.equals("hgt") && validHeight(fields[1])) {
            count += map.get(fields[0]);
          } else if (key.equals("hcl") && validHairColor(fields[1])) {
            count += map.get(fields[0]);
          } else if (key.equals("ecl") && validEyeColor(fields[1])) {
            count += map.get(fields[0]);
          } else if (key.equals("pid") && validPassportId(fields[1])) {
            count += map.get(fields[0]);
          }
        }
      }
    }

    if (count == 28) ans++;

    System.out.println(ans);
  }

  private static boolean validDate(String date, int min, int max) {
    if (date.length() != 4) return false;
    else {
      int d = Integer.parseInt(date);

      return min <= d && d <= max;
    }
  }

  private static boolean validHeight(String height) {
    if (height.endsWith("cm")) {
      int heightCm = Integer.parseInt(height.substring(0, height.length() - 2));

      return 150 <= heightCm && heightCm <= 193;
    } else if (height.endsWith("in")) {
      int heightCm = Integer.parseInt(height.substring(0, height.length() - 2));

      return 59 <= heightCm && heightCm <= 76;
    } else {
      return false;
    }
  }

  private static boolean validHairColor(String hairColor) {
    if (hairColor.startsWith("#") && hairColor.length() == 7) {
      String colorCode = hairColor.substring(1);

      return (colorCode.chars().filter(a -> ('0' <= a && a <= '9') || ('a' <= a && a <= 'f')).count() == 6);
    } else {
      return false;
    }
  }

  private static boolean validEyeColor(String eyeColor) {
    return eyeColors.contains(eyeColor);
  }

  private static boolean validPassportId(String passportId) {
    return passportId.length() == 9;
  }

  private static final Set<String> eyeColors = Set.of("amb","blu","brn","gry","grn","hzl","oth");
  /**
   * byr (Birth Year)
   * iyr (Issue Year)
   * eyr (Expiration Year)
   * hgt (Height)
   * hcl (Hair Color)
   * ecl (Eye Color)
   * pid (Passport ID)
   * cid (Country ID)
   */
  private static final Map<String, Integer> map = Map.ofEntries(
      Map.entry("cid", 0),
      Map.entry("byr", 1),
      Map.entry("iyr", 2),
      Map.entry("eyr", 3),
      Map.entry("hgt", 4),
      Map.entry("hcl", 5),
      Map.entry("ecl", 6),
      Map.entry("pid", 7)
  );
}
