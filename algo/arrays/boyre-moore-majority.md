## Boyer Moore Majority

Boyer Moore Majority voting algorithm is an optimal algo to find the majority element in array i.e. element having more than N/2 occurrences.
It works on the fact that if the element occurs more than N/2 times, then remaining elements would surely be less than N/2.

### Steps
1. Choose a candidate element
2. Traverse the array
   1. Increase the count/vote if candidate matches,
   2. Decrease count otherwise
   3. If count reaches 0, change the candidate to current element
3. Traverse the array again
   1. make sure that the ansIndex count is surely >= N/2
4. otherwise return -1.

| Complexity | Order |
|------------|-------|
| **TIME**   | O(N)  |
| **SPACE**  | O(1)  |

### References

1. [Leetcode Link](https://leetcode.com/problems/majority-element/)
2. [GeeksForGeeks Article](https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/)

### Code

```java
class Solution {
  public int majorityElement(int[] nums) {
    int n = nums.length;
    int count = -1;
    int ans = 0;

    // Step 1: get potential index with N/2 count
    for (int i = 0; i < n; i++) {
      if (nums[i] == nums[ans]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        ans = i;
        count = 1;
      }
    }

    // Step 2: Assert that count is indeed >= N/2
    count = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == nums[ans]) {
        count++;
      }

      if (count >= n/2) {
        return nums[ans];
      }
    }

    return -1;
  }
}
```

