package in.shabhushan.algo_trials.clrs.chapter23;

import java.util.Arrays;

public class Exercise23_2_Kruskal {
    public static void main(String[] args) {
        // Using Arrays
        kruskal();

        // Using the Union Find ADT
        // kruskalUnionFind();
    }

    private static void kruskal() {
        // num of vertices
        int n = 9;

        Edge[] edges = getEdges(14);
        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            // each node in it's own Union Set
            parents[i] = i;
        }

        Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        for (Edge edge: edges) {
            int p1 = findParent(parents, edge.source);
            int p2 = findParent(parents, edge.dest);

            if (p1 != p2) {
                parents[p1] = p2;
                System.out.println(edge);
            }
        }
    }

    // With path compression
    private static int findParent(int[] parents, int vertex) {
        int parent = vertex;

        while (parents[parent] != parent) {
            parents[parent] = parents[parents[parent]];
            parent = parents[parent];
        }

        return parent;
    }

    public static Edge[] getEdges(int n) {
        Edge[] edges = new Edge[n];
        edges[0] = new Edge('a', 'b', 4);
        edges[1] = new Edge('a', 'h', 8);
        edges[2] = new Edge('b', 'h', 11);
        edges[3] = new Edge('b', 'c', 8);
        edges[4] = new Edge('h', 'i', 7);
        edges[5] = new Edge('h', 'g', 1);
        edges[6] = new Edge('i', 'g', 6);
        edges[7] = new Edge('i', 'c', 2);
        edges[8] = new Edge('g', 'f', 2);
        edges[9] = new Edge('c', 'f', 4);
        edges[10] = new Edge('c', 'd', 7);
        edges[11] = new Edge('d', 'f', 14);
        edges[12] = new Edge('f', 'e', 10);
        edges[13] = new Edge('d', 'e', 9);

        return edges;
    }


    public static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source - 'a';
            this.dest = dest - 'a';
            this.weight = weight;
        }

        @Override
        public String toString() {
            return (char)(source + 'a') + "-" + (char)(dest + 'a') + " => Weight " + weight;
        }
    }
}
