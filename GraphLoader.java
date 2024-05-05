import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphLoader {

    // Load graph from target csv methode
    public static void loadGraphFromCSV(Graph graph, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the first line of the CSV file
            String line = br.readLine();

            // CSV file is empty
            if (line == null) {
                System.out.println("Error: CSV file is empty.");
                return;
            }

            // Split the first line for the city names
            String[] cities = line.split(",");

            // Read the remaining lines of the CSV file
            while ((line = br.readLine()) != null) {
                // Split lines into an array of values
                String[] values = line.split(",");
                String fromCity = values[0];

                // Get distances to other cities
                for (int i = 1; i < values.length; i++) {
                    String toCity = cities[i];
                    int distance = Integer.parseInt(values[i]);

                    // Add an edge to the graph if the distance is not 99999
                    if (distance != 99999) {
                        graph.addEdge(fromCity, toCity, distance);
                    }
                }
            }
        } catch (IOException e) {
            // Exception Handling
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
