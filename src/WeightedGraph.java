import java.util.*;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> verticesByValue = new HashMap<>();
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    protected Vertex<V> getOrCreateVertex(V value) {
        return verticesByValue.computeIfAbsent(value, Vertex::new);
    }

    public void addEdge(V from, V to, double weight) {
        Vertex<V> fromVertex = getOrCreateVertex(from);
        Vertex<V> toVertex = getOrCreateVertex(to);
        fromVertex.addAdjacentVertex(toVertex, weight);
        if (!directed) {
            toVertex.addAdjacentVertex(fromVertex, weight);
        }
    }

    public Set<Vertex<V>> getVertices() {
        return new HashSet<>(verticesByValue.values());
    }

    public Set<Vertex<V>> adjacencyList(Vertex<V> vertex) {
        return vertex.getAdjacentVertices().keySet();
    }

    public double getWeight(Vertex<V> from, Vertex<V> to) {
        return from.getAdjacentVertices().getOrDefault(to, Double.POSITIVE_INFINITY);
    }

    public Vertex<V> getVertex(V value) {
        return verticesByValue.get(value);
    }

}