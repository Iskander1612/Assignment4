import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(UnweightedGraph<V> graph, V startValue) {
        super(graph.getVertex(startValue));
        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<V> graph, Vertex<V> current) {
        marked.add(current);
        for (Vertex<V> neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }
}