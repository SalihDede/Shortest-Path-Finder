import java.util.HashMap;
import java.util.Map;

    // This class represents a graph with cities and distances between them.
public class Graph {

    // The adjacency list to store cities and their distances.
    private Map<String, Map<String, Integer>> adjacencyList;

    // Constructor to initialize a Graph object with an empty adjacency list.
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add an edge between two cities with a specified distance.
    public void addEdge(String fromCity, String toCity, int distance) {
        // Ensure both cities have entries in the adjacency list.
        adjacencyList.putIfAbsent(fromCity, new HashMap<>());
        adjacencyList.putIfAbsent(toCity, new HashMap<>());

        // Add the edge between the cities with the specified distance.
        adjacencyList.get(fromCity).put(toCity, distance);
        adjacencyList.get(toCity).put(fromCity, distance);
    }

    // Method to get the adjacency list of the graph.
    public Map<String, Map<String, Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}
