package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;
import in.shabhushan.algo_trials.clrs.chapter22.utii.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exercise22_3_2 {

    // todo: add logger

    private static int time;

    // Map<Source -> Destination> Edge
    private static List<Map.Entry<Character, Character>> treeEdges = new ArrayList<>();
    private static List<Map.Entry<Character, Character>> forwardEdges = new ArrayList<>();
    private static List<Map.Entry<Character, Character>> crossEdges = new ArrayList<>();
    private static List<Map.Entry<Character, Character>> backEdges = new ArrayList<>();

    public static void main(String[] args) {
        log("22.3 Depthfirst search");

        AdjList<Character> graph = new AdjList<>(true);
        graph.addEdge('q', 's');
        graph.addEdge('q', 't');
        graph.addEdge('q', 'w');

        graph.addEdge('w', 's');
        graph.addEdge('s', 'v');
        graph.addEdge('v', 'w');

        graph.addEdge('t', 'x');
        graph.addEdge('t', 'y');
        graph.addEdge('x', 'z');
        graph.addEdge('z', 'x');
        graph.addEdge('y', 'q');
        graph.addEdge('r', 'u');
        graph.addEdge('r', 'y');
        graph.addEdge('u', 'y');

        // Initialize All vertex to Color.WHITE
        for (AdjListEntry<Character> u : graph.getVertices()) {
            u.setColor(Color.WHITE);
            u.setParent(null);
        }

        time = 0;
        treeEdges = new ArrayList<>();
        forwardEdges = new ArrayList<>();
        crossEdges = new ArrayList<>();
        backEdges = new ArrayList<>();

        for (AdjListEntry<Character> u : graph.getVertices()) {
            if (u.getColor() == Color.WHITE) {
                dfs(graph, u);
            }
        }

        graph.print();
        log("Tree Edges " + treeEdges);
        log("Back Edges " + backEdges);
        log("Forward Edges " + forwardEdges);
        log("Cross Edges " + crossEdges);
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u) {
        time = time + 1;
        u.setStartTime(time);
        u.setColor(Color.GREY);

        for (AdjListEntry<Character> v : graph.getEdges(u)) {
            if (v.getColor() == Color.WHITE) {
                treeEdges.add(Map.entry(u.getNode(), v.getNode()));

                v.setParent(u);
                dfs(graph, v);
            } else if (v.getColor() == Color.GREY) {
                backEdges.add(Map.entry(u.getNode(), v.getNode()));
            } else if (v.getColor() == Color.BLACK) {
                // if u is ancestor of v (i.e. vertexU comes first when traversing from root to vertexV; check Fig 22.6 vertexQ and vertexW), then it's forward graphEdge.
                // else it's cross graphEdge.
                // In other words (See Exercise 22.3-5), if u.startTime <  v.endTime
                //  Then, it's forward graphEdge
                // Else if v.endTime < u.startTime
                //  Then, it's cross graphEdge
                if (u.getStartTime() < v.getEndTime()) {
                    forwardEdges.add(Map.entry(u.getNode(), v.getNode()));
                } else if (v.getEndTime() < u.getStartTime()) {
                    crossEdges.add(Map.entry(u.getNode(), v.getNode()));
                }
            }
        }

        u.setColor(Color.BLACK);
        time = time + 1;
        u.setEndTime(time);
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
