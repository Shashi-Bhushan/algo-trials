package in.shabhushan.algo_trials.classical_algorithms;

import java.util.Arrays;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.swap;

public class QuickSort {
  public static int[] quickSort(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    quickSort(copy, 0, copy.length - 1);

    return copy;
  }

  private static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partitionIndex = partition(arr, start, end);

      quickSort(arr, start, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, end);
    }
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];

    // idx is index of element from where elements are >= arr[end]
    int idx = start;

    for (int i = start; i < end; i++) {
      if (arr[i] < pivot) {
        swap(arr, idx, i);
        idx++;
      }
    }

    swap(arr, idx, end);

    return idx;
  }
}
