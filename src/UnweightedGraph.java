import java.util.*;

public class UnweightedGraph<V> extends WeightedGraph<V> {
    public UnweightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V from, V to) {
        super.addEdge(from, to, 1.0);
    }
}

