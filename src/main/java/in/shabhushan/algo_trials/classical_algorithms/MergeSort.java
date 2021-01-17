package in.shabhushan.algo_trials.classical_algorithms;

import java.util.Arrays;

public class MergeSort {
  public static int[] mergeSort(int[] array) {
    int[] copy = Arrays.copyOf(array, array.length);

    partitionHelper(copy, 0, copy.length - 1);

    return copy;
  }

  /**
   * end is inclusive
   */
  private static void partitionHelper(int[] arr, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;

      partitionHelper(arr, start, mid);
      partitionHelper(arr, mid + 1, end);

      mergeHelper(arr, start, mid, end);
    }
  }

  private static void mergeHelper(int[] arr, int start, int mid, int end) {
    int n1 = mid - start + 1;
    int n2 = end - mid;

    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++) left[i] = arr[start + i];
    for (int j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];

    int i = 0;
    int j = 0;

    for (int k = start; k <= end; k++) {
      if (j >= n2 || (i < n1 && left[i] <= right[j])) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
    }
  }
}
