package in.shabhushan.algo_trials.aoc.twenty_twenty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Eleven {
  public static void main(String[] args) {
    List<String> collect = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(One.class.getClassLoader().getResourceAsStream("advent-of-code/2020/11.txt"))
    )).lines().collect(Collectors.toList());

    Grid grid = new Grid(collect.size(), collect.get(0).length());

    for (int i = 0; i < collect.size(); i++) {
      for (int j = 0; j < collect.get(i).length(); j++) {
        if (collect.get(i).charAt(j) == 'L') {
          grid.set(i, j, GridStatus.EMPTY);
        } else if (collect.get(i).charAt(j) == '#') {
          grid.set(i, j, GridStatus.FILLED);
        } else {
          grid.set(i, j, GridStatus.FLOOR);
        }
      }
    }

    Grid gridCopy = grid.clone();

    while (true) {
      Grid nextGrid = gridCopy.getNextSimulation();

      if (gridCopy.equals(nextGrid)) {
        System.out.println(gridCopy.count(GridStatus.FILLED));
        break;
      } else {
        gridCopy = nextGrid;
      }
    }

    gridCopy = grid.clone();

    while (true) {
      Grid nextGrid = gridCopy.getNextVisibleSimulation();

      if (gridCopy.equals(nextGrid)) {
        System.out.println(gridCopy.count(GridStatus.FILLED));
        break;
      } else {
        gridCopy = nextGrid;
      }
    }

  }

  private static class Grid {
    private static final int[][] adjacentLocations = {
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    private final GridStatus[][] grid;

    public Grid(int rows, int cols) {
      this.grid = new GridStatus[rows][cols];
    }

    private void set(int row, int col, GridStatus status) {
      this.grid[row][col] = status;
    }

    public void setEmpty(int row, int col) {
      set(row, col, GridStatus.EMPTY);
    }

    public void setFilled(int row, int col) {
      set(row, col, GridStatus.FILLED);
    }

    public void setFloor(int row, int col) {
      set(row, col, GridStatus.FLOOR);
    }

    public Grid getNextSimulation() {
      Grid nextGrid = new Grid(this.grid.length, this.grid[0].length);

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (this.grid[i][j] == GridStatus.EMPTY && countAdjacent(i, j) == 0) {
            nextGrid.setFilled(i, j);
          } else if (this.grid[i][j] == GridStatus.FILLED && countAdjacent(i, j) >= 4) {
            nextGrid.setEmpty(i, j);
          } else {
            nextGrid.set(i, j, this.grid[i][j]);
          }
        }
      }

      return nextGrid;
    }

    @Override
    public Grid clone() {
      Grid nextGrid = new Grid(this.grid.length, this.grid[0].length);

      for (int i = 0; i < grid.length; i++) {
        System.arraycopy(this.grid[i], 0, nextGrid.grid[i], 0, grid[i].length);
      }

      return nextGrid;
    }

    public Grid getNextVisibleSimulation() {
      Grid nextGrid = new Grid(this.grid.length, this.grid[0].length);

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (this.grid[i][j] == GridStatus.EMPTY && countAllVisible(i, j) == 0) {
            nextGrid.setFilled(i, j);
          } else if (this.grid[i][j] == GridStatus.FILLED && countAllVisible(i, j) >= 5) {
            nextGrid.setEmpty(i, j);
          } else {
            nextGrid.set(i, j, this.grid[i][j]);
          }
        }
      }

      return nextGrid;
    }

    private int countAdjacent(int row, int col) {
      int count = 0;

      for (int[] relativePos : adjacentLocations) {
        int newRow = row + relativePos[0];
        int newCol = col + relativePos[1];

        if (isWithinBounds(newRow, newCol) && this.grid[newRow][newCol] == GridStatus.FILLED) {
          count++;
        }
      }

      return count;
    }

    private int countAllVisible(int row, int col) {
      int count = 0;

      for (int[] relativePos : adjacentLocations) {
        int newRow = row;
        int newCol = col;

        while(true) {
          newRow  += relativePos[0];
          newCol += relativePos[1];

          if (isWithinBounds(newRow, newCol)) {
            if (this.grid[newRow][newCol] == GridStatus.EMPTY) {
              break;
            }

            if (this.grid[newRow][newCol] == GridStatus.FILLED) {
              count++;
              break;
            }
          } else {
            break;
          }
        }
      }

      return count;
    }

    private boolean isWithinBounds(int row, int col) {
      return 0 <= row && row < this.grid.length && 0 <= col && col < this.grid[0].length;
    }

    public int count(GridStatus status) {
      int count = 0;

      for (GridStatus[] gridStatuses : this.grid) {
        for (GridStatus gridStatus : gridStatuses) {
          if (gridStatus == status) {
            count++;
          }
        }
      }

      return count;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Grid)) {
        return false;
      }

      final Grid otherGrid = (Grid)obj;
      if (this.grid.length != otherGrid.grid.length || this.grid[0].length != otherGrid.grid[0].length) {
        return false;
      }

      for (int i = 0; i < this.grid.length; i++) {
        for (int j = 0; j < this.grid[i].length; j++) {
          if (this.grid[i][j] != otherGrid.grid[i][j]) {
            return false;
          }
        }
      }

      return true;
    }
  }

  private enum GridStatus {
    EMPTY,
    FILLED,
    FLOOR
  }
}


