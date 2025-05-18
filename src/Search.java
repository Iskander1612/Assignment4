import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V value) {
        return marked.stream().anyMatch(v -> v.getData().equals(value));
    }

    public List<V> pathTo(V value) {
        Vertex<V> target = null;
        for (Vertex<V> v : marked) {
            if (v.getData().equals(value)) {
                target = v;
                break;
            }
        }
        if (target == null) return null;

        List<V> path = new ArrayList<>();
        for (Vertex<V> x = target; !x.equals(source); x = edgeTo.get(x)) {
            path.add(x.getData());
        }
        path.add(source.getData());
        Collections.reverse(path);
        return path;
    }
}
