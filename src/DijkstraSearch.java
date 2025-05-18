import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances = new HashMap<>();
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V startValue) {
        super(graph.getVertex(startValue));
        this.graph = graph;
        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            marked.add(current);

            for (Vertex<V> neighbor : graph.adjacencyList(current)) {
                double newDist = distances.get(current) + graph.getWeight(current, neighbor);
                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double getDistance(V value) {
        Vertex<V> v = graph.getVertex(value);
        return distances.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}