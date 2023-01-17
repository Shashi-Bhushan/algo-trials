package in.shabhushan.algo_trials.clrs.chapter23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static in.shabhushan.algo_trials.clrs.chapter23.Exercise23_2_Kruskal.getEdges;

public class Exercise23_2_Prim {
    /*
     * PRIM algo is O(V lg V)
     *
     * V for numEdgesInMST iteration
     * and log(V) for addition and removal in PriorityQueue
     */
    public static void main(String[] args) {
        // Using the PriorityQueue ADT
        primPriorityQueue();
    }

    private static void primPriorityQueue() {
        // num of vertices
        int n = 9;

        Exercise23_2_Kruskal.Edge[] edges = getEdges(14);

        // Map<Source, List<Destination, Edge Weight>>
        Map<Integer, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (Exercise23_2_Kruskal.Edge edge: edges) {
            map.get(edge.source).add(Map.entry(edge.dest, edge.weight));
            map.get(edge.dest).add(Map.entry(edge.source, edge.weight));
        }

        PriorityQueue<Exercise23_2_Kruskal.Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // initial vertex
        int vertex = 0;
        boolean[] visited = new boolean[n];
        visited[vertex] = true;

        int totalWeight = 0;
        int numEdgesInMST = 0;

        // n - 1 edges in MST
        // also queue will be empty at n - 1 step
        while (numEdgesInMST < n - 1) {
            for (Map.Entry<Integer, Integer> ed: map.get(vertex)) {
                if (visited[ed.getKey()] == false) {
                    queue.offer(new Exercise23_2_Kruskal.Edge(vertex + 'a', ed.getKey() + 'a', ed.getValue()));
                }
            }

            Exercise23_2_Kruskal.Edge minEdge = queue.poll();
            if (visited[minEdge.dest] == false) {
                visited[minEdge.dest] = true;

                System.out.println(minEdge);
                totalWeight += minEdge.weight;
                vertex = minEdge.dest;
                numEdgesInMST++;
            } else if (visited[minEdge.source] == false) {
                visited[minEdge.source] = true;

                System.out.println(minEdge);
                totalWeight += minEdge.weight;
                vertex = minEdge.source;
                numEdgesInMST++;
            }
        }

        System.out.println("Total Weight : " + totalWeight);
    }
}
