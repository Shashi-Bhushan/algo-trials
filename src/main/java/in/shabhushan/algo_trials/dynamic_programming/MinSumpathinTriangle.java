package in.shabhushan.algo_trials.dynamic_programming;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinSumpathinTriangle {
  public static int minimumTotal(List<List<Integer>> a) {
    Queue<Integer> queue = new ArrayDeque<>();

    queue.offer(a.get(0).get(0));

    for (int i = 1; i < a.size(); i++) {
      for (int j = 0; j < i; j++) {
        int lastLevel = queue.poll();

        queue.offer(lastLevel + a.get(i).get(j));
        queue.offer(lastLevel + a.get(i).get(j + 1));
      }

      //System.out.println(queue);
    }

    int max = 0;

    for (int i: queue) {
      max = Math.max(max, i);
    }

    return max;
  }
}
