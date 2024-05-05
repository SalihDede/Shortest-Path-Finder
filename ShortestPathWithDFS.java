import java.util.*;

    // This class finds the shortest path between cities using Depth-First Search.
public class ShortestPathWithDFS {

    // The graph representing the cities and distances.
    private Graph graph;

    // Constructor to initialize the ShortestPathWithDFS object with a graph.
    public ShortestPathWithDFS(Graph graph) {
        this.graph = graph;
    }

    // Method to find the shortest path between two cities.
    public PathWithDistance findShortestPath(String startCity, String endCity) {
        // Initialize data structures for DFS
        Stack<List<String>> stack = new Stack<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        // Start with the initial path containing only the starting city
        List<String> initialPath = new ArrayList<>();
        initialPath.add(startCity);
        stack.push(initialPath);
        distances.put(startCity, 0);

        // Perform DFS
        while (!stack.isEmpty()) {
            List<String> currentPath = stack.pop();
            String currentCity = currentPath.get(currentPath.size() - 1);

            // Check if we reached the destination city
            if (currentCity.equals(endCity)) {
                return constructPathWithDistance(currentPath);
            }

            // Explore neighbors of the current city
            for (Map.Entry<String, Integer> neighbor : graph.getAdjacencyList().getOrDefault(currentCity, Collections.emptyMap()).entrySet()) {
                String neighborCity = neighbor.getKey();
                int distanceToNeighbor = distances.get(currentCity) + neighbor.getValue();

                // Update distance and previous city if a shorter path is found
                if (!distances.containsKey(neighborCity) || distanceToNeighbor < distances.get(neighborCity)) {
                    distances.put(neighborCity, distanceToNeighbor);
                    previous.put(neighborCity, currentCity);

                    // Add the neighbor city to the path and push for further
                    List<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighborCity);
                    stack.push(newPath);
                }
            }
        }

        // If there is no path from startCity to endCity
        return new PathWithDistance(Collections.emptyList(), -1);
    }

    // Helper method to construct a PathWithDistance object from a list of cities
    private PathWithDistance constructPathWithDistance(List<String> path) {
        // Calculate the total distance of the path
        int distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String fromCity = path.get(i);
            String toCity = path.get(i + 1);
            distance += graph.getAdjacencyList().get(fromCity).get(toCity);
        }
        // Return a PathWithDistance object with the path and distance
        return new PathWithDistance(new ArrayList<>(path), distance);
    }
}
