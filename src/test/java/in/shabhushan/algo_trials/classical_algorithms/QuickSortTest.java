package in.shabhushan.algo_trials.classical_algorithms;

import org.junit.Test;

import static in.shabhushan.algo_trials.classical_algorithms.QuickSort.quickSort;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
  @Test
  public void testquickSort() {
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, quickSort(new int[]{3, 4, 8, 5, 6, 9}));
    assertArrayEquals(new int[]{1, 1, 2, 3, 3}, quickSort(new int[]{1, 3, 2, 3, 1}));
    assertArrayEquals(new int[]{1, 1, 2, 3, 3}, quickSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10}));
  }

  @Test
  public void testquickSort2() {
    int[] array = {3, 5, 9, 4, 8, 6};
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, quickSort(array));
  }

  @Test
  public void testquickSort3() {
    int[] array = {9, 8, 6, 5, 4, 3};
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, quickSort(array));
  }
}
