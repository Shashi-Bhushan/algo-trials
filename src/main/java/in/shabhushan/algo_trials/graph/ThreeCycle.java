package in.shabhushan.algo_trials.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

/**
 * 3 Cycle
 * Send Feedback
 * Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an graphEdge.
 * Input Format :
 * The first line of input contains two space separated integers, that denotes the value of N and M.
 * Each of the following M lines contain two integers, that denote the vertices which have an undirected graphEdge between them. Let us denote the two vertices with the symbol u and v.
 * Output Format :
 * Print the count the number of 3-cycles in the given graph
 * Constraints :
 * 0 <= N <= 100
 * 0 <= M <= (N*(N-1))/2
 * 0 <= u <= N - 1
 * 0 <= v <= N - 1
 * Time Limit: 1 sec
 * Sample Input 1:
 * 3 3
 * 0 1
 * 1 2
 * 2 0
 * Sample Output 1:
 * 1
 *
 * 2 1
 * 0 1
 *
 * => 0
 *
 * 6 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 *
 * => 1
 *
 * 6 9
 * 4 3
 * 4 0
 * 0 3
 * 3 1
 * 5 1
 * 5 3
 * 0 5
 * 0 2
 * 5 2
 *
 * => 4
 */
public class ThreeCycle {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static int solve(boolean[][] graph, int n) {
    /*
     * Your class should be named Solution
     * You may write your code here
     */

    int count = 0;

    for (int i = 0; i < graph.length; i++) {
      count += helper(graph, new boolean[graph.length], i, i, 0);
    }

    return count;
  }

  private static int helper(boolean[][] graph, boolean[] visited, int initialVertex, int vertex, int level) {
    if (level == 3) {
      return vertex == initialVertex ? 1 : 0;
    } else {
      int count = 0;

      for (int i = 0; i < graph[vertex].length; i++) if (visited[i] == false){
        visited[i] = true;
        count += helper(graph, visited, initialVertex, i, level + 1);
      }

      return count;
    }
  }

  public static boolean[][] takeInput() throws IOException {
    String[] strNums;
    strNums = br.readLine().split("\\s");
    int n = Integer.parseInt(strNums[0]);
    int m = Integer.parseInt(strNums[1]);

    boolean[][] graphs = new boolean[n][n];
    int firstvertex, secondvertex;

    for (int i = 0; i < m; i++) {
      String[] strNums1;
      strNums1 = br.readLine().split("\\s");
      firstvertex = Integer.parseInt(strNums1[0]);
      secondvertex = Integer.parseInt(strNums1[1]);
      graphs[firstvertex][secondvertex] = true;
      graphs[secondvertex][firstvertex] = true;
    }
    return graphs;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    boolean[][] graphs = takeInput();

    int ans = solve(graphs, graphs.length);
    System.out.println(ans);

  }
}
