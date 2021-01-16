package in.shabhushan.algo_trials.bits;

import java.util.Arrays;

public class Divide {
  public static int solve(int num) {
    int small = 0;
    int large = 0;

    boolean notSet = true;

    for (int i = 0; i < 32 && notSet; i++) {
      int bit = (1 << i);

      if ((num >> i) == 0 && notSet) {
        large = bit;
        notSet = false;
      }

      // if bit not set
      if ((num & bit) == 0 && notSet) {
        small = (small | bit);
      }
    }

    return small ^ large;
  }

  private int[] prefixSum;
  private int element;

  public static int solveArr(int[] arr, int element) {
    int s = 0;
    for (int i: arr) s += i;

    //if (s == element) return arr.length;

    int left = 0;
    int right = arr.length - 1;

    int ans = 0;

    int maxSum = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      int sum = 0;

      // calculate sum in first half
      for (int i = 0; i < mid; i++) {
        sum += arr[i];

        if (sum > element) {
          break;
        }
      }

      // if still less than or equal, calculate in second half
      if (sum <= element) {
        for (int i = mid; i < arr.length; i++) {
          sum += (-arr[i - mid] + arr[i]);

          if (sum > element) break;
        }
      }

      // if sum increased, then decrease boundary from the end
      if (sum > element) {
        right = mid - 1;
      } else {
        // else sum is at most what I need, calculate this answer and increase boundary
        ans = mid;
        left = mid + 1;
      }
      maxSum = Math.max(sum, maxSum);
    }

    return (s <= element && s >= maxSum) ? arr.length : ans;
  }
//
//  private int binarySearch() {
//    int left = 0;
//    int right = prefixSum.length - 1;
//
//    int ans = 0;
//
//    while (left <= right) {
//      int mid = left + (right - left) / 2;
//
//      if (found(mid)) {
//        ans = Math.max(ans, mid);
//        left = mid + 1;
//      } else {
//        right= mid - 1;
//      }
//    }
//
//    return ans;
//  }
//
//  private boolean found(int mid) {
//    // check each window from [0.mid] till [mid.end]
//    for (int i = mid; i < prefixSum.length; i++) {
//      if (element < prefixSum[i] - prefixSum[i - mid]) return false;
//    }
//
//    // no element found which voilates the constraint
//    return true;
//  }

  public static int searchMatrix(int[][] A, int B) {
    int row = search(A, B);

    int left = 0;
    int right = A[0].length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (A[row][mid] == B) {
        return 1;
      } else if (A[row][mid] < B) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return 0;
  }

  private static int search(int[][] mat, int element) {
    int left = 0;
    int right = mat.length - 1;

    int ans = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mat[mid][0] == element) {
        return mid;
      } else if (mat[mid][0] < element) {
        ans = Math.max(ans, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return ans;
  }

  public static long reverse(long a) {
    long ans = 0;

    for (int i = 0; i < 16; i++) {
      // bit is set
      if ((a & (1L << i)) > 0) {
        ans = (ans | (1L << (32 - i - 1)));
      }

      if ((a & (1L << (32 - i - 1))) > 0) {
        ans = (ans | (1 << i));
      }
    }

    System.out.println(Long.toBinaryString(a));
    System.out.println(Long.toBinaryString(ans));

    return ans;
  }

  public static int divide(int A,
                           int B) {

    if (B == 0) return Integer.MAX_VALUE;
    if (B == -1 && A == Integer.MIN_VALUE)
      return Integer.MAX_VALUE;

    boolean negate = (A >= 0 && B < 0) || (B >= 0 && A < 0);

    long dividend = Math.abs((long) A);
    long divisor = Math.abs((long) B);

    long carry = 0;

    long quotient = 0;

    for (int i = 31; i >= 0; i--) {
      if (carry + (divisor << i) != 0 && carry + (divisor << i) <= dividend) {
        carry = carry + (divisor << i);

        // set the quotient bit here
        quotient = quotient | (1L << i);
      }
    }

    if (!negate) {
      return (int) quotient;
    } else {
      return (int) (-1 * quotient);
    }
  }

  public static int divide2(long dividend,
                            long divisor) {

// Calculate sign of divisor
// i.e., sign will be negative
// only iff either one of them
// is negative otherwise it
// will be positive
    long sign = ((dividend < 0) ^
        (divisor < 0)) ? -1 : 1;

// remove sign of operands
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

// Initialize the quotient
    long quotient = 0, temp = 0;

// test down from the highest
// bit and accumulate the
// tentative value for
// valid bit
// 1<<31 behaves incorrectly and gives Integer
// Min Value which should not be the case, instead
    // 1L<<31 works correctly.
    for (int i = 31; i >= 0; --i) {

      if (temp + (divisor << i) != 0 && temp + (divisor << i) <= dividend) {
        temp += divisor << i;
        quotient |= 1L << i;
      }
    }

    return (int) (sign * quotient);
  }
}
