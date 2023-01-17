package in.shabhushan.algo_trials.clrs.chapter23;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

        // Each Vertex has a weight/cost associated with it and parent pointer

        // Map<Source, Map<Destination, Edge Weight>>
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for (Exercise23_2_Kruskal.Edge edge: edges) {
            map.get(edge.source).put(edge.dest, edge.weight);
            map.get(edge.dest).put(edge.source, edge.weight);
        }

        // Queue<Pair<Vertex, Weight of Vertex>>
        // PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        // since queue requires a decreaseValue operation, hence PriorityQueue won't suffice here
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            queue.put(i, Integer.MAX_VALUE);
        }

        // initial vertex
        int vertex = 0; // take 'a' as initial vertex
        int totalWeight = 0;
        queue.put(vertex, 0); // set weight as o
        parents[vertex] = vertex;

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> minEntry = queue.pollFirstEntry();
            Integer vertexU = minEntry.getKey();
            Integer vertexUWeight = minEntry.getValue();

            totalWeight += vertexUWeight;
            System.out.println(String.format("%s -- %d -- %s", (char)(vertexU + 'a'), vertexUWeight, (char)(parents[vertexU] + 'a')));

            for (Map.Entry<Integer, Integer> neighbourEntry: map.get(vertexU).entrySet()) {
                Integer vertexV = neighbourEntry.getKey();
                Integer weightUToV = neighbourEntry.getValue();

                Integer weightInPriorityQueue = queue.get(vertexV);

                // vertexV is yet to be picked as minEntry (i.e. yet to be processed from queue)
                // and we've found an in-degree path with lesser weight to V
                if (queue.containsKey(vertexV) && weightUToV < weightInPriorityQueue) {
                    queue.put(vertexV, weightUToV);
                    parents[vertexV] = vertexU;
                }
            }
        }

        System.out.println("Total Weight : " + totalWeight);
    }
}
