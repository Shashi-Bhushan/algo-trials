package in.shabhushan.algo_trials.clrs.chapter22;

import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjList;
import in.shabhushan.algo_trials.clrs.chapter22.utii.AdjListEntry;

import java.util.ArrayList;
import java.util.List;

import static in.shabhushan.algo_trials.clrs.chapter22.utii.Logger.log;

public class Exercise22_4_2 {

    private static AdjListEntry<Character> source;
    private static AdjListEntry<Character> target;
    private static List<List<AdjListEntry<Character>>> outputList;

    /**
     * Number of Simple paths from Source Vertex to Target Vertex
     *
     * Just do DFS from source to target and hold state of all nodes visited in dfs
     */
    public static void main(String[] args) {
        AdjList<Character> graph = new AdjList<>(true);
        graph.addEdge('m','x');
        graph.addEdge('m','q');
        graph.addEdge('m','r');
        graph.addEdge('q','t');
        graph.addEdge('n','q');
        graph.addEdge('n','u');
        graph.addEdge('n','o');
        graph.addEdge('u','t');
        graph.addEdge('r','u');
        graph.addEdge('r','y');
        graph.addEdge('o','r');
        graph.addEdge('o','v');
        graph.addEdge('o','s');
        graph.addEdge('p','o');
        graph.addEdge('p','s');
        graph.addEdge('p','z');
        graph.addEdge('v','w');
        graph.addEdge('v','x');
        graph.addEdge('y','v');
        graph.addEdge('s','r');
        graph.addEdge('w','z');

        source = graph.getVertex('p');
        target = graph.getVertex('v');
        outputList = new ArrayList<>();


        List<AdjListEntry<Character>> list = new ArrayList<>();
        list.add(source);

        dfs(graph, source, list);

        log("Simple Paths from " + source + " to " + target + " are " + outputList);
    }

    private static void dfs(AdjList<Character> graph, AdjListEntry<Character> u, List<AdjListEntry<Character>> list) {
        if (u.equals(target)) {
            outputList.add(new ArrayList<>(list));
        } else {
            for (AdjListEntry<Character> v: graph.getEdges(u)) {
                list.add(v);
                dfs(graph, v, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

