package in.shabhushan.algo_trials.classical_algorithms;

import org.junit.Test;

import static in.shabhushan.algo_trials.classical_algorithms.MergeSort.mergeSort;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
  @Test
  public void testMergeSort() {
    int[] array = {3, 4, 8, 5, 6, 9};
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, mergeSort(array));
    assertArrayEquals(new int[]{1, 1, 2, 3, 3}, mergeSort(new int[]{1, 3, 2, 3, 1}));
  }

  @Test
  public void testMergeSort2() {
    int[] array = {3, 5, 9, 4, 8, 6};
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, mergeSort(array));
  }

  @Test
  public void testMergeSort3() {
    int[] array = {9, 8, 6, 5, 4, 3};
    assertArrayEquals(new int[]{3, 4, 5, 6, 8, 9}, mergeSort(array));
  }
}
