package in.shabhushan.algo_trials.clrs.chapter23.util;

import java.util.Objects;

public class GraphEdge<T extends Comparable<T>> {
    private T source;
    private T dest;
    private int weight;

    public GraphEdge(T source, T dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public T getSource() {
        return source;
    }

    public T getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphEdge<?> graphEdge = (GraphEdge<?>) o;
        return weight == graphEdge.weight && Objects.equals(source, graphEdge.source) && Objects.equals(dest, graphEdge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest, weight);
    }
}
