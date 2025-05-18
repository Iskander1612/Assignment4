import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V startValue) {
        super(graph.getVertex(startValue));
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : graph.adjacencyList(v)) {
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}