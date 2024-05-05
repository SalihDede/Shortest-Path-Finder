import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        /*
         * You need a CSV file and you need to Write your CSV file fileName.csv for input.
         */

         System.out.println("=======================================");
         System.out.println("|      Welcome Shortest Path Finder    |");
         System.out.println("=======================================");


        System.out.println("Initializing...");
        Thread.sleep(2000); // 2 sec

        // Get CSV file name
        System.out.print("Type your CSV file name: ");
        String csvFileName = scanner.nextLine();
        Thread.sleep(2000); // 2 sec

        System.out.println("Loading map and avaiable cities...\n");
        Thread.sleep(3000); // 3 sec

        // Create Graph and load a file.csv
        Graph graph = new Graph();
        GraphLoader.loadGraphFromCSV(graph, csvFileName);

        // Display available cities
        System.out.println("Available cities in the CSV file:");
        graph.getAdjacencyList().keySet().forEach(System.out::println);

        // Get start and end cities from the user
        System.out.print("\nType your start city: ");
        String startCity = scanner.nextLine();

        System.out.print("Type your end city: ");
        String endCity = scanner.nextLine();

        System.out.println("Finding the shortest path...");
        Thread.sleep(2000); // 2 sec


        // Check if the entered cities are valid
        if (!graph.getAdjacencyList().containsKey(startCity) || !graph.getAdjacencyList().containsKey(endCity)) {
            System.out.println("Invalid city names.");
            scanner.close();
            return;
        }

        // Find the shortest path with BFS
        long startTimeBFS = System.currentTimeMillis();
        ShortestPathWithBFS shortestPathBFS = new ShortestPathWithBFS(graph);
        PathWithDistance shortestPathResultBFS = shortestPathBFS.findShortestPath(startCity, endCity);
        long endTimeBFS = System.currentTimeMillis();
        long elapsedBFS = endTimeBFS - startTimeBFS;

        System.out.println("Path found!");
        Thread.sleep(2000); // 2 sec

        // Write Shortest path to the console BFS ones
        System.out.println("\nThe shortest path result with BFS Algorithm:");
        printPathWithDistance(shortestPathResultBFS);
        System.out.println("Time Taken by BFS --> " + elapsedBFS);


        // Find the shortest path with DFS
        long startTimeDFS = System.currentTimeMillis();
        ShortestPathWithBFS shortestPathDFS = new ShortestPathWithBFS(graph);
        PathWithDistance shortestPathResultDFS = shortestPathDFS.findShortestPath(startCity, endCity);
        long endTimeDFS = System.currentTimeMillis();
        long elapsedDFS = endTimeDFS - startTimeDFS;

        // Write Shortest path to the console DFS ones
        System.out.println("\nThe shortest path result with DFS Algorithm:");
        printPathWithDistance(shortestPathResultDFS);
        System.out.println("Time Taken by DFS --> " + elapsedDFS);
        scanner.close();


    }

    private static void printPathWithDistance(PathWithDistance pathWithDistance) {
        if (pathWithDistance.getDistance() != -1) {
            System.out.println("Path: " + pathWithDistance.getPath() + " --> Distance: " + pathWithDistance.getDistance() + " km");
        } else {
            System.out.println("X No path found X --> NO WAY!");
        }
    }
}
