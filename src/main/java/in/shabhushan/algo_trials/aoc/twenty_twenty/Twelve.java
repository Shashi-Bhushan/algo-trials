package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Twelve {
  public static void main(String[] args) throws IOException {
    List<Map.Entry<Character, Integer>> input = Files.readAllLines(Path.of("src/main/resources/advent-of-code/2020/12.txt")).stream().map(line -> {
      char dir = line.charAt(0);

      int val = Integer.parseInt(line.substring(1));

      return Map.entry(dir, val);
    }).collect(Collectors.toList());

    Ship ship = new Ship();

    for (Map.Entry<Character, Integer> entry : input) {
      if (entry.getKey() == 'F') {
        ship.moveForward(entry.getValue());
      } else if (entry.getKey() == 'R') {
        ship.rotateRight(entry.getValue());
      } else if (entry.getKey() == 'L') {
        ship.rotateLeft(entry.getValue());
      } else if (entry.getKey() == 'N') {
        ship.y += entry.getValue();
      } else if (entry.getKey() == 'S') {
        ship.y -= entry.getValue();
      } else if (entry.getKey() == 'E') {
        ship.x += entry.getValue();
      } else if (entry.getKey() == 'W') {
        ship.x -= entry.getValue();
      }
    }

    System.out.println(Math.abs(ship.x) + " " + Math.abs(ship.y));
    System.out.println(Math.abs(ship.x) + Math.abs(ship.y));

    ship = new Ship();

    Map.Entry<Integer, Integer> waypoint = Map.entry(10, 1);

    for (Map.Entry<Character, Integer> entry : input) {
      if (entry.getKey() == 'L' || entry.getKey() == 'R') {
        waypoint = rotate(entry, waypoint);
      } else if (entry.getKey() == 'F') {
        ship.moveTowards(waypoint, entry.getValue());
      } else {
        waypoint = move(entry, waypoint);
      }
    }

    System.out.println(Math.abs(ship.x) + " " + Math.abs(ship.y));
    System.out.println(Math.abs(ship.x) + Math.abs(ship.y));
  }

  /**
   * Rotate waypoint around a certain direction by certain units
   */
  private static Map.Entry<Integer, Integer> rotate(Map.Entry<Character, Integer> entry, Map.Entry<Integer, Integer> waypoint) {
    int units = entry.getKey() == 'R' ? (-1 * entry.getValue()) : (entry.getValue());

    double angle = Math.toRadians(units);

    int x = (int)(waypoint.getKey() * Math.cos(angle)) - (int)(waypoint.getValue() * Math.sin(angle));
    int y = (int)(waypoint.getKey() * Math.sin(angle)) + (int)(waypoint.getValue() * Math.cos(angle));

    return Map.entry(x, y);
  }

  /**
   * Move waypoint towards a certain direction by certain units
   */
  private static Map.Entry<Integer, Integer> move(Map.Entry<Character, Integer> entry, Map.Entry<Integer, Integer> waypoint) {
    Integer units = entry.getValue();

    Integer x = waypoint.getKey();
    Integer y = waypoint.getValue();

    switch (entry.getKey()) {
      case 'N': {
        return Map.entry(x, y + units);
      }
      case 'S': {
        return Map.entry(x, y - units);
      }
      case 'E': {
        return Map.entry(x + units, y);
      }
      case 'W': {
        return Map.entry(x - units, y);
      }
    }

    return null;
  }

  private static class Ship {
    int x;
    int y;
    Direction dir;

    public Ship() {
      this(0,0);
    }

    public Ship(int x, int y) {
      this.x = x;
      this.y = y;
      this.dir = Direction.EAST;
    }

    public void moveForward(int value) {
      switch (dir) {
        case EAST: {
          x += value;
          break;
        }
        case WEST: {
          x -= value;
          break;
        }
        case NORTH: {
          y += value;
          break;
        }
        case SOUTH: {
          y -= value;
          break;
        }
      }
    }

    public void moveTowards(Map.Entry<Integer, Integer> waypoint, int units) {
      int dx = waypoint.getKey() * units;
      int dy = waypoint.getValue() * units;

      this.x = this.x + dx;
      this.y = this.y + dy;
    }

    public void rotateRight(int value) {
      // sanitize value
      value = value % 360;
      value = (this.dir.val + (value / 90)) % 4;

      this.dir = Direction.map.get(value);
    }

    public void rotateLeft(int value) {
      // sanitize value
      value = value % 360;
      value = (this.dir.val - (value / 90) + 4) % 4;

      this.dir = Direction.map.get(value);
    }
  }

  private enum Direction {
    EAST(0), SOUTH(1), WEST(2), NORTH(3);

    private final int val;
    public static Map<Integer, Direction> map = new HashMap<>();

    Direction(int val) {
      this.val = val;
    }

    static {
      for (Direction d: Direction.values()) {
        map.put(d.val, d);
      }
    }
  }

  //private static int[][] DIR =
}
