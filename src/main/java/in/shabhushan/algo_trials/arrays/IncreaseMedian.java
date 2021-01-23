package in.shabhushan.algo_trials.arrays;

import java.util.Map;

/**
 * Given an array and a number of operations allowed on the array, maximize the median and return the value.
 * The only operation allowed is to increase the value of any element by 1.
 *
 * Eg.
 * 1, 1, 1, 1, 1, 2, 3, 4, 5 and B is 5
 * The maximum median possible in this case is with array
 * 1, 1, 1, 1, 3, 3, 3, 4, 5
 */
public class IncreaseMedian {
  public static int increaseMedian(int[] arr, int B) {
    int midIndex = arr.length / 2;

    int midValue = arr[midIndex];
    int nextElementIndex = getNextElement(arr, arr.length / 2);
    int nextElementVal = (nextElementIndex == arr.length) ? arr[arr.length - 1] : arr[nextElementIndex];
    int difference = nextElementVal - midValue;
    int distance = nextElementIndex - midIndex;

    while (B >= distance) {
      int operations = (difference == 0) ? distance * (B / distance) : distance * difference;

      if (difference != 0 && distance * difference <= B) {
        arr[midIndex] += difference;
      } else {
        arr[midIndex] += B/distance;
      }
      B -= operations;

      midValue = nextElementVal;
      nextElementIndex = getNextElement(arr, nextElementIndex);
      nextElementVal = (nextElementIndex == arr.length) ? arr[arr.length - 1] : arr[nextElementIndex];
      distance = nextElementIndex - midIndex;
      difference = nextElementVal - midValue;
    }

    return arr[midIndex];

  }

  private static int getNextElement(int[] arr, int index) {
    for (int i = index + 1; i < arr.length; i++) {
      if (arr[i] != arr[index]) return i;
    }

    return arr.length;
  }
}
